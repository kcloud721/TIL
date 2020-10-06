d1 <- data.frame(name=c("kim","lee","seo"),
                 ko=c(90,80,98),
                 en=c(100,78,92),
                 ma=c(99,68,88))
d1
str(d1)

dname <- d1$name
dname

dko <- d1$ko
dko
mean(dko)

d1
d1$ko <- c(100,90,99)
d1

d1
d1$si <- c(90,80,88)
d1

d1$ko[c(1,2)]

d1[1,1]
d1[-1,c("ko","en","ma")]

d1[,c("ko")]
d1[,c("ko"),drop=F]

View(d1)
