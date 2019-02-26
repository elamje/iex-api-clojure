(ns lib.core-test
  (:require [clojure.test :refer :all]))

(deftest reference-data-built?
  (testing "Check if global var, nasdaq is built"
    (is
      (-> nasdaq
        (resolve)         ;test if in global scope
        (nil?)
        (not)))))
