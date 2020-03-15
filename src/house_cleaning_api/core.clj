(ns house-cleaning-api.core
  (:require [io.pedestal.http :as http]
            [mount.core :as mount]
            [nrepl.server :as nrepl]
            [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]
            [next.jdbc.connection :as connection]
            [io.pedestal.http.route :as route]))

(defn respond-hello [request]
  (println "Simple logging: Hello world endpoint executed!")
  {:status 200 :body "Hello, world!"})

(def routes
  (route/expand-routes
   #{["/greet" :get respond-hello :route-name :greet]}))

(defn create-server []
  (http/create-server
   {::http/routes routes
    ::http/type   :jetty
    ::http/port   8890}))

(def db {:dbtype "postgres"
         :dbname "postgres"
         :host "localhost"
         :port 5432
         :user "postgres"
         :password "abc123"})

(def ds (jdbc/get-datasource db))

(comment
  (jdbc/execute! ds ["
insert into address(id,name,email)
  values(, '; delete from address;','sean@corfield.org')"]))

(comment
  (sql/insert! ds :address
               {:id 18 :name "Name" :email "Surname"}))

; TODO on-reload noop
(mount/defstate ^{:on-reload :noop} repl-server
                :start
                (nrepl/start-server :port 7888)
                :stop
                (when repl-server
                  (nrepl/stop-server repl-server)))

(mount/defstate ^{:on-reload :noop} http-server
                :start
                (http/start (create-server))
                :stop
                (http/stop http-server))

(defn -main []
  (println "Starting application...")
  ; (server))
  (mount/start))
