(ns line-by-line.core
  (:gen-class)
  (:require [clojure.string :as str]))



(defn contains-error [line]
  (str/includes? line "[ERROR]"))


(defn -main
  "Filter for [ERROR] in the file"
  [& args]
  (def lines (clojure.string/split (slurp "yarnContainerDetails.txt") #"\n"))
  (def error-lines (set (filter contains-error lines)))
  (def joined-errors (str/join "\n" error-lines))
  (spit "errors.txt" joined-errors)
)
