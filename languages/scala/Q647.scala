object LearnScala{
    def printArray[K](array:Array[K]) = println(array.mkString("Array" , ", " , ")"))
    def main(args: Array[String]): Unit = {
        // 1. Array[Int]
        val array1 = Array(1, 2, 3)
        print("1. ")
        printArray(array1)

        // 2. Array[Any]
        val array2 = Array("a", 2, true)
        print("2. ")
        printArray(array2)

        // 3. 배열의 값을 읽고 쓰기
        val itemAtIndex0 = array1(0)
        array1(0) = 4
        printArray(array1)

        // 4. 배열을 붙일 때는 ++ 연산자 이용
        // 앞에 붙일땐 +:, 뒤에 붙일 땐 :+ 연산자 이용
        val concatenated = "앞에 붙이기" +: (array1 ++ array2) :+ "뒤에 붙이기"
        print("4. array1과 array2를 ++ 하면")
        printArray(concatenated)

        // 값으로 index 찾기
        array2.indexOf("a"
        
        // 5. 다른 값만 가져오기
        val diffArray = Array(1,2,3,4).diff(Array(2,3))
        print("5. Array(1,2,3,4).diff(Array(2,3))의 결과: ")
        printArray(diffArray)


        val personArray = Array(("카리나",1), ("닝닝",2), ("윈터",3))

        // 6. Find 메소드를 이용해서 findByName 메소드 생성
        // Find는 조건에 맞는 값을 찾으면 검색 중단
        // getOrElse 는 일치하는 값이 없을 경우 넘겨줄 기본 값
        // getOrElse 가 없을 때 일치하는 값이 없으면 None
        def findByName(name:String) = personArray.find(_._1 == name).getOrElse(("지젤",4))
        val findKarina = findByName("카리나") 
        val findSun = findByName("태양")
        println(findSolar)
        println(findSun)
    }
}