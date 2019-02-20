(ns lib.price
  "Get a real time price"
  (:require [org.httpkit.client :as http]))


(defn data 
  "Get Price, pass in [(asynch t/f)(symbol Stock.symbol)(type e.g. price)]"
  [type symbol async debug]
  (let [url (str "https://api.iextrading.com/1.0/stock/" symbol "/" type)]
  (if async
    ; asynchronous
    (http/get url {:timeout 400} 
      (fn [{:keys [status headers body error]}]
        (if error
          (println "Failed, exception: " error)
          (if debug (println "Async Price HTTP GET: " status " | " body)))
      body))
    ; synchronous with promise
    (let [{:keys [status headers body error] :as resp} @(http/get url)]
      (if error
        (println "Failed, exception: " error)
        (if debug (println "Sync Price HTTP GET: " status " | " body)))
    body))))