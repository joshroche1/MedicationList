package cmsc495;

import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanMedication", eager = true)
public class Medication {
  
  private String name = "";
  private double dosage = 0;
  private String doseUnit = "";
  private Date issueDate;
  private Date expDate;
  private Provider prescriber;
  private String testinfo = "MEDICATION Meds meds!";
  
  //Constructor method (basic)
  public Medication(String name, double dosage, String doseUnit) {
	  this.name = name;
	  this.dosage = dosage;
	  this.doseUnit = doseUnit;
  }
  
  //Constructor method for Medication Class
  public Medication(String name, double dosage, String doseUnit, Date issued, Date expired, Provider provider) {
    this.name = name;
    this.dosage = dosage;
    this.doseUnit = doseUnit;
    this.issueDate = issued;
    this.expDate = expired;
    this.prescriber = provider;
  }  
  
  public String getTest() {
    return this.testinfo;
  }
  
  //This method will update the dosage to the new amount
  public void setDosage(double dose) {
    this.dosage = dose;
  }
  
  //This method will update the unit of measurement for the dosage amount
  public void setDoseUnit(String unit) {
    this.doseUnit = unit;
  }
  
  //This method will set the new expiration date for a medication
  public void setExpDate(Date expdate) {
    this.expDate = expdate;
  }
  
  //This method will retrn the name of a medication
  public String getMedicationName() {
    return this.name;
  }
  
  //This method will return the dosage of a certain medication
  public double getDosage() {
    return this.dosage;
  }
  
  //This method will return the unit of measurement for a particular medication
  public String getDoseUnit() {
    return this.doseUnit;
  }
 
  //This method will return the date that a particular medication was prescribed
  public Date getIssueDate() {
    return this.issueDate;
  }
  
  //This method will return the expiration date for the specified medication
  public Date getExpDate() {
    return this.expDate;
  }
  
  //This method will return the name of the physician that prescribed a particular prescription
  public Provider getPrescriber() {
    return this.prescriber;
  } 
}
