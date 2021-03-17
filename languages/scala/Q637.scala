object LearnScala{
    // 1. 메소드 정의
    def add1(x:Int, y:Int) = x+ y

    // 2. 익명함수
    val add2 = (x:Int, y:Int) => x + y

    // 3. 익명함수를 정의하는 다른 방식
    val add3:(Int,Int)=>Int = _ + _

    // 4. 익명함수를 정의하는 다른 방식2 (잘 사용하지 않음)
    val add4 = (_ + _):(Int,Int)=>Int

    def main(args: Array[String]): Unit = {
        // 모두 두 숫자를 더해주는 역할을 하므로 같은 결과를 출력
        println(s"1. ${add1(42,13)}")
        println(s"2. ${add2(42,13)}")
        println(s"3. ${add3(42,13)}")
        println(s"4. ${add4(42,13)}")
    }
}