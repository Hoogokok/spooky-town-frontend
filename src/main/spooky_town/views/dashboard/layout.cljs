(ns spooky-town.views.dashboard.layout
  (:require [re-frame.core :as rf]
            [spooky-town.views.dashboard.cards :refer [popular-contents upcoming-contents]]
            [spooky-town.views.dashboard.charts :refer [engagement-chart demographics-chart distribution-chart]]))

(defn header []
  [:div.flex.justify-between.items-center.mb-8
   [:h1.text-2xl.font-bold "호러/스릴러 콘텐츠 배포 현황"]
   [:div.flex.space-x-4
    [:button.px-4.py-2.bg-gray-800.!rounded-button.hover:bg-gray-700
     [:i.fas.fa-sync-alt.mr-2] "새로고침"]
    [:button.px-4.py-2.bg-gray-800.!rounded-button.hover:bg-gray-700
     [:i.fas.fa-th-large.mr-2] "위젯"]]])

(defn main-chart []
  [:div.col-span-8.bg-gray-800.rounded-lg.p-6
   [engagement-chart]])

(defn side-cards []
  [:div.col-span-4.space-y-6
   [popular-contents]
   [upcoming-contents]])

(defn demographics-section []
  [:div.col-span-6.bg-gray-800.rounded-lg.p-6
   [:h2.text-lg.font-medium.mb-6 "구독자 분포"]
   [demographics-chart]])

(defn distribution-section []
  [:div.col-span-6.bg-gray-800.rounded-lg.p-6
   [:h2.text-lg.font-medium.mb-6 "콘텐츠 카테고리"]
   [distribution-chart]])

(defn dashboard-layout []
  [:main.max-w-8xl.mx-auto.px-4.sm:px-6.lg:px-8.py-8
   [header]
   [:div.grid.grid-cols-12.gap-6
    [main-chart]
    [side-cards]
    [demographics-section]
    [distribution-section]]]) 