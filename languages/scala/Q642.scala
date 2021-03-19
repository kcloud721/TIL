object LearnScala{
    def main(args: Array{String}): Unit = {
        if(true)
            println("한 줄은 괄호{} 생략 가능")

        if(1+1 == 2){
            println("여러줄은")
            println("괄호{}가 필요함")
        } else {
            println("else")
        }

        val likeEggs = false
        // 삼항연산자를 if문으로 대체할 수 있다.
        val breakfast = 
            if(likeEggs) "계란후라이"
            else "사과"
        println(s"아침으로 ${breakfast}를 먹어요")
    }
}