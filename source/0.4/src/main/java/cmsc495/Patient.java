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
  private String password2 = "";
  private String address = "";
  private String phone = "";
  private Patient profile;

  public Patient() {}

  public Patient(String last, String first, String DOB) {
	  this.lastName = last;
	  this.firstName = first;
	  this.dob = DOB;
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

  public boolean validatePassword() {
    if (password.equals(password2)) { return true; }
    return false;
  }

  public String getCurrentUser() {
    String user = "";
    HttpSession ses = SessionUtils.getSession();
    String temp = ses.getAttribute("username").toString();
    user += "" + temp;
    return user;
  }

  public String validateUsernamePassword() {
    boolean valid = DAOlogin.validatePatient(username, password);
    if (valid) {
      HttpSession sess = SessionUtils.getSession();
      sess.setAttribute("username", username);
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
