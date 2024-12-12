(ns spooky-town.views.dashboard.engagement
  (:require [re-frame.core :as rf]))

(defn period-button [period text]
  (let [selected-period @(rf/subscribe [:dashboard/selected-period])]
    [:button.px-3.py-1.text-sm
     {:class (if (= period selected-period)
              "bg-yellow-500 text-black rounded-lg"
              "bg-gray-700 text-white rounded-lg hover:bg-gray-600")
      :on-click #(rf/dispatch [:set-period period])}
     text]))

(defn chart []
  (let [data @(rf/subscribe [:dashboard/engagement])]
    [:div#engagementChart.h-64]))

(defn engagement-overview []
  [:div.col-span-8.bg-gray-800.rounded-lg.p-6
   [:div.flex.justify-between.items-center.mb-6
    [:h2.text-lg.font-medium "참여도 개요"]
    [:div.flex.space-x-2
     [period-button "today" "오늘"]
     [period-button "week" "주간"]
     [period-button "month" "월간"]]]
   [chart]]) 