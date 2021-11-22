package cmsc495;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "beanDButil", eager = true)
public class DButil {

  private String test = "";

  public ResultSet query(String sql) throws ClassNotFoundException, SQLException {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      Class.forName("org.sqlite.JDBC");
      conn = DriverManager.getConnection("jdbc:sqlite:test.db");
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
    } catch (SQLException e) {
      System.err.println( e.getMessage() );
    }
    return rs;
  }

  public String select(String text) throws ClassNotFoundException,SQLException {
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
  public List<Patient> getPatients() throws ClassNotFoundException, SQLException {
    Connection con = null;
    try {
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection("jdbc:sqlite:test.db");
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    List<Patient> patients = new ArrayList<Patient>();
    PreparedStatement pstmt = con.prepareStatement("select lastName,firstName,middleInitial,email,username,password,address,phone,dob,sex from Patient;");
    ResultSet rs = pstmt.executeQuery();
    while (rs.next()) {
      Patient pt = new Patient();
      pt.setLastName(rs.getString("lastName"));
      pt.setFirstName(rs.getString("firstName"));
      pt.setMiddleInitial(rs.getString("middleInitial"));
      pt.setUsername(rs.getString("username"));
      pt.setEmail(rs.getString("email"));
      pt.setAddress(rs.getString("address"));
      pt.setPhone(rs.getString("phone"));
      patients.add(pt);
    }
    rs.close();
    pstmt.close();
    con.close();
    return patients;
  }
}
