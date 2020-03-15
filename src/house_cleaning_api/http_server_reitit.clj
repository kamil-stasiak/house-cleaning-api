(ns house-cleaning-api.http-server-reitit
  (:require [io.pedestal.http :as server]
            [reitit.pedestal :as pedestal]
            [reitit.http :as http]
            [house-cleaning-api.routes-reitit :refer [routes]]
            [mount.core :as mount]))

(defn create-server []
  (-> {::server/type :jetty
       ::server/port 3000
       ::server/join? false
       ;; no pedestal routes
       ::server/routes []}
      (server/default-interceptors)
    ;; swap the reitit router
      (pedestal/replace-last-interceptor
       (pedestal/routing-interceptor
        (http/router routes)))
      (server/dev-interceptors)
      (server/create-server)))

(mount/defstate ^{:on-reload :noop} http-server
                :start
                (server/start (create-server))
                :stop
                (server/stop http-server))
