(ns algorithms.core-test
  (:require [clojure.test :refer :all]
            [algorithms.core :refer :all]))

(deftest swap-test
  (testing "Swap items in vec at i and j"
    (is (= [1 2 3 4] (swap [1 3 2 4] 1 2)))
    (is (= [5 4 6 7 8] (swap [8 4 6 7 5] 0 4)))
    (is (= [3 4 5 6] (swap [4 3 5 6] 1 0))))
  (testing "no swap on bad values of i and j"
    (is (= [1 2 3 4] (swap [1 2 3 4] 0 5)))
    (is (= [1 2 3 4] (swap [1 2 3 4] 5 2)))
    (is (= [1 2 3 4] (swap [1 2 3 4] -1 7)))))

(deftest insertion-sort-test
  (testing "Sort a vector with insertion sort"
    (is (= [1 2 3 4 5] (insertion-sort [5 4 3 2 1])))
    (is (= [] (insertion-sort [])))
    (is (= [1] (insertion-sort [1])))
    (is (= [1 2] (insertion-sort [1 2])))))
