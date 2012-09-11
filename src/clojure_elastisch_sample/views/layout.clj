(ns clojure-elastisch-sample.views.layout
  (:use [hiccup.core :only [html]]
        [hiccup.page :only [doctype include-css include-js]]
        [hiccup.form :only [form-to text-field]]))

(defn common [title & body]
  (html
    (doctype :html5 )
    [:head [:meta {:charset "utf-8"}]
     [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
     [:title title]
     (include-css "/css/bootstrap.min.css"
       "/css/main.css")
     (include-js "/js/bootstrap.min.js")]

    [:body [:div.navbar.navbar-fixed-top [:div.navbar-inner [:div.container [:a.brand {:href "/"} "SearchBox.io Clojure Sample"]
                                                             [:div.nav-collapse [:ul.nav [:li [:a {:href "/"} "Home"]]
                                                                                 [:li [:a {:href "/about"} "About"]]
                                                                                 ]
                                                              [:ul.nav.pull-right [:li.divider-vertical ]
                                                               (form-to {:class "navbar-search pull-left"} [:POST "/search"]
                                                                 (text-field {:placeholder "search" :class "search-query span2"} "q"))]
                                                              ]
                                                             ]
                                          ]
            ]
     [:div.container body
      [:hr ]
      [:footer.footer [:p "SearchBox.io"]
       [:p "Built with" [:a {:href "http://twitter.github.com/bootstrap"} "Bootstrap"]]]
      ]
     ]))


(defn four-oh-four []
  (common "Page Not Found"
    [:div {:id "four-oh-four"}
     "The page you requested could not be found"]))