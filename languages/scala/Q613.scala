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

