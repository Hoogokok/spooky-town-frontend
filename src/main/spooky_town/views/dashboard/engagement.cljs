(ns spooky-town.views.dashboard.engagement)

(defn period-button [active? text]
  [:button.px-3.py-1.text-sm
   {:class (if active?
            "bg-yellow-500 text-black rounded-lg"
            "bg-gray-700 text-white rounded-lg hover:bg-gray-600")}
   text])

(defn chart []
  [:div#engagementChart.h-64])

(defn engagement-overview []
  [:div.col-span-8.bg-gray-800.rounded-lg.p-6
   [:div.flex.justify-between.items-center.mb-6
    [:h2.text-lg.font-medium "참여도 개요"]
    [:div.flex.space-x-2
     [period-button true "오늘"]
     [period-button false "주간"]
     [period-button false "월간"]]]
   [chart]]) 