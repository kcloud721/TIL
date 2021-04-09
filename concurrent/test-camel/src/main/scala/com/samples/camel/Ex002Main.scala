package com.samples.camel

import org.apache.camel.Exchange
import org.apache.camel.builder.RouteBuilder
import org.apache.camel.impl.{DefaultCamelContext, SimpleRegistry}
import org.h2.jdbcx.JdbcDataSource

object Ex002Main extends App{
  val basedir = "/tmp/camel_ex/data"

  // h2 database setup
  val ds = new JdbcDataSource
  ds.setURL(s"jdbc:h2:$basedir/h2db;mode=MySQL")
  ds.setUser("sa")
  ds.setPassword("sa")

  // create table & insert test data
  val conn = ds.getConnection
  val stmt1 = conn.createStatement()
  stmt1.executeUpdate(
    """
      |create table if not exists test_msg(
      | ID INT PRIMARY KEY,
      | SUBJECT VARCHAR(80),
      | BODY VARCHAR(1000),
      | EMAIL VARCHAR(40),
      | STATUS CHAR(1)
      |)
    """.stripMargin
  )

  val data = Seq(
    (11, "Mail for Smith", "Dear Smith,\n This is a notification email", "smith@email.com", "R"),
    (12, "Mail for Marry", "Dear Marry,\n This is a notification email", "marry@email.com", "R"),
    (13, "Mail for john", "Dear John,\n This is a notification email", "john@email.com", "R"),
  )
  data.foreach{ r =>
    val stmt = conn.prepareStatement("insert into test_msg values(?, ?, ?, ?, ?)")
    stmt.setInt(1, r._1)
    stmt.setString(2, r._2)
    stmt.setString(3, r._3)
    stmt.setString(4, r._4)
    stmt.setString(5, r._5)
    stmt.executeUpdate()
  }
  conn.close()

  // register DataSource so that Camel route can find/use database
  val registry = new SimpleRegistry
  registry.put("ds", ds)

  // camel context & routes
  val context = new DefaultCamelContext(registry)
  context.addRoutes(new RouteBuilder() {
    override def configure(): Unit = {
      val sqlSelect = "select * from test_msg where status = 'R'"
      from("sql:select * from test_msg where status = 'R'?dataSource=ds")
        .to("log:samples.Ex002Main")
    }
  })

  context.start()
  Thread.sleep(10000)
  context.stop()
}
