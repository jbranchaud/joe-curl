(ns euler.core-test
  (:require [clojure.test :refer :all]
            [euler.core :refer :all]
            [euler.problem-001 :refer :all]
            [euler.problem-002 :refer :all]
            [euler.problem-003 :refer :all]
            [euler.problem-004 :refer :all]))

(deftest problem-001-test
  (testing "Sum multiples of 3 and 5"
    (is (= 33 (problem-001 10)))
    (is (= 45 (problem-001 14)))
    (is (= 0  (problem-001 2)))
    (is (= 3  (problem-001 3)))
    (is (= 8  (problem-001 5)))))

(println (problem-001 999))

(deftest problem-002-test
  (testing "Sum even fibonacci numbers"
    (is (= 44 (problem-002 90)))
    (is (= 44 (problem-002 89)))
    (is (= 10 (problem-002 20)))))

(println (problem-002 4000000))

(deftest problem-003-test
  (testing "Find largest prime factor"
    (is (= 29 (problem-003 13195)))))

(println (problem-003 600851475143))

(deftest problem-004-test
  (testing "Largest 3-digit product palindrome"
    (is true)))

(println (problem-004))
