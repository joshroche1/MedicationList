package cmsc495;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import cmsc495.Medication;
import cmsc495.Patient;
import cmsc495.DAOlogin;
import cmsc495.SessionUtils;

@ManagedBean(name = "beanProvider", eager = true)
public class Provider {

  private String lastName = "";
  private String firstName = "";
  private String middleInitial = "";
  private String sex = "";
  private String email = "";
  private String username = "";
  private String password = "";
  private String address = "";
  private String phone = "";
  private ArrayList patientList;

  public Provider() {}
  public Provider(String last, String first, String email, String username, String pass) {
    this.lastName = last;
    this.firstName = first;
    this.email = email;
    this.username = username;
    this.password = pass;
  }

  public void setLastName(String last) { this.lastName = last; }
  public void setFirstName(String first) { this.firstName = first; }
  public void setMiddleInitial(String mi) { this.middleInitial = mi; }
  public void setEmail(String em) { this.email = em; }
  public void setSex(String sx) { this.sex = sx; }
  public void setUsername(String user) { this.username = user; }
  public void setPassword(String pass) { this.password = pass; }
  public void setAddress(String address) { this.address = address; }
  public void setPhone(String phone) { this.phone = phone; }

  public String getLastName() { return this.lastName; }
  public String getFirstName() { return this.firstName; }
  public String getMiddleInitial() { return this.middleInitial; }
  public String getSex() { return this.sex; }
  public String getEmail() { return this.email; }
  public String getUsername() { return this.username; }
  public String getPassword() { return this.password; }
  public String getAddress() { return this.address; }
  public String getPhone() { return this.phone; }

  public void addPatient() {}
  public Patient getPatient(String last, String first, String dob) {
    Patient pt = null;

    return pt;
  }

  public String validateUsernamePassword() {
  boolean valid = DAOlogin.validateProvider(username, password, "token");
    if (valid) {
      HttpSession sess = SessionUtils.getSession();
      sess.setAttribute("username", username);
      return "provider-meds";
    } else {
      FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                   FacesMessage.SEVERITY_INFO, "Incorrect username, password, and/or token", "..."));
      return "provider-login";
    }
  }

  public String logout() {
    HttpSession session = SessionUtils.getSession();
    session.invalidate();
    return "index";
  }
}
