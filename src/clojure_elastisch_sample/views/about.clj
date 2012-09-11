(ns clojure-elastisch-sample.views.about
  (:use [hiccup.core :only [html]])
  (:require [clojure-elastisch-sample.views.layout :as layout]))

(defn index []
  (layout/common "SearchBox.io Clojure Elastisch Sample"
    [:div [:h1 "About"]
     ]
    [:div.row [:div.span12 [:p "Sample Clojure Elastisch application that uses " [:a {:href "http://www.searchbox.io"} " SearchBox.io "]
                            "for full text search."]
               [:p "Feel free to copy, edit and use for your projects."]
               ]
     ]
    ))

