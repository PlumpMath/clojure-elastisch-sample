(ns clojure-elastisch-sample.controllers.indexer
  (:use [compojure.core :only [defroutes GET]])
  (:require [clojure-elastisch-sample.views.home :as view]
            [clojurewerkz.elastisch.rest :as esr]
            [clojurewerkz.elastisch.rest.index :as esi]
            [clojurewerkz.elastisch.rest.document :as esd]))

(defn index []
  ;; connect to SearchBox ElasticSearch
  (esr/connect! (or (System/getenv "SEARCHBOX_URL") "http://api.searchbox.io/api-key/your-api-key"))

  (if-not (esi/exists? "tweets")
    ;; create an index with all defaults if it is not exists
    ((esi/create "tweets")

    ;; create 2 new tweets under sample index
    (esd/create "tweets" "tweet" {:username "Tweety" :text "Tweety Bird (also known as Tweety Pie or simply Tweety) is a fictional Yellow Canary in the Warner Bros."})
    (esd/create "tweets" "tweet" {:username "Tom" :text "Thomas Tom Cat is a fictional character and the main protagonist in Metro-Goldwyn-Mayer's series of Tom and Jerry theatrical cartoon short films."})
    ))

  ;; go to home
  (view/index)
  )

(defroutes routes
  (GET "/index" [] (index)))