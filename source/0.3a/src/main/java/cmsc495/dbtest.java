package cmsc495;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import cmsc495.Person;

@ManagedBean(name = "beandbtest", eager = true)
public class dbtest {


  public List<Person> getPersons() throws ClassNotFoundException,SQLException {
    Connection conn = null;
    List<Person> persons = new ArrayList<Person>();
    Person pers = new Person(0,"DEFAULT","USER",0);
    persons.add(pers);
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url = "jdbc:mysql://localhost:3306/test";
      String username = "dbuser";
      String password = "cmsc495";
      conn = DriverManager.getConnection(url, username, password);
      PreparedStatement stmt = conn.prepareStatement("SELECT id,firstname,lastname,age FROM test");
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        Person person = new Person();
        person.setid(rs.getInt("id"));
        person.setfirstname(rs.getString("firstname"));
        person.setlastname(rs.getString("lastname"));
        person.setage(rs.getInt("age"));
        persons.add(person);
      }
      rs.close();
      stmt.close();
      conn.close();
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    } finally {
      return persons;
    }
  }
}
