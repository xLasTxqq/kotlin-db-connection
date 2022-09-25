import java.awt.*
import java.awt.event.*
import java.sql.*
import javax.swing.*

fun main(args: Array<String>) {
    val url: String = "jdbc:mariadb://127.0.0.1/portal_yii";
    val user: String = "mysql";
    val password: String = "";
    val con: Connection;
    val stmt: Statement;
    val rs: ResultSet;
    val metadata: DatabaseMetaData;
    val query = "select * from rent"

//    try {
        con = DriverManager.getConnection(url, user, password)
        metadata = con.metaData
        if (metadata.getTables(null, null, "rent", null).next()) {
            stmt = con.createStatement()
            rs = stmt.executeQuery(query)
        } else {
            val sql = ("CREATE TABLE rent "
                    + "(id INTEGER not NULL AUTO_INCREMENT, " //                    + " first VARCHAR(255), "
                    //                    + " Month VARCHAR(255), "
                    + " Year INTEGER, "
                    + " Month INTEGER, "
                    + " Size INTEGER, "
                    + " Money INTEGER, "
                    + " PRIMARY KEY ( id ))")
            stmt = con.createStatement()
            stmt.executeUpdate(sql)
            rs = stmt.executeQuery(query)
        }
        println(con)
        println(stmt)
        println(rs)
        while (rs.next()) {
            val count: Int = rs.getInt(1)
            println("Total number of books in the table : $count")
            val first: String = rs.getString(2)
            val second: String = rs.getString(3)
            println("$first $second")
        }
        con.close()
        stmt.close()
        rs.close()
//    } catch (sqlEx: SQLException) {
//        sqlEx.printStackTrace()
//    }
//    finally {
//        try {
////            con.close()
//        } catch (se: SQLException) { /*can't do anything */
//        }
//        try {
////            stmt.close()
//        } catch (se: SQLException) { /*can't do anything */
//        }
//        try {
////            rs.close()
//        } catch (se: SQLException) { /*can't do anything */
//        }
//    }
    println("Hello World!")

    // Try adding program arguments at Run/Debug configuration
    println("Program arguments: ${args.joinToString()}")
}