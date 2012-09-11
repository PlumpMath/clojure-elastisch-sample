(ns clojure-elastisch-sample.views.home
  (:use [hiccup.core :only [html]]
        [hiccup.page :only [doctype]])
  (:require [clojure-elastisch-sample.views.layout :as layout]))

(defn index []
  (layout/common "SearchBox.io Clojure Elastisch Sample"
    [:div {:class "row"}
     [:div {:class "span12"}
      [:div {:class " hero-unit"}
       [:h1 "SearchBox.io Sample Clojure Application"]
       [:p "This example illustrates basic search features of SearchBox.io (ElasticSearch as service)."]
       [:p "Sample application is using"
        [:a {:href "http://http://clojureelasticsearch.info/" :target "_blank"} " Elastisch "]
        "Clojure ElasticSearch client to integrate with SearchBox.io."
        ]
       [:p "To create initial index and sample data click"
        [:a {:href "/index"} " Create Sample Index&Data! "] "(2 sample documents will be created.) "
        ]
       [:p "Type '*' or 'tweety' or 'tom' to searchbox at top of right corner and hit enter for sample search results."]
       ]
      ]
     ]
    ))

