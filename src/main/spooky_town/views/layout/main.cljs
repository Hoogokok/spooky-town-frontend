(ns spooky-town.views.layout.main
  (:require [spooky-town.views.layout.nav :refer [nav]]))

(defn main-layout [content]
  [:div.min-h-screen.bg-gray-900.text-white
   [nav]
   [:main.max-w-8xl.mx-auto.px-4.sm:px-6.lg:px-8.py-8
    content]]) 