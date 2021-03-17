object LearnScala {
    def main(args: Array[String]): Unit = {
        // 1. 1~10 range 생성
        val range1 = 1 to 10
        println(s"1. 1 to 10 \n\t $range1")

        // 2. 마지막 숫자 제외한 range 생성
        val range2 = 1 until 10
        println(s"2. 1 until 10 \n\t $range2")

        // 3. 일정 간격 건너뜀 (by)
        val range3 = 1 until 10 by 3
        println(s"3. 1 until 10 by 3 \n\t $range3")

        // 4. List로 변환 (toList)
        println(s"4. range1.toList \n\t ${range1.toList}")

        // 5. filter : 4이상인 것만 filter
        val moreThan4 = range1.filter(_ > 4)
        println(s"5. range1.filter(_ > 4) \n\t $moreThan4")

        // 6. map : 값 변경
        val doubleIt = range1.map(_ * 2)
        println(s"6. range1.map(_ * 2) \n\t $doubleIt")

    }
}