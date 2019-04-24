(ns line-by-line.core
  (:gen-class)
  (:require [clojure.string :as str]))



(defn contains-error [line]
  (str/includes? line "[ERROR]"))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def lines (clojure.string/split (slurp "yarnContainerDetails.txt") #"\n"))
  (def error-lines (filter contains-error lines))
  (println error-lines)
  (println "Hello, World!"))
