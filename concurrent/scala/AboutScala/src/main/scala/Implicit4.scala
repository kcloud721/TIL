// 타입 클래스 패턴

object Implicit4 extends App{
  // 아우터 클래스는 부분 함수로 만들어 사용
  implicit def imp(paramX: Int): OuterClass = new OuterClass(paramX)

  // 이너 클래스는 implicit 키워드 바로 사용 가능
  implicit class InnerCase(paramX: Int) {
    println(s"InnerClass - $this")
    def ***(paramY: Int) = paramX * paramY
  }

  println(2 *** 5)
  println(2 *** 5)
  println(2 *&* 5)
  println(2 *&* 5)
}


class OuterClass(paramX: Int){
  println(s"OuterClass - $this")
  def *&*(paramY: Int) = paramX + paramY
}


