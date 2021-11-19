package cmsc495;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import cmsc495.DAOlogin;
import cmsc495.SessionUtils;

@ManagedBean(name = "beanPatient", eager = true)
@SessionScoped
public class Patient {

  private String lastName = "";
  private String firstName = "";
  private String middleInitial = "";
  private String dob = "";
  private char sex;
  private String email = "";
  private String username = "";
  private String password = "";
  private String address = "";
  private String phone = "";
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
  public void setSex(char sx) { this.sex = sx; }
  public void setEmail(String em) { this.email = em;}
  public void setUsername(String user) { this.username = user;}
  public void setPassword(String pass) { this.password = pass;}
  public void setAddress(String addr) { this.address = addr;}
  public void setPhone(String num) { this.phone = num; }

  public String getLastName() { return this.lastName; }
  public String getFirstName() { return this.firstName; }
  public String getMiddleInitial() { return this.middleInitial; }
  public String getDOB() { return this.dob; }
  public char getSex() { return this.sex; }
  public String getEmail() { return this.email; }
  public String getUsername() { return this.username; }
  public String getPassword() { return this.password; }
  public String getAddress() { return this.address; }
  public String getPhone() { return this.phone; }

  public void register() {}
  public void getProfile() {}
  public void updateProfile() {}
  public void updatePassword() {}

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
    return "login";
  }
}
