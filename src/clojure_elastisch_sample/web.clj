(ns clojure-elastisch-sample.web
  (:use [compojure.core :only [defroutes GET]]
        [ring.adapter.jetty :only [run-jetty]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [clojure-elastisch-sample.controllers.search]
            [clojure-elastisch-sample.controllers.indexer]
            [clojure-elastisch-sample.views.layout :as layout]
            [clojure-elastisch-sample.views.home :as home]
            [clojure-elastisch-sample.views.about :as about]))

(defroutes routes
  (GET "/" [] (home/index))
  (GET "/about" [] (about/index))
  clojure-elastisch-sample.controllers.search/routes
  clojure-elastisch-sample.controllers.indexer/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))

(def application (handler/site routes))

(defn start [port]
  (run-jetty #'application {:port port :join? false}))


(defn -main [& args]
  (let [port (Integer. (or (System/getenv "PORT") 8080))]
    (start port)))