# 그래프에서 한글 표현 (Mac)

이전 수업의 wordcloud 를 사용할 때는 family="AppleGothic" 옵션을 추가하면 해결할 수 있었다. 하지만 함수마다 폰트 지정 옵션이 다르고 매번 찾아서 적용하는게 번거로워 글로벌 옵션? 을 변경하고자 함

1. Mac 터미널에서 Rprofile 생성

```bash
touch ~/.Rprofile
open ~/.Rprofile
```

2. 아래 내용 붙여넣기

```properties
setHook(packageEvent("grDevices", "onLoad"),
        function(...){
          if(capabilities("aqua"))
            grDevices::quartzFonts(
              sans =grDevices::quartzFont(rep("AppleGothic",5)),
              serif=grDevices::quartzFont(rep("AppleMyungjo",5)))
          grDevices::pdf.options(family="Korea1")
          grDevices::ps.options(family="Korea1")
        }
)
attach(NULL, name = "KoreaEnv")
assign("familyset_hook",
       function() {
         macfontdevs=c("quartz","quartz_off_screen")
         devname=strsplit(names(dev.cur()),":")[[1L]][1]
         if (capabilities("aqua") &&
             devname %in% macfontdevs)
           par(family="sans")
       },
       pos="KoreaEnv")
setHook("plot.new", get("familyset_hook", pos="KoreaEnv"))
setHook("persp", get("familyset_hook", pos="KoreaEnv"))
options(java.parameters=c("-Xmx8g", "-Dfile.encoding=UTF-8")
```

3. R 재부팅 하면 적용! 될 줄 알았는데 안되네? 이 방법은 plot 에만 적용되는 거고 지금 내가 쓰고자 하는건 treemap.. 이건 어쩔 수 없이 일일이 지정해줘야 하는 듯

```r
treemap(addr_count, index=".", vSize="Freq", title="서대문구 동별 치킨집 분표", fontfamily.labels="AppleGothic")
```



## ggplot2

[R에서 ggplot2 plot의 한글이 네모모양으로 깨질때](http://blog.daum.net/pingpu/13718306)

