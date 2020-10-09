library(ggplot2)
#jpeg(filename = "gg1.jpg", width = 300, height = 300, quality = 120)
ggplot(airquality, aes(x=Day, y=Temp))+
  geom_point(size=3, color="red") + geom_line

ggplot(mtcars, aes(x=cyl)) + geom_bar(width = 0.5, color = "blue")
ggplot(mtcars, aes(x=cyl)) + geom_bar(aes(fill=factor(gear)))
ggplot(mtcars, aes(x=cyl)) + geom_bar(aes(fill=factor(gear))) +
  labs(x="실린더", y="기어", title="차량정보")
# 데이터의 범주
factor(mtcars$cyl)
