(ns spooky-town.events
  (:require [re-frame.core :as rf]
            [spooky-town.db :as db]))

;; 임시 데이터
(def mock-data
  {:engagement {:views 1234
               :likes 567
               :comments 89}
   :popular [{:image "https://ai-public.creatie.ai/gen_page/horror1.jpg"
             :title "떠도는 그림자"
             :views "45.2천"
             :growth "23"}
            {:image "https://ai-public.creatie.ai/gen_page/horror2.jpg"
             :title "크림슨 이야기 #5"
             :views "32.8천"
             :growth "18"}]})

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