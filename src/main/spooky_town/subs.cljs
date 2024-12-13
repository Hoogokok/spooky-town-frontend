(ns spooky-town.subs
  (:require [re-frame.core :as rf]))

;; 앱 이름을 가져오는 구독
(rf/reg-sub
 :name
 (fn [db]
   (:name db)))

;; 로딩 상태를 가져오는 구독
(rf/reg-sub
 :loading?
 (fn [db]
   (:loading? db)))

;; 현재 라우트를 가져오는 구독
(rf/reg-sub
 :current-route
 (fn [db]
   (:current-route db)))

(rf/reg-sub
 :dashboard/engagement
 (fn [db]
   (get-in db [:dashboard :engagement])))

(rf/reg-sub
 :dashboard/popular
 (fn [db]
   (get-in db [:dashboard :popular])))

(rf/reg-sub
 :dashboard/selected-period
 (fn [db]
   (get-in db [:dashboard :selected-period])))

(rf/reg-sub
 :error
 (fn [db]
   (:error db))) 

(rf/reg-sub
 :loading?
 (fn [db]
   (:loading? db)))