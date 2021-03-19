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

