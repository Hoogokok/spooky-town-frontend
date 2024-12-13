(ns spooky-town.events
  (:require [re-frame.core :as rf]
            [spooky-town.db :as db]
            [spooky-town.views.dashboard.charts :refer [demographics-options]]))

;; 임시 데이터
(def mock-data
  {:engagement {:views 1234
               :likes 567
               :comments 89
               :chart-data {:today [820 932 901 934 1290 1330 1320]
                          :week [720 832 801 834 1190 1230 1220]
                          :month [620 732 701 734 1090 1130 1120]}}
   :popular [{:image "https://ai-public.creatie.ai/gen_page/horror1.jpg"
             :title "떠도는 그림자"
             :views "45.2천"
             :growth "23"}
            {:image "https://ai-public.creatie.ai/gen_page/horror2.jpg"
             :title "크림슨 이야기 #5"
             :views "32.8천"
             :growth "18"}]
   :demographics {:data [{:value 1048 :name "18-24"}
                        {:value 735 :name "25-34"}
                        {:value 580 :name "35-44"}
                        {:value 484 :name "45-54"}
                        {:value 300 :name "55+"}]}})

;; 앱 초기화 시 기본 DB 상태를 설정하는 이벤트
(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   (assoc db/default-db :dashboard mock-data)))

;; 로딩 상태를 변경하는 이벤트
(rf/reg-event-db
 :set-loading
 (fn [db [_ loading?]]
   (assoc db :loading? loading?)))

;; 현재 라우트를 설정하는 이벤트
(rf/reg-event-db
 :set-current-route
 (fn [db [_ route]]
   (assoc db :current-route route)))

;; 기존 이벤트에 추가
(rf/reg-event-fx
 :fetch-dashboard-data
 (fn [{:keys [db]} _]
   {:db (assoc db :loading? true)
    :dispatch-later [{:ms 1000
                     :dispatch [:set-mock-data]}]}))

(rf/reg-event-db
 :set-mock-data
 (fn [db _]
   (-> db
       (assoc :loading? false)
       (assoc :dashboard mock-data))))

(rf/reg-event-fx
 :refresh-dashboard
 (fn [_ _]
   {:dispatch [:fetch-dashboard-data]}))

(rf/reg-event-db
 :set-period
 (fn [db [_ period]]
   (-> db
       (assoc-in [:dashboard :selected-period] period)
       (assoc-in [:dashboard :engagement] nil))))  ;; 데이터 초기화

(rf/reg-event-db
 :api-error
 (fn [db [_ error-type error-message]]
   (assoc db :error {:type error-type
                     :message error-message
                     :timestamp (js/Date.now)})))

(rf/reg-event-db
 :clear-error
 (fn [db _]
   (dissoc db :error)))

;; 차트 관련 이벤트
(rf/reg-event-fx
 :init-engagement-chart
 (fn [{:keys [db]} _]
   {:db (assoc-in db [:dashboard :selected-period] "today")
    :dispatch [:update-engagement-chart "today"]}))

(rf/reg-event-db
 :update-engagement-chart
 (fn [db [_ period]]
   (let [chart-data (get-in mock-data [:engagement :chart-data period])]
     (-> db
         (assoc-in [:dashboard :selected-period] period)
         (assoc-in [:dashboard :chart-data] chart-data)))))

(rf/reg-event-db
 :set-period
 (fn [db [_ period]]
   (-> db
       (assoc-in [:dashboard :selected-period] period)
       (assoc-in [:dashboard :engagement] nil))))

;; 구독
(rf/reg-sub
 :selected-period
 (fn [db]
   (get-in db [:dashboard :selected-period])))

(rf/reg-sub
 :chart-data
 (fn [db]
   (get-in db [:dashboard :chart-data])))

;; 차트 관련 이벤트에 추가
(rf/reg-event-fx
 :init-demographics-chart
 (fn [{:keys [db]} _]
   {:db db
    :fx [[:init-chart ["demographicsChart" demographics-options]]]})) 