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
  
  // Patient/Provider variables
  private String firstName;
  private String middleInitial;
  private String lastName;
  private String username;
  private String password;
  private String password2;
  private String sex;
  private String email;
  private String address;
  private String phone;
  private String token;
  
  // Medication variables
  private String name;
  private double dosage;
  private String doseUnit;
  private String issueDate;
  private String expDate;
  private String patient;
  private String provider;
  // Set methods for Patient/Provider/Medication
  public void setFirstName(String temp) { firstName = temp; }
  public void setMiddleInitial(String temp) { middleInitial = temp; }
  public void setLastName(String temp) { lastName = temp; }
  public void setUsername(String temp) { username = temp; }
  public void setPassword(String temp) { password = temp; }
  public void setPassword2(String temp) { password2 = temp; }
  public void setSex(String temp) { sex = temp; }
  public void setEmail(String temp) { email = temp; }
  public void setAddress(String temp) { address = temp; }
  public void setPhone(String temp) { phone = temp; }
  public void setToken(String temp) { token = temp; }
  public void setName(String temp) { name = temp; }
  public void setDosage(double temp) { dosage = temp; }
  public void setDoseUnit(String temp) { doseUnit = temp; }
  public void setIssueDate(String temp) { issueDate = temp; }
  public void setExpDate(String temp) { expDate = temp; }
  public void setPatient(String temp) { patient = temp; }
  public void setProvider(String temp) { provider = temp; }
  // Get methods for Patient/Provider/Medication
  public String getFirstName() { return firstName; }
  public String getMiddleInitial() { return middleInitial; }
  public String getLastName() { return lastName; }
  public String getUsername() { return username; }
  public String getPassword() { return password; }
  public String getPassword2() { return password2; }
  public String getSex() { return sex; }
  public String getEmail() { return email; }
  public String getAddress() { return address; }
  public String getPhone() { return phone; }
  public String getToken() { return token; }
  public String getName() { return name; }
  public double getDosage() { return dosage; }
  public String getDoseUnit() { return doseUnit; }
  public String getIssueDate() { return issueDate; }
  public String getExpDate() { return expDate; }
  public String getPatient() { return patient; }
  public String getProvider() { return provider; }
  
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
      stmt.close();
      c.close();
    } catch (SQLException e) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    return rs;
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
      e.printStackTrace();
    }  
  }
  public void close() {
	  try {
		  c.close();
	  } catch (SQLException e) {
		  e.printStackTrace();
	  }
  }
  // For Patient user login
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
  // For Provider user login
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
  // Get all Medication table records
  public ResultSet getMedications() {
    rs = null;
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT name, dosage, doseUnit, issueDate, expDate, patient, provider FROM Medication",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      rs = stmt.executeQuery();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return rs;
  }
  // Get Medication records associated with Patient username
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
  // Get Patient record by username
  public ResultSet getPatient(String user) {
    rs = null;
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT lastName, firstName, middleInitial, sex, email, username, password, phone, address, provider FROM Patient WHERE username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,user);
      rs = stmt.executeQuery();
    } catch (SQLException ex) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
    return rs;
  }
  // Get all Patient table records
  public ResultSet getPatients() {
    rs = null;
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT lastName, firstName, middleInitial, sex, email, username, password, phone, address, provider FROM Patient",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      rs = stmt.executeQuery();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return rs;
  }
  // Get Patient records associated with Provider username
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
  // Get all Provider table records
  public ResultSet getProviders() {
    rs = null;
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("SELECT lastName, firstName, middleInitial, sex, email, username, password, token, phone, address FROM Provider",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      rs = stmt.executeQuery();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return rs;
  }
  // Get Provider record based on username
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
  // Update Patient profile
  public String updatePatient() { 
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("UPDATE Patient SET password=?,firstName=?,middleInitial=?,lastName=?,sex=?,email=?,address=?,phone=? WHERE username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,password);
      stmt.setString(2,firstName);
      stmt.setString(3,middleInitial);
      stmt.setString(4,lastName);
      stmt.setString(5,sex);
      stmt.setString(6,email);
      stmt.setString(7,address);
      stmt.setString(8,phone);
      stmt.setString(9,username);
      stmt.execute();
    } catch (SQLException ex) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "main";
  }
	public String updatePatientProvider() {
		try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("UPDATE Patient SET provider=? WHERE lastName=? AND firstName=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,provider);
      stmt.setString(2,firstName);
      stmt.setString(3,middleInitial);
      stmt.execute();
    } catch (SQLException ex) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "main";
	}
	// Update Provider profile
  public String updateProvider() { 
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("UPDATE Provider SET password=?,token=?,firstName=?,middleInitial=?,lastName=?,sex=?,email=?,address=?,phone=? WHERE username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,password);
      stmt.setString(2,token);
      stmt.setString(3,firstName);
      stmt.setString(4,middleInitial);
      stmt.setString(5,lastName);
      stmt.setString(6,sex);
      stmt.setString(7,email);
      stmt.setString(8,address);
      stmt.setString(9,phone);
      stmt.setString(10,username);
      stmt.execute();
    } catch (SQLException ex) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "provider-patients";
  }
	// Add Medication to Patient
  public String updateMedication() {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("UPDATE Medication SET dosage=?,doseUnit=?,expDate=? WHERE name=? AND patient=? AND provider=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setDouble(1,dosage);
      stmt.setString(2,doseUnit);
      stmt.setString(3,expDate);
      stmt.setString(4,name);
      stmt.setString(5,patient);
      stmt.setString(6,provider);
      stmt.execute();
    } catch (SQLException ex) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "provider-patients";
  }
  
  // Adds Patient record
  public String addPatient() {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("INSERT INTO Patient VALUES (?,?,?,?,?,?,?,?,?,'')",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,username);
      stmt.setString(2,password);
      stmt.setString(3,email);
      stmt.setString(4,firstName);
      stmt.setString(5,middleInitial);
      stmt.setString(6,lastName);
      stmt.setString(7,sex);
      stmt.setString(8,phone);
      stmt.setString(9,address);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "login";
  }
  // Deletes Patient record from username
  public String delPatient() {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("DELETE FROM Patient WHERE username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,username);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "index";
  }
	public String delPatient(String nam) {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("DELETE FROM Patient WHERE username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,nam);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "index";
  }
  // Adds Provider record
  public String addProvider() {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("INSERT INTO Provider VALUES (?,?,?,?,?,?,?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,username);
      stmt.setString(2,password);
      stmt.setString(3,token);
      stmt.setString(4,email);
      stmt.setString(5,firstName);
      stmt.setString(6,middleInitial);
      stmt.setString(7,lastName);
      stmt.setString(8,sex);
      stmt.setString(9,phone);
      stmt.setString(10,address);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "provider-login";
  }
  // Deletes Provider record from username
  public String delProvider() {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("DELETE FROM Provider WHERE username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,username);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "index";
  }
	public String delProvider(String nam) {
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("DELETE FROM Provider WHERE username=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,nam);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "index";
  }
  // Adds Medication record
  public String addMedication() {
		if (name.equals("") || dosage <= 0 || doseUnit.equals("") || issueDate.equals("") || expDate.equals("") || patient.equals("") || provider.equals("")) {
			String msg = "Must have name, dosage, unit, issue date, exp date, patient, and provider to add Medication\n";
			msg += (name + " " + dosage + " " +  doseUnit + " " +  issueDate + " " +  expDate + " " +  patient + " " +  provider);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, msg, "..."));
			return "";
		}
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("INSERT INTO Medication VALUES (?,?,?,?,?,?,?)",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,name);
      stmt.setDouble(2,dosage);
      stmt.setString(3,doseUnit);
      stmt.setString(4,issueDate);
      stmt.setString(5,expDate);
      stmt.setString(6,patient);
      stmt.setString(7,provider);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "provider-patients";
  }
  // Deletes Medication record from username
  public String delMedication() {
		if (name.equals("") || patient.equals("") || provider.equals("") ) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, "Must have name, patient, and provider to delete Medication", "..."));
			return "";
		}
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("DELETE FROM Medication WHERE name=? AND patient=? AND provider=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,name);
      stmt.setString(2,patient);
      stmt.setString(3,provider);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "provider-patients";
  }
	public String delMedication(String nam, String patien, String provide) {
		if (nam.equals("") || patien.equals("") || provide.equals("") ) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, "Must have name, patient, and provider to delete Medication", "..."));
			return "";
		}
    try {
      c = this.connect();
      PreparedStatement stmt = c.prepareStatement("DELETE FROM Medication WHERE name=? AND patient=? AND provider=?",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      stmt.setString(1,nam);
      stmt.setString(2,patien);
      stmt.setString(3,provide);
      stmt.execute();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, ex.getMessage(), "..."));
    }
		resetValues();
    return "provider-patients";
  }
  private void resetValues() {
		setFirstName("");
		setMiddleInitial("");
		setLastName("");
		setUsername("");
		setPassword("");
		setPassword2("");
		setSex("");
		setEmail("");
		setAddress("");
		setPhone("");
		setToken("");
		setName("");
		setDosage(0);
		setDoseUnit("");
		setIssueDate("");
		setExpDate("");
		setPatient("");
		setProvider("");
	}
}
