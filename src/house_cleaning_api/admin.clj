(ns house-cleaning-api.admin
  (:require [house-cleaning-api.db :refer [ds]]
            [next.jdbc.result-set :as rs]
            [next.jdbc.sql :as sql]))

(defn count-admins []
  (get-in
   (sql/query ds ["select count(*) from admins"])

   [0 :count]))

(defn is-admin []
  (> (count-admins) 0))

(defn get-all []
  (sql/query ds ["select * from admins"]
             {:return-keys true :builder-fn rs/as-unqualified-lower-maps}))

(comment
  (count-admins)
  (is-admin)
  (get-all)
  (sql/insert! ds :admins {:login "karol" :password "password"}))
