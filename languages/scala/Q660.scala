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