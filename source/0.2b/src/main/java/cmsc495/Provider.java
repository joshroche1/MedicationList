package cmsc495;

import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanProvider", eager = true)
public class Provider {
  
  private String lastName = "";
  private String firstName = "";
  private String middleInitial = "";
  private String email = "";
  private String password = "";
  private String address = "";
  private String phone = "";
  private String physicianId = "";
//  private String[] provider = {};
  private ArrayList patientList;

  private String testinfo = "PROVIDER Provider provider!";
  private String testLastName = "Testing";
  private String testFirstName = "Provider";
  private String testMiddleInitial = "I";
  private String testEmail = "provider@testing.net";
  private String testPassword = "testing";
  private String testAddress = "9876 Boulevard Way Cityland, STE 54321";
  private String testPhone = "19876543200";
  
  public Provider() {
    
  }
  
  public String getTest() {
    return this.testinfo;
  }
  public String getTestLastName() { return testLastName; }
  public String getTestFirstName() { return testFirstName; }
  public String getTestMiddleInitial() { return testMiddleInitial; }
  public String getTestEmail() { return testEmail; }
  public String getTestPassword() { return testPassword; }
  public String getTestAddress() { return testAddress; }
  public String getTestPhone() { return testPhone; }
  /*
  public boolean register() {
    
    return false;
  }
  public boolean authenticate() {
    
    return false;
  }
  public String[] getProfile() {
    String[] profile;
    
    
    return profile;
  }
  public boolean updateProfile(String last, String first, String middle, String email, String address, String phone) {
    
    return false;
  }
  public boolean updatePassword(String pass) {
    
    return false;
  }
  public ArrayList getPatientList() {
    return this.patientList;
  }
  public boolean addPatient(Patient patient) {
    
    return false;
  }
  public boolean delPatient(Patient patient) {
    
    return false;
  }
  public boolean updatePatient(Patient patient) {
    
    return false;
  }
  public Patient getPatient(String last, String first, String dob) {
    
    return Patient;
  }
  public boolean addMedication(Patient patient, Medication med, double dosage, String doseUnit, Date issueDate, Date expDate) {
    
    return false;
  }
  public boolean delMedication(Patient patient, Medication med) {
    
    return false;
  }
  public boolean updateMedication(Patient patient, Medication med, double dosage, String doseUnit, Date expDate) {
    
    return false;
  }
  */
}
