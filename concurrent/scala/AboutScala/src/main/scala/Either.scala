object Either extends App {
  def eitherTest(num: Option[Int]): Either[String, Int] = num match {
    case Some(n) => Right(n)
    case None => Left("Error! Number is missing!")
  }

  val res = eitherTest(Some(-700))
  if( res.isRight )
    println("Number is %s".format(res.right.get))
  else if( res.isLeft)
    println("Error msg => %s".format(res.left.get))
}
