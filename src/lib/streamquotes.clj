(ns lib.streamquotes
  (:require [org.httpkit.client :as http]))

(def api-hits-second 100)
(def num-streams 0)

(defn quote-stream
  "constantly pull from api to get latest price, print on price change"
  [symbol life-length]
  (let [url (str "https://api.iextrading.com/1.0/stock/" symbol "/price")]
    @(http/get url {:keepalive life-length}) ;persist idle connections for 60 seconds
    @(http/get url)))
  
    

(defn close-quote-stream
  "close stream of updates"
  []
  ())

