package cmsc495;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanPatient", eager = true)
public class Patient {
  
  private String lastName = "";
  private String firstName = "";
  private String middleInitial = "";
  private String email = "";
  private String password = "";
  private String address = "";
  private String phone = "";
  private ArrayList medicationList;
  private String testinfo = "PATIENT Patient patient!!";

  private String testLastName = "Testing";
  private String testFirstName = "Patient";
  private String testMiddleInitial = "M";
  private String testEmail = "patient@testing.net";
  private String testPassword = "testing";
  private String testAddress = "1234 Road St. Villageville, STE 56789";
  private String testPhone = "12345678900";

  public Patient() {
    
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
  public ArrayList getMedList() {
    return this.medicationList;
  }
  */
}
