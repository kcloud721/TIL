stavg <- function(){
  library(dplyr)

  st <- read.csv("/Users/jh/R-Data/test.txt", fileEncoding = "UTF-8")
  st <- melt(st, id.vars = "NAME")

  # onenote 참조

}
