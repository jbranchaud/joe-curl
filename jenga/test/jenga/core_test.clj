(ns jenga.core-test
  (:require [clojure.test :refer :all]
            [jenga.core :refer :all]))

(deftest is-a-git-repo?
  (testing "test if a directory is part of a git repo"
    (is (is-git-repo? "/Users/jbranchaud/code/til"))
    (is (not (is-git-repo? "/Users/jbranchaud/code")))))
