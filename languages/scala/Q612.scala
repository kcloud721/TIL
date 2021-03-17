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