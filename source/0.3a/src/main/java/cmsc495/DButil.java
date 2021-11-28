package cmsc495;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import cmsc495.Patient;
import cmsc495.Provider;

@ManagedBean(name = "beanDButil", eager = true)
public class DButil {

  private Connection c = null;
  private ResultSet rs = null;

  public Connection connect() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/myRx";
      String user = "dbuser";
      String pass = "cmsc495";
      c = DriverManager.getConnection(url, user, pass);
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
      System.err.println(e.getMessage());
    }
    return result;
  }
  public void insert(String text) {

  }
  public void delete(String text) {

  }
  public void update(String text) {

  }

  public Boolean validateUser(String user, String pass) {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT username FROM Patient WHERE username=? AND password=?");
      stmt.setString(1, user);
      stmt.setString(2, pass);
      rs = stmt.executeQuery();
      stmt.close();
      c.close();
      if (rs != null) { return true; }
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
    return false;
  }
  public Boolean validateUser(String user, String pass, String tok) {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT username FROM Provider WHERE username=? AND password=? AND token=?");
      stmt.setString(1, user);
      stmt.setString(2, pass);
      stmt.setString(3, tok);
      rs = stmt.executeQuery();
      stmt.close();
      c.close();
      if (rs != null) { return true; }
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
    return false;
  }

  public ResultSet getMedications(String user) {
    rs = null;
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT name, dosage, doseUnit, issueDate, expDate, provider FROM Medication WHERE patient=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1, user);
      rs = stmt.executeQuery();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return rs;
  }
  public ResultSet getPatients(String user) {
    rs = null;
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT lastName, firstName, middleInitial, sex, email, phone, address FROM Patient WHERE provider=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1, user);
      rs = stmt.executeQuery();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return rs;
  }

  public Patient getProfile(String user) {
    Patient pt = new Patient();
    rs = null;
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT firstName, middleInitial, lastName, sex, email, address, phone FROM Patient WHERE username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1, user);
      rs = stmt.executeQuery();
      pt.setUsername(user);
      pt.setFirstName(rs.getString("firstName"));
      pt.setMiddleInitial(rs.getString("middleInitial"));
      pt.setLastName(rs.getString("lastName"));
      pt.setSex(rs.getString("sex"));
      pt.setEmail(rs.getString("email"));
      pt.setPhone(rs.getString("phone"));
      pt.setAddress(rs.getString("address"));
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
    return pt;
  }
  public ResultSet getProvider(String user) {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT firstName, middleInitial, lastName, sex, email, address, phone, token FROM Provider WHERE username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1, user);
      rs = stmt.executeQuery();
      stmt.close();
      c.close();
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
    return rs;
  }
  public String getTest() {
    String result = "";
    String test = this.select("select * from test;");
    result += test;
    return result;
  }
}
