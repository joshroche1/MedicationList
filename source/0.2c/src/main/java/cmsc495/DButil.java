package cmsc495;

import java.sql.*;

public class DButil {


  public Connection connect() {
    Connection c = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc.sqlite:test.db");
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
    } catch (Exception e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    return rs;
  }
  public String select(String text) {
    String result = "";
    try {
      ResultSet rsselect = this.query(text);
      while (rsselect.next()) {
        result += rsselect.next() + " ";
      }
    } catch (Exception e) {
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
}
