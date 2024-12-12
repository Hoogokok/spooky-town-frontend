(ns spooky-town.views.dashboard
  (:require [re-frame.core :as rf]
            [spooky-town.views.dashboard.engagement :refer [engagement-overview]]
            [spooky-town.views.dashboard.popular :refer [popular-contents]]))

(defn header []
  [:div.flex.justify-between.items-center.mb-8
   [:h1.text-2xl.font-bold "공포 & 스릴러 콘텐츠 분석"]
   [:div.flex.space-x-4
    [:button.px-4.py-2.bg-gray-800.rounded-lg.hover:bg-gray-700
     {:on-click #(rf/dispatch [:refresh-dashboard])}
     [:i.fas.fa-sync-alt.mr-2] "새로고침"]
    [:button.px-4.py-2.bg-gray-800.rounded-lg.hover:bg-gray-700
     [:i.fas.fa-th-large.mr-2] "위젯"]]])

(defn main []
  (rf/dispatch-sync [:initialize-dashboard])
  [:div
   [header]
   [:div.grid.grid-cols-12.gap-6
    [engagement-overview]
    [popular-contents]]]) 