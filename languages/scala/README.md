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



### 숫자 다루기

Q610.scala

```scala
object LearnScala{
  def main(args: Array[String]): Unit = {
    val num = -5
    val numAbs = num.abs  // 절대값
    val max5or7 = numAbs.max(7) // numAbs와 7 사이의 최대값
    val min5or7 = numAbs.min(7) // numAbs와 7 사이의 최소값

    println(numAbs)
    println(max5or7)
    println(min5or7)
  }
}

// result
>> 5
7
5
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

튜플을 이용하여 한 번에 여러 개의 변수에 값을 넣을 수 있다.

```scala
object LearnScala {
    def main(args: Array[String]): Unit = {
        var (x, y, z, c, python, java) = (1, 2, 3, true, false, "no!")
        println(x, y, z, c, python, java)
    }
}
```





## 5. 제어문

### 반복문

while 문과 for 문 사용가능하며, python과 같이 `++`, `--` 는 제공하지 않으므로 `+=1` 과 같이 사용한다. 스칼라에서는 반복문보다는 `3` 예제와 같은 방법으로 구하는 경우가 많다.

Q640.scala

```scala
object LearnScala {
    def main(args: Array[String]): Unit = {
        // 1. while
        var i, sum = 0
        while (i<10){
            sum += i
            i+=1
        }
        println(s"1. $sum")

        // 2. for
        sum = 0
        for( i <- 0 until 10){
            sum += i
        }
        println(s"2. $sum")

        // 3. 가장 스칼라 스럽게 합을 구하는 방법
        sum = (0 until 10).sum
        println(s"3. $sum")
    }
}

// result
>> 	1. 45
2. 45
3. 45
```



### 중첨된 for문

일반적인 중첩된 for문을 scala에서는 하나의 for문으로도 표현이 가능하다.

Q644.scala

```scala
object LearnScala1 {
    def main(args: Array[String]): Unit = {
        for( a <- 1 to 3){
            for( b <- 10 to 12){
                println(a, b)
            }
        }
        println("중첩된 for문 대신 아래와 같이 쓸 수 있음")
        for( a <- 1 to 3; b <- 10 to 12){
            println(a,b)
        }
    }
}

// result
>> 	(1,10)
(1,11)
(1,12)
(2,10)
(2,11)
(2,12)
(3,10)
(3,11)
(3,12)
중첩된 for문 대신 아래와 같이 쓸 수 있음
(1,10)
(1,11)
(1,12)
(2,10)
(2,11)
(2,12)
(3,10)
(3,11)
(3,12)
```



### if문

Q642.scala

```scala
object LearnScala{
    def main(args: Array{String}): Unit = {
        if(true)
            println("한 줄은 괄호{} 생략 가능")

        if(1+1 == 2){
            println("여러줄은")
            println("괄호{}가 필요함")
        } else {
            println("else")
        }

        val likeEggs = false
        // 삼항연산자를 if문으로 대체할 수 있다.
        val breakfast = 
            if(likeEggs) "계란후라이"
            else "사과"
        println(s"아침으로 ${breakfast}를 먹어요")
    }
}

