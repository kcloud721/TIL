import java.text.SimpleDateFormat

object TimeStamp extends App{
  println(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse( "02/12/2012 12:23:44" ).getTime)
  println(new SimpleDateFormat("yyyyMMddHHmmss").parse( "20210520112233" ).getTime)
}
