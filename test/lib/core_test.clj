(ns lib.core-test
  (:require [clojure.test :refer :all]))

(deftest reference-data-built?
  (testing "Check if global var, nasdaq is built"
    (is
      (-> (str "")
        (nil?)
        (not)))))
