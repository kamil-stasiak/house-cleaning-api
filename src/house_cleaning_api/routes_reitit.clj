(ns house-cleaning-api.routes-reitit
  (:require [house-cleaning-api.handlers :as h]))

; example route
(def routes
  ["/hello"
   {:get {:handler
          (fn [req]  {:status 200
                      :body "Hello world!"})}}
   ; not RESTful
   "/isAdmin" {:get {:handler h/is-admin}}])
