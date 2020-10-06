library(readxl)

ex1 <- read_excel("R-Data/data_ex.xls")
ex1

ex11 <- read.table("R-Data/data_ex.txt", encoding="UTF-8")
ex11

ex12 <- read.table("R-Data/data_ex.txt", encoding="UTF-8", skip = 1)
colnames(ex12) <- c("ID", "SEX", "AGE", "ADDR")
ex12

ex13 <- read.table("R-Data/data_ex.csv", 
                   encoding="UTF-8", skip = 1, header=T, sep=",", stringsAsFactors = F)
ex13

