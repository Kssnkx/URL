(defproject url-shortener-server "0.1.0-SNAPSHOT"
  :description "REST API для сокращения URL"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring/ring-core "1.9.0"]
                 [ring/ring-jetty-adapter "1.9.0"]
                 [compojure "1.6.2"]
                 [korma "0.5.0"]
                 [org.xerial/sqlite-jdbc "3.34.0"]]
  :main url-shortener.server.core)
