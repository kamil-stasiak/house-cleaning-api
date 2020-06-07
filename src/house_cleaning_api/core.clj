(ns house-cleaning-api.core
  (:require [mount.core :as mount]
            ; TODO that initializing is not ok
            ; [house-cleaning-api.db]
            [house-cleaning-api.repl]
            [house-cleaning-api.http-server-reitit]
            [house-cleaning-api.db-init :refer [init-database]]))

(defn -main []
  (println "Starting application...")
  ; (init-database)
  (mount/start))
