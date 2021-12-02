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
  private String token = "";
  private ArrayList patientList;
  private String testinfo = "PROVIDER Provider provider!";

  public Provider() {}
  public Provider(String last, String first, String email, String username, String pass, String tkn) {
    this.lastName = last;
    this.firstName = first;
    this.email = email;
    this.username = username;
    this.password = pass;
    this.token = tkn;
  }

  public void setLastName(String last) { this.lastName = last; }
  public void setFirstName(String first) { this.firstName = first; }
  public void setMiddleInitial(String mi) { this.middleInitial = mi; }
  public void setEmail(String em) { this.email = em; }
  public void setSex(String sx) { this.sex = sx; }
  public void setUsername(String user) { this.username = user; }
  public void setPassword(String pass) { this.password = pass; }
  public void setToken(String token) { this.token = token; }
  public void setAddress(String address) { this.address = address; }
  public void setPhone(String phone) { this.phone = phone; }

  public String getLastName() { return this.lastName; }
  public String getFirstName() { return this.firstName; }
  public String getMiddleInitial() { return this.middleInitial; }
  public String getSex() { return this.sex; }
  public String getEmail() { return this.email; }
  public String getUsername() { return this.username; }
  public String getPassword() { return this.password; }
  public String getToken() { return this.token; }
  public String getAddress() { return this.address; }
  public String getPhone() { return this.phone; }

  public void addPatient() {}
  public Patient getPatient(String last, String first, String dob) {
    Patient pt = null;

    return pt;
  }

  public List<Patient> getPatients() {
    List<Patient> patients = new ArrayList<Patient>();
    // FILLER
    String[] lastNames = {"Doe","Doe","Bimmy"};
    String[] firstNames = {"John","Jane","Jimmy"};
    String[] midinits = {"R","L","J"};
    String[] emails = {"john@doe.net","jane@doe.net","jimmy@thebimmy.com"};
    String[] addresses = {"123 Street Way, Citytown ZZ 99999","123 Street Way, Citytown ZZ 99999","1 Final Blvd, Fightville ZZ 99999"};
    String[] phones = {"123-456-7890","987-654-3210","111-111-1111"};
    for (int i = 0; i < 3; i++) {
      Patient patient = new Patient();
      patient.setLastName(lastNames[i]);
      patient.setFirstName(firstNames[i]);
      patient.setMiddleInitial(midinits[i]);
      patient.setEmail(emails[i]);
      patient.setAddress(addresses[i]);
      patient.setPhone(phones[i]);
      patients.add(patient);
    }
    return patients;
  }
  public List<Medication> getMedications() {
    List<Medication> medications = new ArrayList<Medication>();
    // FILLER
    String[] names = {"Placebex","Placebropril"};
    double[] doses = {10.2, 105};
    String[] units = {"ug","mg"};
    String[] issueds = {"21 Nov 2020","15 Feb 2021"};
    String[] exps = {"10 Dec 2021","2 Jul 2022"};
    for (int i = 0; i < 2; i++) {
      Medication medication = new Medication();
      medication.setName(names[i]);
      medication.setDosage(doses[i]);
      medication.setDoseUnit(units[i]);
      medication.setIssueDate(issueds[i]);
      medication.setExpDate(exps[i]);
      medications.add(medication);
    }
    return medications;
  }

  public String validateUsernamePassword() {
  boolean valid = DAOlogin.validateProvider(username, password, token);
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
