(ns house-cleaning-api.http-server
  (:require [io.pedestal.http :as http]
            [mount.core :as mount]
            [house-cleaning-api.routes :refer [routes]]))

(defn create-server []
  (http/create-server
   {::http/routes routes
    ::http/type   :jetty
    ::http/port   8890}))

(mount/defstate ^{:on-reload :noop} http-server
                :start
                (http/start (create-server))
                :stop
                (http/stop http-server))
