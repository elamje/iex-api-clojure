(ns lib.async
  (:require [org.httpkit.client :as http]))

(defn async-prices
  "query multiple prices async and concat results"
  [symbol-list]
  (for [symbol symbol-list] (let [resp1 (http/get (str "https://api.iextrading.com/1.0/stock/" symbol "/price"))))