# reshape2 패키지

데이터의 행을 열로, 열을 행으로!

melt() & cast()

## melt() 함수

열을 행으로 전환 (가로로 긴 데이터 > 세로 길게)s

기준이 될 열을 `id.var` , 재배치할 열을 `measures.vars` 옵션을 사용하여 결정한다.
<center>melt(데이터세트, id.var = "기준 열", measure.vars = "변환 열")</center>

#### 함수 옵션

* data : melt() 함수로 변형할 데이터 세트 입력
* na.rm = FALSE : 결측치 제외옵션 (포함하려면 TRUE)
* value.name = "value" : 행으로 바꾸고 싶은 열 이름

### 사용해보기

#### 초기화 및 데이터 로드

```r
> install.packages("reshape2")
> library(reshape2)
> head(airquality)	#head()를 사용하여 데이터의 기본 구조를 파악할 수 있다
> tail(airquality) 	#tail()을 사용하면 마지막 6행을 확인할 수 있다
```

#### 변수명 대문자 변경

데이터값과 변수명 구분하기 위해 변수명을 대문자로 변경한다. `names()` 와 `toupper` 활용

```r
#변수이름 대문자로 변경, 소문자로 변경할 땐 'tolower' 사용
> names(airquality) <- toupper(names(airquality))
```

#### melt() 실행

```r
> m_test <- melt(airquality)
No id variables; using all as measure variables
> m_test
    variable value
1      OZONE  41.0
2      OZONE  36.0
3      OZONE  12.0
4      OZONE  18.0
5      OZONE    NA
.
.
.
[ reached 'max' / getOption("max.print") -- omitted 418 rows ]
```

> No id variables; ~ : 기준이 될 열을 지정하지 않아 모든 열을 반환한다는 내용



#### 월,일에 따른 온도 확인하기

```r
> m_atir <- melt(airquality, id.vars = c("MONTH","DAY"), measure.vars = "TEMP")
> m_atir
    MONTH DAY variable value
1       5   1     TEMP    67
2       5   2     TEMP    72
3       5   3     TEMP    74
4       5   4     TEMP    62
5       5   5     TEMP    56
```



## cast()함수

행을 열로 바꿔주는 함수 (세로로 긴 데이터 > 가로로 전환)

### dcast() 함수

<center>dcast(데이터 세트, 기준 열 ~ 변환 열)</center>



### acast() 함수

<center>acast(데이터 세트, 기준 열 ~ 분리 기준 열)</center>



# KoNLP & wordcloud

## Mac에서 KoNLP 설치하기

```r
install.packages("multilinguer")
library(multilinguer)
install_jdk()
install.packages(c('stringr', 'hash', 'tau', 'Sejong', 'RSQLite', 'devtools'), type = "binary")
install.packages("remotes")
remotes::install_github('haven-jeon/KoNLP',force = TRUE, upgrade = "never", INSTALL_opts=c("--no-multiarch"))
```

## 사전설정

