(ns house-cleaning-api.db-init
  (:require [next.jdbc :as jdbc]
            [house-cleaning-api.db :refer [ds]]))

(defn create-admins-table [] (jdbc/execute! ds ["
create table if not exists ADMINS (
login VARCHAR (255) primary key,
password varchar (255)
);"]))

(defn init-database [] (create-admins-table))
