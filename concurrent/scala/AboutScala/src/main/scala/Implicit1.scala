import scala.concurrent.ExecutionContext

object Implicit1 extends App{
  implicit val implicitValue: Int = 500

  def plusValue(paramX: Int)(implicit paramY: Int) = paramX + paramY

  println(plusValue(100)(200))
  println(plusValue(200))


//  def apply[T](body: => T)(impicit @deprecatedName('execctx) executor: ExecutionContext): Future[T] =

}