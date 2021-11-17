package cmsc495;

import java.util.ArrayList;
import java.util.Date;

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
  
  public Provider() {
    
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
  public Patient getPatient(String last, String first, String middle) {
    
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
