; Project Euler - Problem 004
; https://projecteuler.net/problem=4

; A palindromic number reads the same both ways. The largest palindrome made
; from the product of two 2-digit numbers is 9009 = 91 × 99.

; Find the largest palindrome made from the product of two 3-digit numbers.

(ns euler.problem-004)

(defn is-palindrome?
  "Is the given string a palindrome?"
  [input]
  (let [input (str input)]
    (= input (clojure.string/reverse input))))

; this solution terminates on a palindrome that isn't quite the largest
(defn problem-004-old
  "Largest palindrome from product of 3 digit numbers"
  [int1 int2]
  (loop [x int1
         y int2]
    (let [curr (* x y)]
      (if (is-palindrome? (str curr))
        curr
        (if (= x y)
          (recur (dec x) int2)
          (recur x (dec y)))))))

(problem-004-old 999 999)

; this solution works, it finds a few large palindromes and grabs the
; largest of them
(defn problem-004
  "Largest palindrome from product of 3 digit numbers"
  []
  (apply max
    (filter is-palindrome?
      (loop [x 999
             y 999
             pals []]
        (let [curr (* x y)]
          (if (and (< x 900) (< y 900))
            pals
            (if (= x y)
              (recur (dec x) 999 (conj pals curr))
              (recur x (dec y) (conj pals curr)))))))))

(problem-004)
