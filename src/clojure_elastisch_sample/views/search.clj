(ns clojure-elastisch-sample.views.search
  (:use [hiccup.core :only [html]]
        [hiccup.page :only [doctype]])
  (:require [clojure-elastisch-sample.views.layout :as layout]))

(defn index [hits]
  (layout/common "Search Results"
    [:div.page-header [:h3 "Search Results"]]

    [:div.row [:div.span12 [:table.table.table-bordered [:thead [:tr [:td "Username"]
                                                                 [:td "Text"]
                                                                 ]]
                            [:tbody (for [hit hits] [:tr [:td (get (get hit :_source ) :username )]
                                                     [:td (get (get hit :_source ) :text )]
                                                     ]
                              )
                             ]
                            ]
               ]
     ]
    ))