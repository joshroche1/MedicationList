
import java.sql.*;

public class DButil {
	
	Connection c = null;
	ResultSet rs;

  public Connection connect() {
    try {
    	Class.forName("org.sqlite.JDBC");
    	c = DriverManager.getConnection("jdbc:sqlite:test.db");
    } catch (Exception e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    return c;
  }

  public ResultSet select(String text) {
    try {
		Statement stmt = c.createStatement();
		rs = stmt.executeQuery(text);
	} catch (SQLException e) {
		e.printStackTrace();
	}
    
    return rs;
    
  }
  
  public void closeRS() {
	try {
		rs.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
  }
  
  public void insert(int id, String last, String first, String mid, String email, String pass, String address, String phone, String list) {
	  try {
		PreparedStatement stmt = c.prepareStatement("INSERT INTO Patient(patientId, lastName, firstName, middleInitial, email, password, address, phone, medicationList)" + 
	  " VALUES(?,?,?,?,?,?,?,?,?)");
		stmt.setInt(1, id);
		stmt.setString(2, last);
		stmt.setString(3, first);
		stmt.setString(4, mid);
		stmt.setString(5, email);
		stmt.setString(6, pass);
		stmt.setString(7, address);
		stmt.setString(8, phone);
		stmt.setString(9, list);
		stmt.executeUpdate();
		stmt.close();
		//System.out.println("Success");
	} catch (SQLException e) {

		e.printStackTrace();
	}
	  
  }
  public void delete(int id) {
	  PreparedStatement stmt;
	try {
		stmt = c.prepareStatement("DELETE FROM Patient WHERE patientID = ?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		//System.out.println("Success");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  public void update(int id, int section, String change) {
	  String sectionName = null;
	  switch(section) {
	  	case 1:
	  		sectionName = "lastName";
	  		break;
	  	case 2:
	  		sectionName = "firstName";
	  		break;
	  	case 3:
	  		sectionName = "middleInitial";
	  		break;
	  	case 4:
	  		sectionName = "email";
	  		break;
	  	case 5:
	  		sectionName = "password";
	  		break;
	  	case 6:
	  		sectionName = "address";
	  		break;
	  	case 7:
	  		sectionName = "phone";
	  		break;
	  	default:
	  		System.out.println("Invalid Selection");
	  }
	  
	  String sql = "UPDATE Patient SET " + sectionName + " = '" + change + "' WHERE patientID = " + id;
	  //System.out.println(sql);
	  
	  try {
		Statement stmt = c.createStatement();
		stmt.executeUpdate(sql);
		//System.out.println("Success");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
  }
  
  public void close() {
	  try {
		c.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
}