// result
>> 	한 줄은 괄호{} 생략 가능
여러줄은
괄호{}가 필요함
아침으로 사과를 먹어요
```



## 6. Collection

### Array

자바의 `int[]` 가 스칼라의 `Array[Int]` 와 같은 개념이다. 스칼라의 배열은 값을 변경할 수 있다. (Mutable)

`.mkString(",")` 메소드를 활용하여 배열의 내용 출력 가능

```scala
object LearnScala{
  def printArray[K](array:Array[K]) = println(array.mkString("ArrayPrint(" , ", " , ")"))
  def main(args: Array[String]): Unit = {
    // 1. Array[Int]
    val array1 = Array(1, 2, 3)
    print("1. ")
    printArray(array1)

    // 2. Array[Any]
    val array2 = Array("a", 2, true, false)
    print("2. ")
    printArray(array2)

    // 3. 배열의 값을 읽고 쓰기
    val itemAtIndex0 = array1(0)
    array1(0) = 99
    print("3. ")
    printArray(array1)

    // 4. 배열을 붙일 때는 ++ 연산자 이용
    // 앞에 붙일땐 +:, 뒤에 붙일 땐 :+ 연산자 이용
    val concatenated = "앞에 붙이기" +: (array1 ++ array2) :+ "뒤에 붙이기"
    print("4. array1과 array2를 ++ 하면 ")
    printArray(concatenated)

    // 값으로 index 찾기
    print("4-2. array2에서 'a'의 위치: ")
    println(array2.indexOf("a"))

    // 5. 다른 값만 가져오기
    val diffArray = Array(1,2,3,4).diff(Array(2,3))
    print("5. Array(1,2,3,4).diff(Array(2,3))의 결과: ")
    printArray(diffArray)

    // 6. Find 메소드를 이용해서 findByName 메소드 생성
    val personArray = Array(("카리나",1), ("닝닝",2), ("윈터",3))

    // Find는 조건에 맞는 값을 찾으면 검색 중단
    // getOrElse 는 일치하는 값이 없을 경우 넘겨줄 기본 값
    // getOrElse 가 없을 때 일치하는 값이 없으면 None
    def findByName(name:String) = personArray.find(_._1 == name).getOrElse(("지젤",4))
    val findKarina = findByName("카리나")
    val findSun = findByName("태양")
    println(findKarina)
    println(findSun)
  }
}

//
```



### List

스칼라의 `List` 는 `scala.collection.immutable.List` 이므로 값을 변경할 수 없는 immutable 속성을 갖고 있다. 

Q648.scala

```scala
object LearnScala{
  def main(args: Array[String]): Unit = {
    // List[Any] 기본 리스트를 사용하므로 Immutable(값 변경 x)
    val list = List("a", 1, true)

    // 1. 값을 읽어올 수는 있지만
    val firstItem = list(0)
    // 아래와 같이 값을 변경할 수는 없음
    // list(0) = "b"
    println(s"1. $firstItem")

    // 2. 앞에 붙이기는 :: 또는 +: 연산자를 사용
    // 리스트 두 개 붙이기는 ++ 또는 :::
    // 뒤에 붙이기는 :+ (immutable list에서 효율적인 방법은 아님)
    val concatenated = 0 :: list ++ list :+ 1000
    println(s"2. $concatenated")

    // 3. Diff
    val diffList = List(1,2,3,4) diff List(2,3)
    println(s"3. $diffList")

    // 4. 배열의 Find와 같은 방식으로 동작
    val personList = List(("카리나",1), ("윈터",2), ("닝닝",3))
    def findByName(name:String) = personList.find(_._1 == name).getOrElse(("지젤",4))
    val findKarina = findByName("카리나")
    val findSun = findByName("태양")
    println(s"4. ${findKarina}, ${findSun}")
  }
}

