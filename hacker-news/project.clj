(defproject hacker-news "0.1.0-SNAPSHOT"
  :description "hacker news top stories in the terminal"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [enlive "1.1.6"]]
  :main ^:skip-aot hacker-news.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
