(ns jenga.core
  (:gen-class)
  (:require [clojure.java.shell :as shell]))

(defn is-git-repo?
  "Is the directory part of a git repository?"
  [dir]
  (not (= 128 (:exit (shell/sh "git" "status" :dir dir)))))
