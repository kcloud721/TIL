library(readxl)
library(dplyr)

# 1
mid_exam <- as.data.frame(read_excel("R-Data/mid_exam.xlsx"))
mid_exam <- mid_exam %>% rename("MATH_MID"="MATH") %>% rename("ENG_MID"="ENG")
mid_exam

# 2
final_exam <- as.data.frame(read_excel("R-Data/final_exam.xlsx"))
final_exam <- final_exam %>% rename("MATH_FIANL"="MATH") %>% rename("ENG_FINAL"="ENG")
final_exam

# 3
total_exam <- inner_join(mid_exam,final_exam,by="ID")
total_exam

# 4
total_exam$MATH_AVG <- rowMeans(total_exam[,c(3,5)])
total_exam$ENG_AVG <- rowMeans(total_exam[,c(4,6)])
total_exam

# 5
total_exam$TOTAL_AVG <- rowMeans(total_exam[,c(3:6)])
total_exam

# 6
colMeans(total_exam[c(7)])
colMeans(total_exam[c(8)])

# 7
total_exam %>% filter(MATH_MID>=80, ENG_MID>=90)

# 8
boxplot(total_exam$MATH_AVG, total_exam$ENG_AVG)
