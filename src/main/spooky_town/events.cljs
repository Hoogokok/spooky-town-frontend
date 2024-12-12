(ns spooky-town.events
  (:require [re-frame.core :as rf]
            [spooky-town.db :as db]))

;; 앱 초기화 시 기본 DB 상태를 설정하는 이벤트
(rf/reg-event-db
 :initialize-db
 (fn [_ _]
   db/default-db))

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
   {:db db
    :fx [[:dispatch [:fetch-engagement-data]]
         [:dispatch [:fetch-popular-contents]]
         [:dispatch [:fetch-demographics]]
         [:dispatch [:fetch-distribution]]]}))

(rf/reg-event-fx
 :fetch-engagement-data
 (fn [{:keys [db]} _]
   {:db db
    :http-xhrio {:method :get
                 :uri "/api/dashboard/engagement"
                 :params {:period (:selected-period db)}
                 :format :json
                 :response-format :json
                 :on-success [:set-engagement-data]
                 :on-failure [:api-error]}}))

(rf/reg-event-db
 :set-engagement-data
 (fn [db [_ data]]
   (assoc-in db [:dashboard :engagement] data)))

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

;; 기존 이벤트에 추가
(rf/reg-event-fx
 :initialize-dashboard
 (fn [{:keys [db]} _]
   {:db (assoc-in db [:dashboard :selected-period] "today")
    :dispatch [:fetch-dashboard-data]}))

(rf/reg-event-fx
 :refresh-dashboard
 (fn [_ _]
   {:dispatch [:fetch-dashboard-data]}))

(rf/reg-event-db
 :set-period
 (fn [db [_ period]]
   (-> db
       (assoc-in [:dashboard :selected-period] period)
       (assoc-in [:dashboard :engagement] nil))  ;; 데이터 초기화
   {:db db
    :dispatch [:fetch-dashboard-data]})) 