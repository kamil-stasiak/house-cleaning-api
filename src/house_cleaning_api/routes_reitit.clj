(ns house-cleaning-api.routes-reitit
  (:require [house-cleaning-api.handlers :as h]
            [clojure.data.json :as json]
            [house-cleaning-api.admin :as admin]))

; example route
(def routes
  [["/hello"
    {:get {:handler
           (fn [req]  {:status 200 :body "Hello world!"})}}]
   ; not RESTful
   ["/isAdmin"
    {:get {:handler
           (fn [req] {:status 200
                      :body {:isAdmin (h/is-admin)}
                      :headers {"Content-Type" "application/json"}})}}]
   ["/admins"
    {:get {:handler
           (fn [req] {:status 200
                      :body (json/write-str (admin/get-all))
                      :headers {"Content-Type" "application/json"}})}}]])
