# ⚠️ Error

## JDBC-8026: Invaild identifier

Tibero DB에 Insert 쿼리를 날렸을 때 발생하는 에러. 8026 에러는 컬럼이 일치하지 않을 때 발생한다고 하는데 내 경우는 컬럼명이 일치했다.

### 해결

접속한 DB가 다른 DB였음. 원래 접속하고자 하는 DB로 바꿔서 접속하여 해결 😭

### 참고

```scala
// slick의 scala 코드를 SQL 로 추출하고 싶을 때
val action = tableQuery += insertData
dbContext.run(action)
logger.info(s"SQL : ${action.statements.headOption}") // <- like this
```



