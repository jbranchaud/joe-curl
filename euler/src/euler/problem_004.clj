; Project Euler - Problem 004
; https://projecteuler.net/problem=4

; A palindromic number reads the same both ways. The largest palindrome made
; from the product of two 2-digit numbers is 9009 = 91 × 99.

; Find the largest palindrome made from the product of two 3-digit numbers.

(ns euler.problem-004)

(defn is-palindrome?
  "Is the given string a palindrome?"
  [input]
  (= input (clojure.string/reverse input)))

(defn problem-003
  "Largest palindrome from product of 3 digit numbers"
  []
  (loop [first true
         x 999
         y 999]
    (let [curr (* x y)]
      (if (is-palindrome? (str curr))
        curr
        (if first
          (recur (not first) (dec x) y)
          (recur (not first) x (dec y)))))))
