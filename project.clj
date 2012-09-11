(defproject clojure-elastisch-sample "0.0.1-SNAPSHOT"
  :description "SearchBox.io clojure-elastisch sample application"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [ring/ring-jetty-adapter "1.1.4"]
                 [compojure "1.1.3"]
                 [hiccup "1.0.1"]
                 [clojurewerkz/elastisch "1.0.0-rc2"]]
  :min-lein-version "2.0.0"
  :main clojure-elastisch-sample.core)