// result
>> 1. a
2. List(0, a, 1, true, a, 1, true, 1000)
3. List(1, 4)
4. (카리나,1), (지젤,4)
```



### Set

스칼라에서 기본 Set 은 `Predef.Set` 이다.

Set은 크기가 4일 때 까지는 크기에 따라 별도 클래스가 있다. (Set1, Set2, Set3, Set4) 구성요소가 4개 보다 많아지면 HashSet으로 구현된다.

Set은 집합에 대응하는 개념으로, 같은 값을 추가하면 기존 값을 덮어 쓰게 되고 순서가 보장되지 않는다.

Q659.scala

```scala
object LearnScala{
  def main(args: Array[String]): Unit = {
    // 1. 내용을 수정할 수 없는 Set
    val set1 = Set("one", 1)
    val set2 = Set(1,2,2,2,3,3,3) // 중복이 제거되어 Set(1,2,3)이 된다.
    println(s"1. $set2")

    // 2. 값이 있는지 체크하는 방법은 괄호 안에 값을 넣어 사용
    val oneExists = set2(1)
    val fourExists = set2(4)
    println(s"2. oneExists: ${oneExists}, fourExists: ${fourExists}")

    // 3. set을 더하면 중복된 내용은 제거된 새로운 Set이 생성
    val concatenated = set1 ++ set2
    println(s"3. $concatenated")

    // 4. Diff : 다른것 찾아냄
    val diffSet = Set(1,2,3,4) diff Set(2,3)
    println(s"4. $diffSet")

    // 5. set.find 메소드를 이용하여 findByName이라는 메소드 생성
    // find는 조건에 맞는 값을 찾으면 검색을 중단
    // getOrElse는 일치하는 값이 없을 경우 넘겨줄 기본 값
    // getOrElse가 없을 때 일치하는 값이 없으면 None
    val personSet = Set(("카리나",1), ("윈터",2), ("닝닝",3))
    def findByName(name:String) = personSet.find(_._1 == name).getOrElse(("지젤",4))
    val findKarina = findByName("카리나")
    val findBlackMamba = findByName("블랙맘바")
    println(s"5. ${findKarina._1}, ${findBlackMamba._1}")
  }
}

// result 
>> 1. Set(1, 2, 3)
2. oneExists: true, fourExists: false
3. Set(one, 1, 2, 3)
4. Set(1, 4)
5. 카리나, 지젤
```



### Map

Map은 `Map(key1 -> value1, key2 -> value2, ...)` 와 같은 형식으로 생성한다.

스칼라의 기본 Map은 Predef.Map(scala.coleection.immutable.Map)이다.

Map 또한 Set과 마찬가지로 구성요소 4개 까지는 Map1, ..., Map4 라는 별도 클래스로 구현되며 더 많아지는 경우 HashMap으로 구현된다.

key는 중복할 수 없으며 Set과 마찬가지로 순서가 보장되지 않는다.

Q660.scala

```scala
object LearnScala{
  def main(args: Array[String]): Unit = {
    // 1. Map[String, Int] 타입의 맵
    val map1 = Map("one" -> 1, "two" -> 2, "three" -> 3)
    // Map[Any, Any] 타입의 맵
    val map2 = Map(1 -> "one", "2" -> 2.0, "three" -> false)
    println(s"1. $map1")

    // 2. 중복된 키가 있으면 마지막 값은 사용
    println(s"2. ${Map('a' -> 1, 'a' -> 2)}")

    // 3. key를 가지고 값을 읽어오기
    val one = map1("one")
    println(s"3. ${one}")

    // 4. 키가 없으면 NoSuchElementExceprion이 발생
    // 예를 들어 val fourExitst = map1("four")
    // get메소드드를 이용해서 얻어오는 객체의 isDefine 값으로 Key가 있는지 확인 가능
    val fourExistsOption = map1.get("four")
    println(s"4. ${fourExistsOption.isDefined}") // ture or false

    // 5. ++연산자로 두 개의 Map을 더할 수 있으며, 중복된 키 ("three")의 값은 마지막 값으로 결정
    val concatenated = map1 ++ map2
    println(s"5. $concatenated")

    // 6. find (List, Set과 같은 형태)
    val personMap = Map(("카리나",1), ("윈터",2), ("닝닝",3))
    def findByName(name:String) = personMap.getOrElse(name, 4)

    val findKarina = findByName("카리나")
    val findBlackMamba = findByName("블랙맘바")
    println(s"6. ${findKarina}, ${findBlackMamba}")
  }
}

// result
>> 1. Map(one -> 1, two -> 2, three -> 3)
2. Map(a -> 2)
3. 1
4. false
5. List((one,1), (two,2), (three,3), (1,one), (2,2.0), (three,false))
6. 1, 4
```



### Array/List/Set/Map 의 타입

Array, List, Set, Map의 구성요소는 어떤 타입이든 사용할 수 있지만, 최종 타입은 공통으로 상속받는 타입 중 최상위 타입으로 결정된다.

Q649.scala

```scala
object LearnScala{
  class Animal()
  class Dog() extends Animal

