# p.248 - 249
library(readxl)
library(reshape2)
library(dplyr)

#1
middle_mid_exam <- read_excel("R-Data/middle_mid_exam.xlsx")
middle_mid_exam

#2
temp1 <- middle_mid_exam %>% select(CLASS, ID, MATHEMATICS)
MATHEMATICS <- dcast(temp1, ID ~ CLASS)
MATHEMATICS

temp2 <- middle_mid_exam %>% select(CLASS, ID, ENGLISH)
ENGLISH <- dcast(temp2, ID ~ CLASS)
ENGLISH

#3
middle_mid_exam %>% group_by(CLASS) %>% summarise(ENG_MEAN = mean(ENGLISH),
                                                  ENG_SUM = sum(ENGLISH))
middle_mid_exam %>% group_by(CLASS) %>% summarise(MATH_MEAN = mean(MATHEMATICS),
                                                  MATH_SUM = sum(MATHEMATICS))

#4
filter(MATHEMATICS, class1 >= 80) %>% summarise(n())

#5
arrange(middle_mid_exam, desc(MATHEMATICS), ENGLISH)

#6
middle_mid_exam %>% filter(MATHEMATICS >= 80, ENGLISH >= 85) %>% summarise(n())
