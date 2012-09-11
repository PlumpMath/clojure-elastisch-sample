(ns clojure-elastisch-sample.controllers.search
  (:use [compojure.core :only [defroutes POST]])
  (:require [clojure-elastisch-sample.views.search :as view]
            [clojurewerkz.elastisch.rest.document :as esd]
            [clojurewerkz.elastisch.rest.response :as esrsp]
            [clojurewerkz.elastisch.rest :as esr]))

(defn search [qparam]
  ;; connect to SearchBox ElasticSearch
  (esr/connect! (or (System/getenv "SEARCHBOX_URL") "http://api.searchbox.io/api-key/your-api-key"))

  (let [res (esd/search "tweets" "tweet" :query {:query_string {:query qparam}})
        hits (esrsp/hits-from res)]
    (view/index hits))
  )

(defroutes routes
  (POST "/search" {params :params} (search (get params :q ))))