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