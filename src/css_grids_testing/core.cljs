(ns css-grids-testing.core
    (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(defonce app-state (atom {:text "Hello world!"}))

(defn site-header []
  [:header.site-header
    "Header"])

(defn site-menu []
  [:aside.site-menu
    [:ul (map-indexed (fn [i item] ^{:key i} [:li item]) (range 10))]])

(defn site-content []
  [:section.site-main
    [:h1 (:text @app-state)]
    (map-indexed (fn [i item] ^{:key i} [:h1 item]) (range 1000))
    [:h3 "Edit this and watch it change!"]])

(defn site-footer []
  [:footer.site-footer
    (map-indexed (fn [i item] ^{:key i} [:p item]) (range 1000))])

(defn hello-world []
  [:div.site
   [site-header]
   [site-menu]
   [site-content]
   [site-footer]])

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload [])
