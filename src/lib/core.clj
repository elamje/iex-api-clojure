(ns lib.core
  (:gen-class)
  (:require [lib.data]
            [lib.getdata :refer :all]
            [lib.transformations :refer :all])
  (:import  [lib.data Stock Price]))


(defn api
  "Call Api here"
  []
  (def price (Price. "aapl" (get-price "aapl")))
  (def apple (Stock. "apple" "AAPL" (get-price "aapl")))
  (def stats (get-stats "aapl"))
  (println apple)
  (get-stat stats "marketcap"))

(defn -main 
  "call something"
  [& args]
  (api))

