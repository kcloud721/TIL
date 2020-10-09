library(readxl)
a1 <- function(){
  result <- c(3,3,3,3,3)
  return (result)
}
a2 <- function(){
  result <- read.csv("/Users/jh/R-Data/test.txt", header = T,
                     fileEncoding = "utf-8")
  return (result)
}
a3 <- function(){
  result <- c(3,3,3,3,3)
  return (result)
}

func1 <- function(x){
  if(x == 10){
    return (a1())
  } else if (x == 20){
    return (a2())
  } else if(x == 30){
    return (a3())
  } else{

  }
  print(100)
  return (10)
}

result <-func1(10)
result

# rm(list=ls())
# install.packages("Rserve")
# remove.packages("Rserve")
# install.packages('Rserve',,"http://rforge.net/",type="source")

#library(Rserve)
#Rserve::Rserve(args="--RS-enable-remote --no-save")

