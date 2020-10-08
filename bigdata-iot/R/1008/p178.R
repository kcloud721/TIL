#----------------------------------------
# Mac OS에서 KoNLP 라이브러리 설치하기
#----------------------------------------
install.packages("multilinguer")
library(multilinguer)
install_jdk()
install.packages(c('stringr', 'hash', 'tau', 'Sejong', 'RSQLite', 'devtools'), type = "binary")
install.packages("remotes")
remotes::install_github('haven-jeon/KoNLP',force = TRUE, upgrade = "never", INSTALL_opts=c("--no-multiarch"))
#----------------------------------------
remove.packages("KoNLP")
install.packages("rJava")

library(KoNLP)  # KoNLP 패키지 로드
useSystemDic()  # 시스템 사전 설정
useSejongDic()  # 세종 사전 설정
useNIADic()     # NIADic 사전 설정

wd <- readLines("./R-Data/news-20201008104523831.txt", encoding = "UTF-8")
wd2 <- sapply(wd, extractNoun, USE.NAMES = F)

undata <- unlist(wd2)   # 행렬을 벡터로 변환
undata2 <- Filter(function(x) {nchar(x) >= 2}, undata)  # 두 글자 이상인 형태소만 필터링

word_table2 <- table(undata2)
word_table2

sort(word_table2, decreasing = T)


# Word cloud
install.packages("wordcloud2")
install.packages("wordcloud")
install.packages("tm")
install.packages("RCurl")
install.packages("RColorBrewer")

library(wordcloud)
library(tm)
library(RCurl)
library(RColorBrewer)
wordcloud2(word_table2)
wordcloud2(demoFreq)

palate <- brewer.pal(9,"Set1")
wordcloud(names(word_table2),
          freq = word_table2,
          scale = c(5,0,5),
          rot.per = 0.35,
          min.freq = 1,
          random.order = F,
          random.color = T,
          colors = palate,
          family = "AppleGothic"
          #family="KoPubWorld돋움체_Pro Medium"
          )


#html에서 읽기
library(wordcloud)
library(tm)
library(RCurl)
library(RColorBrewer)
wd <- readLines("https://www.nongmin.com/news/NEWS/FLD/CNT/327519/view",
          encoding = "UTF-8")
wd2 <- sapply(wd, extractNoun, USE.NAMES = F)
lwd
lwd <- unlist(wd2)
lwd <- gsub("[0-9]","",lwd)
lwd <- gsub("[a-z]","",lwd)
lwd <- gsub("[A-Z]","",lwd)
lwd <- gsub("\\W","",lwd)
lwd <- gsub(" ","",lwd)
lwd <- gsub("_","",lwd)
lwd <- gsub("__","",lwd)
lwd <- gsub("___","",lwd)

lwd2 <- Filter(function(x){
}, lwd)

wc <- table(lwd2)
wc
