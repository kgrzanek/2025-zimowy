(require '[clojure.string :as str])

(->> "euler13.txt"
     slurp
     str/split-lines
     (map bigint)
     (reduce +')
     str
     (take 10)
     println)
