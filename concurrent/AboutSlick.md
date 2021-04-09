## [Hello Slick!](https://scala-slick.org/doc/3.1.1/gettingstarted.html)

* monadic 해서 메모리를 적게 차지함 👉 대용량 데이터 처리에 강점 (관련 키워드: Spark)
* Type Safe함
* 비동기로 작동함. akka와 짝짝꿍 가능
* SQL 쿼리문 대신 스칼라를 사용하면 👉 컴파일 시간, 안정성, compositionality에 이점이 있다.

* 인메모리 데이터베이스
  보통 디스크에 저장된 디비에 접근하는게 일반적인데, 인메모리는 주메모리에 모든 데이터를 저장한다. 그래서 빠르다.
  서버가 꺼지면 자료들이 그냥 휘발하는 단점
* 사용 예 : 로그인 세션



## [Slick's Queries](http://scala-slick.org/doc/3.0.0/queries.html)

테이블 선언

```scala
class Coffees(tag: Tag) extends Table](String, Double) (tag, "COFFEES") {
  def name = column[String]("COF_NAME")
  def price = column[Double]("PRICE")
  def * = (name, price)
}
val coffees = TableQuery[Coffees]
val q = coffees.filter(_.price > 8.0).map(_.name)
```

* 모든 플레인 타입은 `Rep`	로 다루어 진다. 
* 쿼리 연산 결과는 `Req[Seq[T]]`	 로 표현된다.
* 일반 프로그래밍 언어의 
  `==` 연산은 👉 `===` 로
  `!=` 연산은 👉 `=!=` 로 표현



## SQL 쿼리문과 Slick 코드

작성한 코드를 run 해야 반영됨!

```scala
Await.result(database.run(작성코드), 2.second)
```



```scala
val q1 = coffees.filter(_.supID ==== 101 )
```

```sql
SELECT "COF_NAME", "SUP_ID", "PRICE", "SALES", "TOTAL"
FROM "COFFEES"
WHERE ="SUP_ID" = 101 
```



```scala
val q2 = coffees.drop(10).take(5)
```

```SQL
SELECT ...상동
FROM ... 상동
LIMIT 5 offset 10
```



```scala
val q3 = coffees.sortBy(_.named.desc.nullsFirst)
```

```sql
SELECT ... 상동
FROM ... 상동
ORDER BY "COF_NAME" desc nulls first
```



```scala
val criteriaColombian = Option("Colombian")
val criteriaEspresso = Option("Espresso")
val criteriaRoast:Option[String] = None

val q4 = coffees.filter { coffee =>
  List(
  	criteriaColombian.map(coffee.name === _),
    criteriaEspresso(coffee.name === _),
    criteriaRoast(coffee.name === _)
  ).collect({case Some(criteria) => criteria}).reduceLeftOption(_ || _).getOrElse(true:Column[Boolean])
}
```

```sql
SELECT ... 상동
FROM ... 상동	
WHERE ("COF_NAME" = 'Colombian' or "COF_NAME" = 'Espresso')
```



## Join & Zip

### Cross Join

```scala
val crossJoin = for {
  (c, s) <- coffees join suppliers
} yield (c.name, s.name)
```

```sql
SELECT x2."COF_NAME", x3."SUP_NAME"
FROM "COFFEES" x2
	INNER JOIN "SUPPLIERS" x3
```

### Inner Join

```scala
val innerJoin = for {
  (c, s) <- coffees join suppliers on(_.supID === _.id)
} yield (c.name, s.name)
```

```sql
SELECT x2."COF_NAME", x3."SUP_NAME"
FROM "COFFEES" x2 
	INNER JOIN "SUPPLIERS" x3
  ON x2."SUP_ID" = x3."SUP_ID"
```

### Full Outer Join

```scala
val fullOuterJoin = for {
  (c, s) <- coffees joinFull suppliers on (_.supID === _.Id)
} yield (c.map(_.name), s.map(_.name))
```

### Left & Right

`joinLeft` & `joinRight`



## Monadic Join

`flatMap` 으로 만들어졌다.

### monadic으로 구현한 inner join

```scala
val monadicInnerJoin = for {
  c <- coffees
  s <- supplies if c.supID === s.id
} yield (c.name, s.name)
```

```sql
SELECT x2."COF_NAME", x3."SUP_NAME"
FROM "COFFEES" x2, "SUPPLIES" x3
WHERE x2."SUP_ID" = x3."SUP_ID"
```



### Zip Join

#### zip, zipWith

두 쿼리를 조인한 쌍을 만든다.

```scala
val zipJoinQuery = for {
  (c, s) <- coffees zip suppliers
} yield (c.name, s.name)

val zipWithJoin = for {
  res <- coffees.zipWith(suppliers, (c: Coffees, s: Suppliers) => (c.name, s.name))
} yield res
```

#### zipWithIndex

```scala
val zipWithIndexJoin = for {
  (c, idx) <- coffees.zipWithIndex
} yield (c.name, idx)
```



## Unions

## Aggregation



## Delete

```scala
val q = coffees.filter(_.sypID === 15)
val action = q.delete
val affectedRowsCount: Future[Int] = db.run(action)
val sql = action.statements.head
```



## Insert

```scala
val insertActions = DBIO.seq{
  coffees += {"Colombian", 101, 7.99, 0, 0},
  coffees ++= Seq(
  	("French_Roast", 49, 8.99, 0, 0),
  	("Espresso", 150, 9.99, 0, 0)
  ),
  coffees.map(c => (c.name, c.supID, c.price)) += ("Colombian_Decaf", 101, 8.99)
}
val sql = coffees.insertStatement
```



## Update

```scala
val q = for {
  c <- coffees if c.name === "Espresso"
} yield c.price
val updateAction = q.update(10.49)
val sql = q.updateStatement	// update 내용 get
```



## Upserting

```scala
val updated = users.insertOrUpdate(User(Some(1), "Admin", "Zeiger"))
val updatedAdmin = (users returning users).insertOrUpdate(User(Some(1), "Slick Admin", "Zeiger"))
```

??



## Compiled Queries



