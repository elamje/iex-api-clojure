(ns lib.core
  (:gen-class)
  (:require [lib.stock])
  (:require [lib.price :refer :all])
  (:import  [lib.stock Stock]))


(defn api
  "Call Api here"
  []
  (def stock (Stock. "apple" "AAPL" 12 11 13))
  (price false (get stock :symbol)))

(defn -main 
  "call something"
  [& args]
  (api))

