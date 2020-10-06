library(readxl)
library(dplyr)
library(psych)
library(descr)
y16 <- read_excel("R-Data/y16.xlsx")
y17 <- read_excel("R-Data/y17.xlsx")
typeof(y16)
typeof(y17)

y16 <- as.data.frame(read_excel("R-Data/y16.xlsx"))
y17 <- as.data.frame(read_excel("R-Data/y17.xlsx"))
typeof(y16)
typeof(y17)

y16
y17

r1 <- left_join(y16,y17,by="ID")
r1
r2 <- left_join(y17,y16,by="ID")
r2
r3 <- full_join(y16,y17,by="ID")
r3_2 <- inner_join(y16,y17,by="ID")
r4 <- full_join(y16,y17,by="ID")
r4

#결측값(NA) 처리 -> 0으로 바꿈
r3_2 <- r3
r3_2[is.na(r3_2)] = 0
r3_2

r3_2$SUM_AMT <- rowSums(r3_2[,c(2,7)])
r3_2$SUM_CNT <- rowSums(r3_2[,c(3,8)])
r3_2

r4$SUM_AMT <- rowSums(r4 %>% select(AMT17, AMT16), na.rm = T)
r4$SUM_CNT <- rowSums(r4 %>% select(Y17_CNT, Y16_CNT), na.rm = T)
r4

r4_2 <- r4 %>% group_by(AREA) %>% summarise(AVG_AMT=mean(SUM_AMT),
                                    AVG_CNT=mean(SUM_CNT))
r4_2$AREA <- ifelse(is.na(r4_2$AREA), 'NONE', r4_2$AREA)
r4_2 <- as.data.frame(r4_2)
r4_2 <- r4_2 %>% arrange(desc(AVG_AMT))
r4_2




install.packages("psych")
install.packages("descr")

r5 <- r3_2
describe(r5)

r5
# frequency: 빈도분석 
fq <- freq(r5$AREA, plot=T)
fq

# 히스토그램
hist(r5$AGE)

# 막대그래프
boxplot(r5$AGE)
