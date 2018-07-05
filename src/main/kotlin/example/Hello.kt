package example

import java.sql.DriverManager

private val DBNAME = "mydb"

fun main(args: Array<String>) {
    Class.forName("org.h2.Driver")

    val conn = DriverManager.getConnection("jdbc:h2:mem:$DBNAME", "sa", "sa") // (2)

    conn.use {

        conn.createStatement().use { stmt ->
            with(stmt) {
                executeUpdate("create table mytbl(id int primary key, name varchar(255))")
                executeUpdate("insert into mytbl values(1, 'Hello')")
                executeUpdate("insert into mytbl values(2, 'World')")
            }
        }

        conn.createStatement().use { stmt ->
            val rs = stmt.executeQuery("select * from mytbl")
            while (rs.next()) {
                println("> " + rs.getString("name"))
            }
        }
    }

}

fun <T : AutoCloseable?, R> T.use(block: (T) -> R): R {
    try {
        return block(this)
    } finally {
        try {
            this?.close()
        } catch (e: Exception) {
            println(e.toString())
        }
    }
}