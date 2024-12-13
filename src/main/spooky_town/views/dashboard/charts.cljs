(ns spooky-town.views.dashboard.charts
  (:require [re-frame.core :as rf]))

(def engagement-options
  {:animation false
   :grid {:left "3%"
          :right "4%"
          :bottom "3%"
          :containLabel true}
   :xAxis {:type "category"
           :data ["Mon" "Tue" "Wed" "Thu" "Fri" "Sat" "Sun"]
           :axisLine {:lineStyle {:color "#4B5563"}}
           :axisLabel {:color "#9CA3AF"}}
   :yAxis {:type "value"
           :axisLine {:lineStyle {:color "#4B5563"}}
           :axisLabel {:color "#9CA3AF"}}
   :series [{:data [820 932 901 934 1290 1330 1320]
            :type "line"
            :smooth true
            :lineStyle {:color "#F5BB1B"}
            :areaStyle {:color {:type "linear"
                              :x 0 :y 0 :x2 0 :y2 1
                              :colorStops [{:offset 0
                                          :color "rgba(245, 187, 27, 0.3)"}
                                         {:offset 1
                                          :color "rgba(245, 187, 27, 0.05)"}]}}}]})

(defn init-chart! [id options]
  (let [chart (.init js/echarts (.getElementById js/document id))]
    (.setOption chart (clj->js options))))

(defn engagement-chart []
  (rf/dispatch [:init-engagement-chart])
  [:div#engagementChart.h-64]) 