(ns house-cleaning-api.handlers
  (:require [house-cleaning-api.db :refer [ds]]
            [next.jdbc.sql :as sql]))

(defn count-admins []
  (get-in
   (sql/query ds ["select count(*) from admins"]) [0 :count]))

(count-admins)

(defn is-admin []
  (> (count-admins) 0))

(comment
  (is-admin)
  (sql/insert! ds :admins {:login "kamil" :password "password"}))
