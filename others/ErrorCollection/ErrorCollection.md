# ⚠️ Error

## Maven Update : 401 Unauthorized

### 에러내용

```bash
[ERROR] Failed to execute goal on project cgi-dmt-api: Could not resolve dependencies for project com.ccc:project:jar:1.0-SNAPSHOT: Failed to collect dependencies at com.ccc.pd.commons:project:jar:1.0.33-RELEASE: Failed to read artifact descriptor for com.ccc.pd.commons:project:jar:1.0.33-RELEASE: Could not transfer artifact com.ccc.pd.commons:project:pom:1.0.33-RELEASE from/to ccc (https://pkgs.dev.azure.com/ccc/_packaging/ccc/maven/v1): authentication failed for https://pkgs.dev.azure.com/ccc/_packaging/ccc/maven/v1/com/ccc/pd/commons/project/1.0.33-RELEASE/project-1.0.33-RELEASE.pom, status: 401 Unauthorized -> [Help 1]
```

* JDK security에 인증서 추가
* Azure devOps에서 발급 받은 토큰 > `.m2/settings.xml` 에 추가

했음에도 불구하고 라이브러리를 받아오지 못함.. 미해결 ㅠㅠ



## gyp ERR! stack Error: `make` failed with exit code: 2

### 에러 내용

`yarn build`? `yarn install`? 했을 때 발생하는 에러. 

```bash
1 error generated.
make: *** [Release/obj.target/binding/src/binding.o] Error 1
gyp ERR! build error
gyp ERR! stack Error: `make` failed with exit code: 2
gyp ERR! stack     at ChildProcess.onExit (/Users/~~/node_modules/node-gyp/lib/build.js:262:23)
gyp ERR! stack     at ChildProcess.emit (node:events:394:28)
gyp ERR! stack     at Process.ChildProcess._handle.onexit (node:internal/child_process:290:12)
gyp ERR! System Darwin 19.6.0
gyp ERR! command "/usr/local/Cellar/node/16.3.0/bin/node" "/Users/taron/git/cgi-dmt-ui-admin/node_modules/node-gyp/bin/node-gyp.js" "rebuild" "--verbose" "--libsass_ext=" "--libsass_cflags=" "--libsass_ldflags=" "--libsass_library="
gyp ERR! cwd /Users/~~/node_modules/node-sass
gyp ERR! node -v v16.3.0
```

node 와 node-sass 버전이 호환되지 않아서 빌드 에러가 났다.

### 해결 방법

빌드할 프로젝트에서 사용하는 node, node-sass 버전에 맞게 재설치!

![img](https://blog.kakaocdn.net/dn/cBNrfJ/btqS3a4MoK3/4ue5e9kNmKiGLtV67OkPJk/img.png)참고 : https://jolly-sally.tistory.com/43 



## `==` vs. `===` 

새로 추가한 쿼리가 제대로 동작하지 않을경우 한번 확인해보셈..



## JDBC-8026: Invaild identifier

Tibero DB에 Insert 쿼리를 날렸을 때 발생하는 에러. 8026 에러는 컬럼이 일치하지 않을 때 발생한다고 하는데 내 경우는 컬럼명이 일치했다.

### 해결 방법

접속한 DB가 다른 DB였음. 원래 접속하고자 하는 DB로 바꿔서 접속하여 해결 😭

### 참고

```scala
// slick의 scala 코드를 SQL 로 추출하고 싶을 때
val action = tableQuery += insertData
dbContext.run(action)
logger.info(s"SQL : ${action.statements.headOption}") // <- like this
```



## BootService error : service class not found

```bash
ERROR failed to boot
service class not found: ExService, com.company.example.ExService
```

서비스 클래스를 찾을 수 없다는 얘기.. 잘 되다가 안되는 이유를 찾아보기..

1. git 변경 내용 확인해보기

2. ss어쩌구 dt어쩌구 클래스를 찾을 수 없다는 에러 내용

   > 처음봤는데 이런게 있었나? 하고 넘겼었음. 하지만 새로 추가된거였음. 이걸 단서로 찾아봤어야 했음

3. 구동환경의 config 폴더 수정날짜 확인해서 뭐가 바뀐건지 둘러보기

* 원인: 다른 서비스를 새로 load 하려고 config 파일을 추가했는데, 프로젝트 파일엔 이와 관련한 라이브러리 등이 들어있지 않으니 부트에 실패하면서 에러가 난 것! (build.sbt 에 정의해야 라이브러리를 로드하여 패키지에 포함됨)
* 해결
  * config 파일 로드를 제외시켜 빌드한 프로젝트 그대로 실행한다.
  * 추가된 서비스를 패키지에 포함시킨다. (build.sbt 수정)



## ⚠️ 왜 안되는지 생각해봐야!