object LearnScala {
    def main(args: Array[String]): Unit = {
        var x = 10
        var y = 1
        
        println("1. " + x + " is bigger than " + y)
        println(s"2. $x is bigger than $y")
        println(s"3. $x + $y = ${x + y}")
        printf("4. Pi is %f",Math.PI)
    }
}