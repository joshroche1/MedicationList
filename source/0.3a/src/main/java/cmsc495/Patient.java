package cmsc495;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import cmsc495.DAOlogin;
import cmsc495.DButil;
import cmsc495.SessionUtils;

@ManagedBean(name = "beanPatient", eager = true)
@SessionScoped
public class Patient {

  private String lastName = "";
  private String firstName = "";
  private String middleInitial = "";
  private String dob = "";
  private String sex = "";
  private String email = "";
  private String username = "";
  private String password = "";
  private String address = "";
  private String phone = "";
  private Patient profile;
  private String testinfo = "PATIENT Patient patient!!";

  public Patient() {
  }

  public String getTest() {
    return this.testinfo;
  }
  public void setLastName(String last) { this.lastName = last; }
  public void setFirstName(String first) { this.firstName = first; }
  public void setMiddleInitial(String mi) { this.middleInitial = mi;}
  public void setDOB(String birthdate) { this.dob = birthdate; }
  public void setSex(String sx) { this.sex = sx; }
  public void setEmail(String em) { this.email = em;}
  public void setUsername(String user) { this.username = user;}
  public void setPassword(String pass) { this.password = pass;}
  public void setAddress(String addr) { this.address = addr;}
  public void setPhone(String num) { this.phone = num; }

  public String getLastName() { return this.lastName; }
  public String getFirstName() { return this.firstName; }
  public String getMiddleInitial() { return this.middleInitial; }
  public String getDOB() { return this.dob; }
  public String getSex() { return this.sex; }
  public String getEmail() { return this.email; }
  public String getUsername() { return this.username; }
  public String getPassword() { return this.password; }
  public String getAddress() { return this.address; }
  public String getPhone() { return this.phone; }

  public void register() {}
  public void updateProfile() {}
  public void updatePassword() {}

  public String getCurrentUser() {
    String user = "";
    user += "" + SessionUtils.getUserName();
    return user;
  }

/*
  public List<Medication> getMedications() {
    List<Medication> medications = new ArrayList<Medication>();
    Medication med1 = new Medication();
    med1.setName("NAME");
    med1.setDosage(0);
    med1.setDoseUnit("UNIT");
    med1.setIssueDate("DD MMM YYYY");
    med1.setExpDate("DD MMM YYYY");
    med1.setPrescriber("Dr. NAME");
    medications.add(med1);
    try {
      ResultSet rs = null;
      DButil dbu = new DButil();
      rs = dbu.getPatientMedList(this.username);
      if (rs != null) {
        while (rs.next()) {
          Medication med = new Medication();
          med.setName(rs.getString("name"));
          med.setDosage(rs.getInt("dosage"));
          med.setDoseUnit(rs.getString("doseUnit"));
          med.setIssueDate(rs.getString("issueDate"));
          med.setExpDate(rs.getString("expDate"));
          med.setPrescriber(rs.getString("provider"));
          medications.add(med);
        }
      } else {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_WARN, "Cannot fetch medications from database", "..."));
      }
    } catch (SQLException ex) {
      System.err.println(ex.getMessage());
    }
    return medications;
  }
  public Patient getProfile(String user) {
    profile = new Patient();
    try {
      ResultSet rs = null;
      DButil dbu = new DButil();
      rs = dbu.getPatient(user);
      profile.firstName = rs.getString("firstName");
      profile.middleInitial = rs.getString("middleInitial");
      profile.lastName = rs.getString("lastName");
      profile.sex = rs.getString("sex");
      profile.email = rs.getString("email");
      profile.address = rs.getString("address");
      profile.phone = rs.getString("phone");
      rs.close();
    } catch (SQLException ex) {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_WARN, "Cannot fetch user details from database", "..."));
    }
    return profile;
  }
*/
  public String validateUsernamePassword() {
    boolean valid = DAOlogin.validatePatient(username, password);
    if (valid) {
      HttpSession sess = SessionUtils.getSession();
      sess.setAttribute("username", username);
      //this.getProfile(username);
      return "main";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_WARN, "Incorrect username and/or password", "..."));
      return "login";
    }
  }
  public String logout() {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "index";
  }
}
