(ns jenga.core-test
  (:require [clojure.test :refer :all]
            [jenga.core :refer :all]))

(deftest test-is-git-repo?
  (testing "test if a directory is part of a git repo"
    (is (is-git-repo? "/Users/jbranchaud/code/til"))
    (is (not (is-git-repo? "/Users/jbranchaud/code")))))

(deftest test-git-init
  (testing "test initialization of a git repo"
    (let [dir "/Users/jbranchaud/.jenga/repos/repo1"]
      (.mkdirs (java.io.File. dir))
      (is (git-init dir))
      (is (is-git-repo? dir)))))

; TODO: clean up repos/dirs after creation
