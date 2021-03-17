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