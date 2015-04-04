(ns jenga.core
  (:gen-class)
  (:require [clojure.java.shell :as shell]))

; TODO: create a mkdirs as necessary function

(defn is-git-repo?
  "Is the directory part of a git repository?"
  [dir]
  (not (= 128 (:exit (shell/sh "git" "status" :dir dir)))))

(defn git-init
  "Initialize a git repository"
  [dir]
  (if (is-git-repo? dir)
    false
    (= 0 (:exit (shell/sh "git" "init" :dir dir)))))
