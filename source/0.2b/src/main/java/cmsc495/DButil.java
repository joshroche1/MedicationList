package cmsc495;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanDButil", eager = true)
public class DButil {

  private static String teststring = "TEST Test test";

  public static Connection Connect() {
    Connection conn = null;
    try {
      Class.forName("org.sqlite.JDBC");
      // TEST DB FOR NOW
      conn = DriverManager.getConnection("jdbc:sqlite:WEB-INF/classes/test.db");
      conn.setAutoCommit(false);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return conn;
  }

  public static String Select() {
    String result = "";
    int record = 0;
    try {
      Connection c = Connect();
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("select * from Patient;");
      result += "SQL: ";
      while (rs.next()) {
        record++;
        result += "Record: " + record;
        int id = rs.getInt("id");
        String last = rs.getString("lastname");
        String first = rs.getString("firstname");
//        int age = rs.getInt("age");
        result += " " + id + " " + last + " " + first + " "/* + age + " "*/;
      }
      rs.close();
      stmt.close();
      c.close();
      result += " END";
    } catch (Exception e) {
      result += e.getMessage();
    }
    return result;
  }
  public static void Insert() {

  }
  public static void Update() {

  }
  public static void Delete() {

  }

  public static String getTest() { return teststring; }
}
