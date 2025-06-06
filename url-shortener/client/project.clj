(defproject url-shortener-client "0.1.0-SNAPSHOT"
  :description "CLI для общения с REST API"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [clj-http "3.12.3"]
                 [org.clojure/tools.cli "1.0.206"]]
  :main url-shortener.client.core)
