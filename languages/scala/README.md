# 소소한 scala

## 1. 변수와 계산

### 연산자 표기방식 (infix 표기방식)

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



### 변수와 상수

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



### 변수 출력하기

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



## 2. 편리한 스칼라

### range 와 list

```scala
object LearnScala {
    def main(args: Array[String]): Unit = {
        // 1. 1~10 range 생성
        val range1 = 1 to 10
        println(s"1. 1 to 10 \n\t $range1")

        // 2. 마지막 숫자 제외한 range 생성
        val range2 = 1 until 10
        println(s"2. 1 until 10 \n\t $range2")

        // 3. 일정 간격 건너뜀 (by)
        val range3 = 1 until 10 by 3
        println(s"3. 1 until 10 by 3 \n\t $range3")

        // 4. List로 변환 (toList)
        println(s"4. range1.toList \n\t ${range1.toList}")

        // 5. filter : 4이상인 것만 filter
        val moreThan4 = range1.filter(_ > 4)
        println(s"5. range1.filter(_ > 4) \n\t $moreThan4")

        // 6. map : 값 변경
        val doubleIt = range1.map(_ * 2)
        println(s"6. range1.map(_ * 2) \n\t $doubleIt")

    }
}

// 실행 결과
>> 	1. 1 to 10 
	 Range 1 to 10
2. 1 until 10 
	 Range 1 until 10
3. 1 until 10 by 3 
	 Range 1 until 10 by 3
4. range1.toList 
	 List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
5. range1.filter(_ > 4) 
	 Vector(5, 6, 7, 8, 9, 10)
6. range1.map(_ * 2) 
	 Vector(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)

```



### 문자열 다루기

```scala
object LearnScala {
    def main(args: Array[String]): Unit = {
        // 1. 뒤집기
        val reverse = "Scala".reverse
        println(s"1. $reverse")

        // 2. 첫글자를 대문자로
        val cap = "scala".capitalize
        println(s"2. $cap")

        // 3. 7번 반복
        val multi = "Scala! " * 7
        println(s"3. $multi")

        // 4. 정수로 변환
        val int = "123".toInt
        println(s"4. $int")
    }
}

// 실행결과
>> 1. alacS
2. Scala
3. Scala! Scala! Scala! Scala! Scala! Scala! Scala! 
4. 123
```



## 3. 메소드와 함수

### 메소드 정의

```scala
object LearnScala {
    // 1. 일반적인 메소드
    def add(x:Int, y:Int):Int = {
        return x + y
    }

    // 2. Return을 생략한 메소드
    def addWithoutReturn(x:Int, y:Int) = {
        x + y   // 둘 다 int라 return 없어도 마지막 값이 return됨
    }

    // 3. 메소드 한 줄일 경우 중괄호 생략 가능
    def addWithoutBlock(x:Int, y:Int) = x + y

    def main(args: Array[String]): Unit = {
        println(s"1. ${add(1,2)}")
        println(s"2. ${addWithoutReturn(1,2)}")
        println(s"3. ${addWithoutBlock(1,2)}")
    }
}

// 실행결과
>> 1. 3
2. 3
3. 3
```



### 익명함수1

#### 익명함수란?

식별자에 바인딩되지 않은 함수 정의. 함수명 대신 변수명에 함수코드를 저장하는 구현 방식.

#### 스칼라의 익명함수 형태 정의 방식

```scala
// 하나의 Int형 매개변수를 받아 그 제곱의 결과값을 Int형으로 반환 : Int => Int 
(x: Int) => x * x 

// 두 개의 Int형 매개변수를 받아 그 합을 Int형으로 반환 : (Int, Int) => Int
(x: Int, y:Int) => x+ y
```

#### 예제

```scala
object LearnScala {

    // 매개변수로 받은 익명함수에 1과 2를 넣어서 실행하는 메소드
    def doWithOneAndTwo(f: (Int, Int) => Int) = {
        f(1, 2) // return 생략했지만 리턴됨
    }

    def main(args: Array[String]): Unit = {
        // 1. 명시적으로 타입을 선언하는 익명함수
        val call1 = doWithOneAndTwo((x: Int, y: Int) => x + y)

        // 2. 코드 4번째 줄에서 익명함수의 매개변수 타입(Int, Int)을 이미 정했기에 생략 가능
        val call2 = doWithOneAndTwo((x, y) => x + y)

        // 3. 또다른 요약 방법 "_ * _" 는 "x * y" 와 같음
        val call3 = doWithOneAndTwo(_ * _)

        println(call1, call2, call3)
    }
}

// 결과
>> (3,3,2)
```



### 익명함수2

```scala
object LearnScala{
    // 1. 메소드 정의
    def add1(x:Int, y:Int) = x+ y

    // 2. 익명함수
    val add2 = (x:Int, y:Int) => x + y

    // 3. 익명함수를 정의하는 다른 방식
    val add3:(Int,Int)=>Int = _ + _

    // 4. 익명함수를 정의하는 다른 방식2 (잘 사용하지 않음)
    val add4 = (_ + _)L(Int,Int)=>Int

    def main(args: Array[String]): Unit = {
        // 모두 두 숫자를 더해주는 역할을 하므로 같은 결과를 출력
        println(s"1. ${add1(42,13)}")
        println(s"2. ${add2(42,13)}")
        println(s"3. ${add3(42,13)}")
        println(s"4. ${add4(42,13)}")
    }
}

// result
>> 	1. 55
2. 55
3. 55
4. 55
```





## 4. 튜플

### 튜플

튜플은 여러 타입의 객체를 담을 수 있다. 튜플 값에 접근하려면 `._1`, `_.2` 와 같은 메소드를 사용하면 된다.

Q639.scala

```scala
object LearnScala{
    def main(args: Array[String]): Unit = {
        val t1 = new Tuple3(1, "hello", true)
        val t2 = (2, "hellooo", false)

        println(t2)

        var numbers = (1,2,3,4)
        val sum = numbers._1 + numbers._2 + numbers._3 + numbers._4
        println(sum)
    }
}

//result
>> (2,hellooo,false)
10
```



### 여러개의 값 리턴

튜플을 이용하여 한 번에 여러 개의 값을 리턴할 수 있다.

```scala
object LearnScala {
    def swap(x:String, y:String) = (y, x)

    def main(args: Array[String]): Unit = {
        val (a,b) = swap("hello", "world")
        println(a, b)
    }
}

// result
>> 	(world,hello)
```



### 변수에 값 넣기



## 5. 제어문

### 반복문

### 중첨된 for문

### if문



## 6. Collection



## 7. 클래스

