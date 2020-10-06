library(readxl)
ws01 <- read_excel("R-Data/data_ws01.xlsx", 
                   sheet = "Sheet1")

colSums(ws01[,c(3:5)]) # 열의 합
rowSums(ws01[,c(3:5)]) # 행의 합

ws01$sum <- rowSums(ws01[,c(3:5)])
ws01$mean <- rowMeans(ws01[,c(3:5)])

ws01

sum(ws01$국어)
ws01[,c(3:5)]

