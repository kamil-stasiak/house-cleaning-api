(ns house-cleaning-api.core
  (:require [mount.core :as mount]
            [house-cleaning-api.db]
            [house-cleaning-api.repl]
            [house-cleaning-api.http-server-reitit]))

(defn -main []
  (println "Starting application...")
  (mount/start))
