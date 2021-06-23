# ⚠️ ERROR Collection ⚠️

## SQL Error: [ERR-02189: Error in deleting rows. Only rows in VOLATILE / LOOKUP table can be deleted.]

로그를 기록하는 시계열 TimeSeries 데이터베이스 특성상 일반 DB 처럼 데이터를 콕✔집어 삭제하는 것이 불가능하다. 수정도 불가능.

### 불가능

```sql
DELETE FROM timeTable WHERE id = 't001';
-- SQL Error: [ERR-02189: Error in deleting rows. Only rows in VOLATILE / LOOKUP table can be deleted.]
```

### 삭제 예시

```sql
-- 모든 데이터를 삭제한다.
mach>DELETE FROM devices;
10 row(s) deleted.
 
-- 가장 오래된 5건을 삭제한다.
mach>DELETE FROM devices OLDEST 5 ROWS;
10 row(s) deleted.
 
-- 최근 5건을 제외하고 모두 삭제한다.
mach>DELETE FROM devices EXCEPT 5 ROWS;
15 row(s) deleted.
 
-- 2018년 6월 1일 이전의 데이터를 모두 삭제한다.
mach>DELETE FROM devices BEFORE TO_DATE('2018-06-01', 'YYYY-MM-DD');
50 row(s) deleted.
```

[🔗공식문서 참조](http://krdoc.machbase.com/pages/viewpage.action?pageId=3178971)



## Sctl restart FATAL 

### 문제

프로젝트 재기동이 안됨 `sctl restart $vm`

### 추적

* 로그 확인 : Supervisor `out.log` 
* jar가 잘못되었다는 에러메시지 확인
* pkg 가서 보니 Symbolic Link에 연결한 jar가 크기 0인 파일이었다.

### 해결

제대로 빌드된 jar 로 바꿔서 해결

* 삭제 말고 trash 로 이동
* 아웃 로그 확인



## Maven Update : 401 Unauthorized

### 에러내용

```bash
[ERROR] Failed to execute goal on project cgi-dmt-api: Could not resolve dependencies for project com.ccc:project:jar:1.0-SNAPSHOT: Failed to collect dependencies at com.ccc.pd.commons:project:jar:1.0.33-RELEASE: Failed to read artifact descriptor for com.ccc.pd.commons:project:jar:1.0.33-RELEASE: Could not transfer artifact com.ccc.pd.commons:project:pom:1.0.33-RELEASE from/to ccc (https://pkgs.dev.azure.com/ccc/_packaging/ccc/maven/v1): authentication failed for https://pkgs.dev.azure.com/ccc/_packaging/ccc/maven/v1/com/ccc/pd/commons/project/1.0.33-RELEASE/project-1.0.33-RELEASE.pom, status: 401 Unauthorized -> [Help 1]
```

* JDK security에 인증서 추가
* Azure devOps에서 발급 받은 토큰 > `.m2/settings.xml` 에 추가

### 해결 방법

server id가 달라서 발생했던 오류.. `devops-ccc` ➡️ `ccc`



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