(ns euler.core-test
  (:require [clojure.test :refer :all]
            [euler.core :refer :all]
            [euler.problem-001 :refer :all]))

(deftest problem-001-test
  (testing "Sum multiples of 3 and 5"
    (is (= 33 (problem-001 10)))
    (is (= 45 (problem-001 14)))
    (is (= 0  (problem-001 2)))
    (is (= 3  (problem-001 3)))
    (is (= 8  (problem-001 5)))))
