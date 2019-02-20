(ns lib.core
  (:gen-class)
  (:require [lib.data])
  (:require [lib.price :refer :all])
  (:import  [lib.data Stock]))


(defn api
  "Call Api here"
  []
  (def apple (Stock. "apple" "AAPL" (do (data "price" "aapl" false false)) 11 13))
  (println apple))

(defn -main 
  "call something"
  [& args]
  (api))