```r
> library(KoNLP)  # KoNLP 패키지 로드
Checking user defined dictionary!

> useSystemDic()  # 시스템 사전 설정
Backup was just finished!
Error in `[.data.frame`(result_dic, , 2) : undefined columns selected

> useNIADic()     # NIADic 사전 설정
Backup was just finished!
1213109 words dictionary was built.

> useNIADic()     # NIADic 사전 설정
Backup was just finished!
1213109 words dictionary was built.
```

>  Error in `[.data.frame`(result_dic, , 2) : undefined columns selected

이건 무슨에런지 아무리 찾아봐도 안나온다. 재설치해도 똑같음.. 일단 되긴하니 패스

## 텍스트 로드 및 형태소 분석

```r
> wd <- readLines("./R-Data/news-20201008104523831.txt", encoding = "UTF-8")
> wd2 <- sapply(wd, extractNoun, USE.NAMES = F)
```

**sapply(데이터, 적용할 함수)** 

* extractNoun : 명사 추출

* USE.NAMES : 열 이름을 나타내는 옵션

## 행렬을 벡터로 변환

```r
> undata <- unlist(wd2)   # 행렬을 벡터로 변환
```

## 필터링

```r 
> undata2 <- Filter(function(x) {nchar(x) >= 2}, undata)  # 두 글자 이상인 형태소만 필터링
```

## 데이터 정렬

```r
> sort(word_table2, decreasing = T)
```

빈도 순 정렬



# wordcloud

## 기존 데이터 테이블 활용

```r
# install packages
install.packages("wordcloud2")
install.packages("wordcloud")
install.packages("tm")
install.packages("RCurl")
install.packages("RColorBrewer")
```

```r
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
          family = "AppleGothic" # 한글이 네모로 나올 경우 이 옵션 추가
          )
```

![cef513fb-5f31-4fe3-96d3-205dc1ac47cf](md-images/cef513fb-5f31-4fe3-96d3-205dc1ac47cf-2159286.png)

## 인터넷에서 크롤링

```r
html에서 읽기
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
```

>  java.lang.ArrayIndexOutOfBoundsException: Index 100000 out of bounds for length 100000

extractNoun 과정에서 위와 같은 에러 발생. 데이터가 처리되긴 하는데 결과값이 좀 이상함. 문서가 길어서 그런거라고 하는데 다른 방법을 써봐야 할듯



# Workshop

교재 p.248 - 249  `day03ws.R`

## 01.

`middle_mid_exam.xlsx` 를 `middle_mid_exam` 변수에 저장

```r
> library(readxl)
> library(reshape2)
> library(dplyr)

> middle_mid_exam <- read_excel("R-Data/middle_mid_exam.xlsx")
> middle_mid_exam                                                                     
# A tibble: 15 x 4
   CLASS     ID MATHEMATICS ENGLISH
   <chr>  <dbl>       <dbl>   <dbl>
 1 class1     1          50      50
 2 class1     2          90      80
 3 class1     3          95     100
 4 class1     4          60      60
 5 class1     5          80      80
```



## 02.

`dast()` 함수 활용하여 반별 수학점수(MATHEMATICS)와 영어 점수 (ENGLISH) 각각 나타내어라

```r
> temp1 <- middle_mid_exam %>% select(CLASS, ID, MATHEMATICS)
> MATHEMATICS <- dcast(temp1, ID ~ CLASS)
Using MATHEMATICS as value column: use value.var to override.
> MATHEMATICS
  ID class1 class2 class3
1  1     50    100     80
2  2     90     90     55
3  3     95     65     70
4  4     60     75     65
5  5     80     50     90

> temp2 <- middle_mid_exam %>% select(CLASS, ID, ENGLISH)
> ENGLISH <- dcast(temp2, ID ~ CLASS)
Using ENGLISH as value column: use value.var to override.
> ENGLISH
  ID class1 class2 class3
1  1     50     90     85
2  2     80     70     55
3  3    100     80     80
4  4     60     75     55
5  5     80     45     75
```

MATHEMATICS, ENGLISH 라는 변수 이름이 middle_mid_exam 에서 컬럼명으로 쓰이고 있다는 경고인듯.. 뒤에 문제에서 이 데이터 세트 쓰길래 그냥 진행



## 03.

`middle_mid_exam` 변수 활용하여 반별 영어점수의 평균과 합계, 반별 수학점수의 평균과 합계를 각각 구하라

```r
> middle_mid_exam %>% group_by(CLASS) %>% summarise(ENG_MEAN = mean(ENGLISH),
+                                                   ENG_SUM = sum(ENGLISH))
`summarise()` ungrouping output (override with `.groups` argument)
# A tibble: 3 x 3
  CLASS  ENG_MEAN ENG_SUM
  <chr>     <dbl>   <dbl>
1 class1       74     370
2 class2       72     360
3 class3       70     350

> middle_mid_exam %>% group_by(CLASS) %>% summarise(MATH_MEAN = mean(MATHEMATICS),
+                                                   MATH_SUM = sum(MATHEMATICS))
`summarise()` ungrouping output (override with `.groups` argument)
# A tibble: 3 x 3
  CLASS  MATH_MEAN MATH_SUM
  <chr>      <dbl>    <dbl>
1 class1        75      375
2 class2        76      380
3 class3        72      360
```



## 04.

`MATHEMATICS` 데이터 세트를 활용하여 **수학 점수가 80점 이상인 1반 학생 수**를 구하라

```r
> filter(MATHEMATICS, class1 >= 80) %>% summarise(n())
  n()
1   3
```



## 05.

`middle_mid_exam` 변수를 활용하여 **수학점수는 내림차순**으로 정렬하고, 수학점수가 같은 경우엔 **영어점수의 오름차순**으로 정렬하라

```r
> arrange(middle_mid_exam, desc(MATHEMATICS), ENGLISH)
# A tibble: 15 x 4
   CLASS     ID MATHEMATICS ENGLISH
   <chr>  <dbl>       <dbl>   <dbl>
 1 class2     1         100      90
 2 class1     3          95     100
 3 class2     2          90      70
 4 class3     5          90      75
 5 class1     2          90      80
 6 class1     5          80      80
 7 class3     1          80      85
 8 class2     4          75      75
 9 class3     3          70      80
10 class3     4          65      55
11 class2     3          65      80
12 class1     4          60      60
13 class3     2          55      55
14 class2     5          50      45
15 class1     1          50      50
```

## 06.

`middle_mid_exam` 변수를 활용하여 **수학 점수가 80점 이상이고 영어 점수가 85점 이상**인 학생 수를 구하라

```r
> middle_mid_exam %>% filter(MATHEMATICS >= 80, ENGLISH >= 85) %>% summarise(n())
# A tibble: 1 x 1
  `n()`
  <int>
1     3
```















