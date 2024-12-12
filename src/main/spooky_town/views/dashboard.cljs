(ns spooky-town.views.dashboard)

(defn header []
  [:div.flex.justify-between.items-center.mb-8
   [:h1.text-2xl.font-bold "공포 & 스릴러 콘텐츠 분석"]
   [:div.flex.space-x-4
    [:button.px-4.py-2.bg-gray-800.rounded-lg.hover:bg-gray-700
     [:i.fas.fa-sync-alt.mr-2] "새로고침"]
    [:button.px-4.py-2.bg-gray-800.rounded-lg.hover:bg-gray-700
     [:i.fas.fa-th-large.mr-2] "위젯"]]])

(defn main []
  [:div
   [header]]) 