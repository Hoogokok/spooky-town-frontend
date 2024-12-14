(ns spooky-town.views.dashboard.engagement
  (:require [re-frame.core :as rf]))

(defn period-button [period text]
  (let [selected-period @(rf/subscribe [:dashboard/selected-period])]
    [:button.period-button
     {:class (when (= period selected-period) "active")
      :on-click #(rf/dispatch [:set-period period])}
     text]))

(defn chart []
  (let [data @(rf/subscribe [:dashboard/engagement])]
    [:div#engagementChart.chart-content]))

(defn engagement-overview []
  [:div.chart-section
   [:div.chart-header
    [:h2.chart-title "참여도 개요"]
    [:div.period-controls
     [period-button "today" "오늘"]
     [period-button "week" "주간"]
     [period-button "month" "월간"]]]
   [chart]]) 