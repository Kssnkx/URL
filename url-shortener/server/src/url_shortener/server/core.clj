(ns url-shortener.server.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [url-shortener.server.handlers :refer [app]])
  (:gen-class))

(defn -main [& args]
  (run-jetty app {:port 3000}))
