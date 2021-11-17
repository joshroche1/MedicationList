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
  
  public Patient() {
    
  }
  
  public String getTest() {
    return this.testinfo;
  }
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
