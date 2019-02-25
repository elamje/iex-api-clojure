(ns lib.getdata-test
  (:require [clojure.test :refer :all])
  (:require [lib.getdata :refer :all]
            [lib.transformations :refer :all]))

(def apple "aapl")

(deftest get-tests
  (testing "All data getters on Apple Inc."
    (is
      (-> apple
        (get-price true)
        (read-string)
        (number?)))
    (is
      (-> apple
        (get-stats)
        (string?)))
    (is
      (-> apple
        (get-company-name)
        (string?)))
    (is
      (-> apple
        (get-market-cap)
        (string?)))
    (is
      (-> apple
        (get-beta)
        (string?)))))

(deftest test-data-nasdaq
  (testing "Testing data builder"
    (is
      (-> "resources/NASDAQ.csv"
        (build-data)
        (symbols2map)
        (empty?)
        (not)))))

(deftest async-nasdaq-prices
  (testing "Testing all Nasdaq symbol prices async"
    (is (= 1 0))))
