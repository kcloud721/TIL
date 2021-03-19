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