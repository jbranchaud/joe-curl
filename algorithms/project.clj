(defproject algorithms "0.1.0-SNAPSHOT"
  :description "a variety of algorithms implemented in clojure"
  :url "http://example.com"
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot algorithms.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
