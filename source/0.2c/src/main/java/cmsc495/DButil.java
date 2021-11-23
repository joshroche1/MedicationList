package cmsc495;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "beanDButil", eager = true)
public class DButil {


  public Connection connect() {
    Connection c = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:test.db");
    } catch (Exception e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    return c;
  }
  public ResultSet query(String sql) {
    Connection c = null;
    Statement stmt = null;
    ResultSet rs = null;
    c = this.connect();
    try {
      c.setAutoCommit(false);
      stmt = c.createStatement();
      rs = stmt.executeQuery(sql);
//      rs.close();
      stmt.close();
      c.close();
    } catch (SQLException e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    return rs;
  }
  public String select(String text) {
    String result = "";
    try {
      ResultSet rsselect = this.query(text);
      result += "<tr><td>";
      while (rsselect.next()) {
        result += rsselect.next() + "</td><td>";
      }
      result += "</td></tr>";
    } catch (SQLException e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    return result;
  }
  public void insert(String text) {

  }
  public void delete(String text) {

  }
  public void update(String text) {

  }
  public String getTest() {
    String result = "";
    String test = this.select("select * from test;");
    result += test;
    return result;
  }
}
