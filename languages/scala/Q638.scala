object LearnScala {
    def swap(x:String, y:String) = (y, x)

    def main(args: Array[String]): Unit = {
        val (a,b) = swap("hello", "world")
        println(a, b)
    }
}