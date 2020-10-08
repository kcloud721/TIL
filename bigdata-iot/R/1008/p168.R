install.packages("reshape2")
rm(list=ls())
library(reshape2)
head(airquality)

#변수이름 대문자로 변경, 소문자로 변경할 땐 'tolower' 사용
names(airquality) <- toupper(names(airquality))

m_test <- melt(airquality)
m_test

#월일에 따른 온도 확인하기
m_atir <- melt(airquality, id.vars = c("MONTH","DAY"),
               measure.vars = "TEMP")
tail(m_atir)


#p.176
#학생별, 과목별 평균 구하기


