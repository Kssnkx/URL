(ns url-shortener.server.db
  (:require [korma.db :refer :all]
            [korma.core :refer :all])
  (:import [java.util UUID]))

(defdb db (sqlite3 {:db "urls.db"}))

(defentity urls)

(defn gen-short-url []
  (subs (str (UUID/randomUUID)) 0 6))

(defn save-url! [url]
  (let [short (gen-short-url)]
    (insert urls (values {:short short :url url}))
    short))

(defn get-url [short]
  (:url (first (select urls (where {:short short})))))

(defn update-url! [short new-url]
  (pos? (update urls (set-fields {:url new-url}) (where {:short short}))))

(defn delete-url! [short]
  (pos? (delete urls (where {:short short}))))
