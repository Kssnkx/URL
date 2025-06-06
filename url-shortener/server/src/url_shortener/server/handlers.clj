(ns url-shortener.server.handlers
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [url-shortener.server.db :as db]
            [ring.util.response :refer [response status]]))

(defroutes app
  (POST "/normal-url" [url]
        (let [short (db/save-url! url)]
          (response {:short-url short})))

  (GET "/:short" [short]
       (if-let [url (db/get-url short)]
         (response {:url url})
         (status (response "Not found") 404)))

  (PUT "/:short/:new" [short new]
       (if (db/update-url! short new)
         (status (response "Updated") 200)
         (status (response "Not found") 404)))

  (DELETE "/:short" [short]
          (if (db/delete-url! short)
            (status (response "Deleted") 200)
            (status (response "Not found") 404)))

  (route/not-found "Not Found")))
