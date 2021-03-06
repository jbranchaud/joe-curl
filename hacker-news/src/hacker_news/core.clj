(ns hacker-news.core
  (:gen-class)
  (:require [net.cgrand.enlive-html :as html]))

(defn tag-text
  ""
  [tag]
  (html/text tag))

(defn tag-href
  ""
  [tag]
  (:href (:attrs tag)))

(defn hn-dom
  ""
  []
  (html/html-resource
    (java.io.StringReader.
      (slurp "https://news.ycombinator.com"))))

(defn -main
  ""
  [& args]
  (doseq [link (html/select (hn-dom) [:tr.athing :td.title :a])]
    (println (tag-text link))
    (println (str "- " (tag-href link))))
)