  def main(args: Array[String]): Unit = {
    // Animal과 Dog가 공통으로 상속받는 최상위 타입은 Animal이므로 아래 코드는 정상 실행
    val array:Array[Animal] = Array(new Animal(), new Dog())
    // 위 코드에서 val array:Array[Dog] 는 올바르지 않은 타입

    // List도 같은 원리로 동작(Animal이 List의 element의 타입)
    val list:List[Animal] = List(new Animal(), new Dog())

    // Set도 같은 원리로 동작 (Animal이 Set의 element의 타입)
    val set:Set[Animal] = Set(new Animal(), new Dog())

    // Map도 같은 원리로 동작
    val map:Map[String, Animal] = Map("Animal" -> new Animal, "Dog" -> new Dog())
  }
}
```



### 변경할 수 있는(Mutalbe) Collection

스칼라는 기본 Collection이 immutable이다. mutable collection을 사용하고자 하는 경우 앞에 mutalbe을 붙여서 사용한다.

`mutable,ArrayBuffer`, `mutable.ListBuffer`, `mutable.Set`, `mutable.Map`

Q661.scala

```scala
import scala.collection.mutable

object LearnScala{
  def main(args: Array[String]): Unit = {
    // 1. 배열로 구현되는 ArrayBuffer
    val arrayBuffer = mutable.ArrayBuffer(1, 2, 3)
    arrayBuffer += 4
    arrayBuffer -= 1
    arrayBuffer ++= List(5, 6, 7)
    println(s"1. $arrayBuffer")

    // 2. LinkedList로 구현되는 ListBuffer
    val listBuffer = mutable.ListBuffer("a", "b", "c")
    println(s"2. listBuffer")

    // 3. Mutable Set
    val hashSet = mutable.Set(0.1, 0.2, 0.3)
    hashSet ++= mutable.Set(5)
    println(s"3. $hashSet")

    // 4. Mutable Map
    val hashMap = mutable.Map("one" -> 1, "two" -> 2)
    hashMap ++= Map("five" -> 5, "six" -> 6)
    println(s"4. $hashMap")
  }
}

// result
>> 1. ArrayBuffer(2, 3, 4, 5, 6, 7)
2. listBuffer
3. HashSet(0.3, 0.1, 0.2, 5.0)
4. HashMap(six -> 6, two -> 2, five -> 5, one -> 1)

```



### 변경할 수 없는(Immutable) collection에서 var와 val사용

Immutable Collection이 `var`로 선언된 경우에  Collection에 `+=` or `-+` 연산자를 사용할 수 있다. 이때 변경사항을 반영한 새로운 Collection이 만들어져서  var로 변수에 저장된다.

Q662.scala

```scala
import scala.collection.mutable

object LearnScala{
  def main(args: Array[String]): Unit = {
    // 1. 변경할 수 없는 Collection이 var로 선언된 경우
    var immutableSet = Set(1, 2, 3)
    immutableSet += 4
    // 위 코드는 새로운 Set을 만들어서 immutableSet에 저장하는 아래 코드와 같음

    immutableSet = immutableSet + 4
    println(s"1. $immutableSet")

    // 2. 변경할 수 있는 Collection이라면 추가하는 메소드를 호출하는 것과 같다
    val mutableSet = mutable.Set(1, 2, 3)
    mutableSet += 4
    // 위 코드는 mutalbeSet 자체의 메소드(+=)를 호출하는 아래 코드와 같음

    mutableSet.+=(4)
    println(s"2. $mutableSet")
  }
}

// result
>> 1. Set(1, 2, 3, 4)
2. HashSet(1, 2, 3, 4)

