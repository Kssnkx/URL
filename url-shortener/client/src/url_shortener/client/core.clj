(ns url-shortener.client.core
  (:require [clj-http.client :as client])
  (:gen-class))

(defn -main [& args]
  (loop []
    (println "\nВыберите действие:\n1. Создать\n2. Показать\n3. Изменить\n4. Удалить\n5. Выйти")
    (let [choice (read-line)]
      (case choice
        "1" (do (println "Введите URL:") 
               (let [url (read-line)
                     resp (client/post "http://localhost:3000/normal-url"
                                       {:form-params {:url url}
                                        :as :json})]
                 (println "Короткий URL:" (:body resp)))
               (recur))
        "2" (do (println "Введите короткий URL:")
               (let [surl (read-line)
                     resp (client/get (str "http://localhost:3000/" surl) {:as :json})]
                 (println "Оригинальный URL:" (:body resp)))
               (recur))
        "3" (do (println "Введите короткий URL:") 
               (let [surl (read-line)
                     _ (println "Введите новый URL:")
                     new-url (read-line)
                     resp (client/put (str "http://localhost:3000/" surl "/" new-url))]
                 (println "Ответ:" (:status resp)))
               (recur))
        "4" (do (println "Введите короткий URL:")
               (let [surl (read-line)
                     resp (client/delete (str "http://localhost:3000/" surl))]
                 (println "Ответ:" (:status resp)))
               (recur))
        "5" (println "Выход...")
        (recur)))))
