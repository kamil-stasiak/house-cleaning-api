(ns house-cleaning-api.routes
  (:require [io.pedestal.http :as http]
            [mount.core :as mount]
            [io.pedestal.http.route :as route]))

; example route
(defn respond-hello [request]
  (println "Simple logging: Hello world endpoint executed!")
  {:status 200 :body "Hello, world!"})

(def routes
  (route/expand-routes
   #{["/greet" :get respond-hello :route-name :greet]}))
