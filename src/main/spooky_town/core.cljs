(ns spooky-town.core
  (:require [reagent.dom :as rdom]))

(defn app []
  [:div
   [:h1 "Hello, Spooky Town!"]])

(defn ^:export init []
  (rdom/render [app]
               (.getElementById js/document "app"))) 