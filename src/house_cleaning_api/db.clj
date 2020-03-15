(ns house-cleaning-api.db
  (:require [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql]
            [next.jdbc.connection :as connection]))

; TODO move to ENV
(def db {:dbtype "postgres"
         :dbname "postgres"
         :host "localhost"
         :port 5432
         :user "postgres"
         :password "abc123"})

; TODO add database conection pooling
(def ds (jdbc/get-datasource db))

(comment
  (jdbc/execute! ds ["
insert into address(id,name,email)
  values(, '; delete from address;','sean@corfield.org')"]))

(comment
  (sql/insert! ds :address
               {:id 40 :name "Name" :email "Email"}))
