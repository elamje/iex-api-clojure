(ns lib.async-test
  (:require [clojure.test :refer :all])
  (:require [lib.async :refer :all]))

(deftest async-price-test
  (testing "Get All nasdaq prices Async"
    (is
      (let [list (into [](take 2 nasdaq))]))))