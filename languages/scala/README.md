# 소소한 scala

## 연산자 표기방식 (infix 표기방식)

```scala
object LearnScala {
    def main(args: Array[String]): Unit = {
        println( 1 + 2 * 3 )
        println( (1).+(2) )
    }
}

// 실행 결과
>> 7
	3
```



## 변수와 상수

변수는 `var`로 상수는 `val`로 선언한다. 상수는 고정값으로 변경할 수 없다.

```scala
object LearnScala {
    def main(args: Array[String]): Unit = {
        var x = 1 + 2
        x = 3 * 4
        println( x )
        
        val y = 1 + 2
        // y = 3 * 4 // 이 줄은 상수에 값을 대입해서 에러가 나기 때문에 지워야 합니다.
        println( y )
        
        // 한 번에 여러개의 변수를 선언하면서 값을 대입할 수도 있습니다.
        var a, b, c = 5
        println( a )
        println( b )
        println( c )
    }
}

// 실행 결과
>> 12
3
5
5
5
```



## 변수 출력하기

```scala
object LearnScala{
  def main(args: Arrray[String]): Unit = {
    var x = 10
    var y = 1
    
    println("1. " + x + " is bigger than " + y)
    println(s"2. $x is bigger than $y")
    println(s"3. $x + $y = ${x + y}")
    printf("4. Pi is %f",Math.PI)
  }
}

// 실행 결과
>> 1. 10 is bigger than 1
2. 10 is bigger than 1
3. 10 + 1 = 11
4. Pi is 3.141593

```

