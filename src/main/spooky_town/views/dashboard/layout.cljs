(ns spooky-town.views.dashboard.layout
  (:require [re-frame.core :as rf]))

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
   [:div.flex.justify-between.items-center.mb-6
    [:h2.text-lg.font-medium "채널별 배포 현황"]
    [:div.flex.space-x-2
     [:button.px-3.py-1.bg-custom.!rounded-button.text-black.text-sm "오늘"]
     [:button.px-3.py-1.bg-gray-700.!rounded-button.text-sm "주간"]
     [:button.px-3.py-1.bg-gray-700.!rounded-button.text-sm "월간"]]]
   [:div#engagementChart.h-64]])

(defn side-cards []
  [:div.col-span-4.space-y-6
   ;; 실제 카드 컴포넌트들은 다음 단계에서 구현
   [:div.bg-gray-800.rounded-lg.p-6
    [:h2.text-lg.font-medium.mb-4 "인기 배포 콘텐츠"]]
   [:div.bg-gray-800.rounded-lg.p-6
    [:h2.text-lg.font-medium.mb-4 "예정된 콘텐츠"]]])

(defn dashboard-layout []
  [:main.max-w-8xl.mx-auto.px-4.sm:px-6.lg:px-8.py-8
   [header]
   [:div.grid.grid-cols-12.gap-6
    [main-chart]
    [side-cards]]]) 