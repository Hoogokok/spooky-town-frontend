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

(def demographics-options
  {:animation false
   :tooltip {:trigger "item"}
   :legend {:top "5%"
           :left "center"
           :textStyle {:color "#9CA3AF"}}
   :series [{:name "연령대별 구독자"
            :type "pie"
            :radius ["40%" "70%"]
            :avoidLabelOverlap false
            :itemStyle {:borderRadius 10
                       :borderColor "#1F2937"
                       :borderWidth 2}
            :label {:show false
                   :position "center"}
            :emphasis {:label {:show true
                             :fontSize "14"
                             :fontWeight "bold"}}
            :labelLine {:show false}
            :data [{:value 1048 :name "18-24" :itemStyle {:color "#F5BB1B"}}
                  {:value 735 :name "25-34" :itemStyle {:color "#60A5FA"}}
                  {:value 580 :name "35-44" :itemStyle {:color "#34D399"}}
                  {:value 484 :name "45-54" :itemStyle {:color "#F472B6"}}
                  {:value 300 :name "55+" :itemStyle {:color "#A78BFA"}}]}]})

(def distribution-options
  {:animation false
   :tooltip {:trigger "axis"
            :axisPointer {:type "shadow"}}
   :grid {:left "3%"
          :right "4%"
          :bottom "3%"
          :containLabel true}
   :xAxis [{:type "category"
            :data ["Movies" "Comics" "Art" "Events" "Games"]
            :axisTick {:show false}
            :axisLine {:lineStyle {:color "#4B5563"}}
            :axisLabel {:color "#9CA3AF"}}]
   :yAxis [{:type "value"
            :axisLine {:lineStyle {:color "#4B5563"}}
            :axisLabel {:color "#9CA3AF"}}]
   :series [{:name "Content Distribution"
            :type "bar"
            :barWidth "60%"
            :data [{:value 320 :itemStyle {:color "#F5BB1B"}}
                  {:value 280 :itemStyle {:color "#F5BB1B"}}
                  {:value 250 :itemStyle {:color "#F5BB1B"}}
                  {:value 220 :itemStyle {:color "#F5BB1B"}}
                  {:value 190 :itemStyle {:color "#F5BB1B"}}]}]})

(defn period-button [{:keys [period label selected?]}]
  [:button.period-button
   {:class (when selected? "active")
    :on-click #(rf/dispatch [:update-engagement-chart period])}
   label])

(defn period-selector []
  (let [current-period @(rf/subscribe [:selected-period])]
    [:div.period-selector
     [period-button 
      {:period "today" 
       :label "오늘"
       :selected? (= current-period "today")}]
     [period-button 
      {:period "week" 
       :label "주간"
       :selected? (= current-period "week")}]
     [period-button 
      {:period "month" 
       :label "월간"
       :selected? (= current-period "month")}]]))

(defn init-chart! [id options]
  (let [chart (.init js/echarts (.getElementById js/document id))]
    (.setOption chart (clj->js options))))

(defn update-chart! [id data]
  (when-let [chart (.getInstanceByDom js/echarts (.getElementById js/document id))]
    (.setOption chart (clj->js {:series [{:data data}]}))))

(defn engagement-chart []
  (let [chart-data @(rf/subscribe [:chart-data])]
    (rf/dispatch [:init-engagement-chart])
    (when chart-data
      (js/setTimeout #(update-chart! "engagementChart" chart-data) 0))
    [:div.chart-section
     [:div.chart-header
      [:h2.chart-title "채널별 배포 현황"]
      [period-selector]]
     [:div#engagementChart.chart-content]]))

(defn demographics-chart []
  (js/setTimeout #(init-chart! "demographicsChart" demographics-options) 0)
  [:div#demographicsChart.h-64])

(defn distribution-chart []
  (js/setTimeout #(init-chart! "distributionChart" distribution-options) 0)
  [:div#distributionChart.h-64]) 