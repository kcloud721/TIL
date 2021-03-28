object Impicit3 extends App {
  def sortBy1[A, B](lst: List[A])(f: A => B)(implicit ord: Ordering[B]): List[A] = {
    lst.sortBy(f)
  }
  // 타입 B를 Ordering[B] 로 캐스팅한 값을 implicit ord로 가진다.
  // 세 번째 함수 파라미터는 직접 입력하지 않았지만 만들어진 ord 를 사용한다.

  def sortBy2[A, B: Ordering](lst: List[A])(f: A=> B): List[A] = {
    val ord = implicitly[Ordering[B]]
    lst.sortBy(f)
  }

//  def getMenu(implicit userInfo: UserInfo) = userInfo.getPermission() match {
//    case "Admin" => "AdminMenu"
//    case _ => "UserMenu"
//  }
  // 유저 정보를 매번 파라미터로 주고받을 필요 없이 암시적 파라미터를 통해 이용
  // 암시적으로 들어갈 파라미터가 지정되어 있기 때문에 함수를 사용할때 파라미터를 필요에 따라 넣지 않아도 됨



}
