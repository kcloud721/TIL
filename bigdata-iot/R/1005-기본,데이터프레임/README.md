# R기본

데이터 구조 참고 ([링크](https://cceeddcc.tistory.com/2))

# 데이터 테이블

⭐️ R에서 가장 중요 ⭐️

자연스럽게 데이터를 표현하는 데이터 타입



## 데이터 프레임 다루기

데이터 분석하기 위해 데이터 프레임을 만듦

### 데이터 프레임 선언 및 출력

```r
> d1 <- data.frame(name=c("kim","lee","seo"),
                 ko=c(90,80,98),
                 en=c(100,78,92),
                 ma=c(99,68,88))
> d1
  name ko  en ma
1  kim 90 100 99
2  lee 80  78 68
3  seo 98  92 88
```

이렇게 코드로 넣을 수도 있고 import csv로 넣을 수도 있음

### str 출력

변수 속성 확인

```r
> str(d1)
'data.frame':	3 obs. of  4 variables:
 $ name: chr  "kim" "lee" "seo"
 $ ko  : num  90 80 98
 $ en  : num  100 78 92
 $ ma  : num  99 68 88
```

### 스칼라 타입으로 출력

```r
> dname <- d1$name
> dname
[1] "kim" "lee" "seo"
```

```r
> dko <- d1$ko
> dko
[1] 90 80 98
> mean(dko)
[1] 89.33333
```

`$` 로 값을 가져올 수 있다!

### 그외 다양한 출력 방법

```r
> d1
  name  ko  en ma
1  kim 100 100 99
2  lee  90  78 68
3  seo  99  92 88
> d1$ko[c(1,2)]
[1] 100  90
```



```r
> d1[-1,c("ko","en","ma")]
  ko en ma
2 90 78 68
3 99 92 88
```

첫 행은 제외하겠다! `-1`



```r
> d1[,c("ko")]
[1] 100  90  99
```

벡터형태로 출력 `[1]`



```r
> d1[,c("ko"),drop=F]
   ko
1 100
2  90
3  99
```

데이터 프레임형태로 출력 : `drop=F` 옵션 사용





## 값 수정

```r
> d1
  name ko  en ma
1  kim 90 100 99
2  lee 80  78 68
3  seo 98  92 88
> d1$ko <- c(100,90,99)
> d1
  name  ko  en ma
1  kim 100 100 99
2  lee  90  78 68
3  seo  99  92 88
```



## 값 추가

```r
> d1
  name  ko  en ma
1  kim 100 100 99
2  lee  90  78 68
3  seo  99  92 88
> d1$si <- c(90,80,88)
> d1
  name  ko  en ma si
1  kim 100 100 99 90
2  lee  90  78 68 80
3  seo  99  92 88 88
```



name, ko .. 는 컬럼명



# 데이터 입력

샘플데이터 [링크](https://github.com/newstars/HelloR)

## lib2rary(readxl)

### read_excel 

`xls` 파일을 로드

```r
> library(readxl)
> ex1 <- read_excel("R-Data/data_ex.xls")                                                                 
> ex1
# A tibble: 10 x 4
      ID SEX     AGE AREA 
   <dbl> <chr> <dbl> <chr>
 1     1 F        50 서울 
 2     2 M        40 경기 
 3     3 F        28 제주 
 4     4 M        50 서울 
 5     5 M        27 서울 
 6     6 F        23 서울 
 7     7 F        56 경기 
 8     8 F        47 서울 
 9     9 M        20 인천 
10    10 F        38 경기 

```



### read.table

`txt` 파일을 로드

1. `header = TRUE` : 헤더 따로 로드
2. `skip = 1` : 헤더 생략

```r
> ex12 <- read.table("R-Data/data_ex.txt", encoding="UTF-8", header = TRUE)
> ex12
   ID SEX AGE AREA
1   1   F  50 서울
2   2   M  40 경기
3   3   F  28 제주
4   4   M  50 서울
5   5   M  27 서울
6   6   F  23 서울
7   7   F  56 경기
8   8   F  47 서울
9   9   M  20 인천
10 10   F  38 경기
```

3. `colnames()` : 헤더 이름을 따로 지정

```r
> ex12 <- read.table("R-Data/data_ex.txt", encoding="UTF-8", skip = 1)
> colnames(ex12) <- c("ID", "SEX", "AGE", "ADDR")
> ex12
   ID SEX AGE ADDR
1   1   F  50 서울
2   2   M  40 경기
3   3   F  28 제주
4   4   M  50 서울
5   5   M  27 서울
6   6   F  23 서울
7   7   F  56 경기
8   8   F  47 서울
9   9   M  20 인천
10 10   F  38 경기
```





# WorkShop

## ws01.R

* 학번, 이름, 국어, 영어, 수학
* 10 명의 학생 정보를 엑셀에 기입
* R에서 data.frame으로 로드
* 각 학생의 성적 합과 평균을 데이터 프레임에 추가

```r
> library(readxl)
> ws01 <- read_excel("R-Data/data_ws01.xlsx",  sheet = "Sheet1")

> colSums(ws01[,c(3:5)]) # 열의 합
> rowSums(ws01[,c(3:5)]) # 행의 합

> ws01$sum <- rowSums(ws01[,c(3:5)])
> ws01$mean <- rowMeans(ws01[,c(3:5)])

> ws01
# A tibble: 10 x 7
   학번  이름    국어  영어  수학   sum  mean
   <chr> <chr>  <dbl> <dbl> <dbl> <dbl> <dbl>
 1 s001  조건부    10    50    80   140  46.7
 2 s002  산돌고    50    80    45   175  58.3
 3 s003  자동줄    84    98    15   197  65.7
 4 s004  페이지    82    65    98   245  81.7
 5 s005  레이아    84    25    32   141  47  
 6 s006  검토보    84    54    71   209  69.7
 7 s007  데이터    95    68    45   208  69.3
 8 s008  수식      23    59    75   157  52.3
 9 s009  입력      12    68    51   131  43.7
10 s010  그리기    84    55    52   191  63.7
```

#### **참고 문서**

* 행, 열 삭제 ([링크](https://lightblog.tistory.com/7))
* 열 통계, 그룹별 집계 ([링크](http://hleecaster.com/r-aggregates/))
* 행, 열 끼리 계산 ([링크](https://m.blog.naver.com/urimee_e/220670652017))



## ws02.R

* data.go.kr 또는 서울시에서 데이터 다운로드
* R에서 data.frame으로 로드

```r
library(readxl)
ws02 <- read.csv("R-Data/2020bus2.csv",
                 sep=",", head=TRUE, encoding="UTF-8")
view(ws02)
```

1. 2020년_버스노선별_정류장별_시간대별_승하차_인원_정보(08월).csv  ([링크](https://data.seoul.go.kr/dataList/OA-12913/S/1/datasetView.do))
2. VS Code에서 열고 UTF-8로 저장
3. R에서 위 코드 실행하여 로드