```



## 7. 클래스

### 클래스

Q667.scala

```scala
// 1. 단순한 클래스
class Person1(fname:String, lname:String)

// 2. 메소드를 갖는 클래스
class Person2(fname:String, lname:String){
  def greet = s"${lname} ${fname}님 안녕하세요!"  // public한 method
}

// 3. public한 val(read only) 필드
class Person3(fname:String, lname:String){
  val fullName = s"${lname}${fname}" // public한 val(read only) 필드
  def greet = s"${fullName}님 안녕하세요!"  // public한 method
}

// 4. val로 선언된 fname은 getter가 자동으로 생성
// var로 선언된 lname은 getter와 setter가 자동으로 생성
class Person4(val fname:String, var lname:String)


object LearnScala{
  def main(args: Array[String]): Unit = {
    // 1. 단순한 클래스
    val p1 = new Person1("중기", "송")
    // p1.fname과 p1.lname의 값을 외부에서 가져올 수 없다.

    // 2. 메소드를 갖는 클래스
    val p2 = new Person2("혜교", "송")
    // 이 또한 p2.fname, p2.lname의 값을 외부에서 가져올 수 없다.

    // 정의된 greet 메소드를 출력한다.
    println((s"2. ${p2.greet}"))

    // 3. public한 read only(val) fullname을 갖는 클래스
    val p3 = new Person3("구", "진")
    println(s"3. ${p3.fullName}님께 인사합니다. ${p3.greet}")

    // 4. val fname과 var lname을 갖는 클래스
    val p4 = new Person4("지원", "Kim"){
      override  def toString = s"$lname$fname"
    }
    // val로 선언된 p4.fname과 var로 선언된 p4.lname을 뵈부에서 읽을 수 있음

    println((s"4. ${p4.lname}${p4.fname}"))

    // 5. Person4 클래스를 이용해서 객체를 생성하지만, 해당 객체의 toString 메소드만 오버라이드
    val p5 = new Person4("시진", "유"){
      override def toString = s"$lname$fname"
    }
    println(s"5. $p5")
  }
}

// result 
>> 2. 송 혜교님 안녕하세요!
3. 진구님께 인사합니다. 진구님 안녕하세요!
4. Kim지원
5. 유시진
```



### getter와 setter

자바와 달리 스칼라에서는 변수 (val, var)와 메소드(def)는 같은 이름을 사용할 수 없다. 예를 들어자바에선 `int name;` 이라는 필드와 `int name(){ return 0; }` 이라는 메소드가 한 클래스에 있을 수 있지만 스칼라에서는 불가능하다.

그래서  Jperson 클래스를 보면 필드 이름은 `_name` 으로, setter는 `name_` 으로, getter 는 `name`으로 정의하였다.

자바스타일의 getter, setter가 필요하다면 @beanProperty를 활용할 수도 있다. (SPeron 클래스)

Q675.scala

```scala
object LearnScala{
  def main(args: Array[String]): Unit = {
    val jp = new JPerson("자바 스타일")
    val sp = new SPerson("스칼라 스타일")

    println(jp.name)
    println(sp.name)

    jp.name += " 싫어요!"
    sp.name += " 좋아요!"

    println(jp.getName())
    println(sp.getName())
  }
}

// 자바 스타일 클래스
class JPerson() {
  var _name: String = null
  def this(_name:String) = {
    this()
      this._name = _name
  }

  // 스칼라 스타일의 getter, setter
  def name_=(_name:String) = this._name = _name
  def name = this._name

  // 자바 스타의 getter, setter
  def getName() = name
  def setName(name:String) = this.name = name
}

// 스칼라에서 간단히 만들기
import beans._
class SPerson(@BeanProperty var name:String)
// @BeanProperty는 필수가 아니다. 자바 스타일의 getter와 setter가 필요 경우에만 사용.


// result
>> 자바 스타일
스칼라 스타일
자바 스타일 싫어요!
스칼라 스타일 좋아요!
```

