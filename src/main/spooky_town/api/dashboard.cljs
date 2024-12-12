(ns spooky-town.api.dashboard
  (:require [spooky-town.api.core :refer [api-request]]))

(defn fetch-engagement-data [period]
  (api-request :get "/dashboard/engagement" 
              {:query-params {:period period}}))

(defn fetch-popular-contents []
  (api-request :get "/dashboard/popular"))

(defn fetch-demographics []
  (api-request :get "/dashboard/demographics"))

(defn fetch-distribution []
  (api-request :get "/dashboard/distribution")) 