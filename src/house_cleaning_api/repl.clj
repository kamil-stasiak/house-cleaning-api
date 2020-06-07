(ns house-cleaning-api.repl
  (:require   [mount.core :as mount]
              [nrepl.server :as nrepl]))

; TODO on-reload noop
(mount/defstate ^{:on-reload :noop} repl-server
                :start
                (nrepl/start-server :port 7888)
                :stop
                (when repl-server
                  (nrepl/stop-server repl-server)))


(+ 1 2)
