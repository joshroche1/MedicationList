package cmsc495;

import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanMedication", eager = true)
public class Medication {

  private String name = "";
  private double dosage = 0;
  private String doseUnit = "";
  private String issueDate;
  private String expDate;
	private String patient;
  private String provider;

  public Medication() {}
  //Constructor method (basic)
  public Medication(String name, double dosage, String doseUnit) {
	  this.name = name;
	  this.dosage = dosage;
	  this.doseUnit = doseUnit;
  }

  //Constructor method for Medication Class
  public Medication(String name, double dosage, String doseUnit, String issued, String expired, String provider) {
    this.name = name;
    this.dosage = dosage;
    this.doseUnit = doseUnit;
    this.issueDate = issued;
    this.expDate = expired;
    this.provider = provider;
  }

  //
  public void setName(String name) {
    this.name = name;
  }

  //This method will update the dosage to the new amount
  public void setDosage(double dose) {
    this.dosage = dose;
  }

  //This method will update the unit of measurement for the dosage amount
  public void setDoseUnit(String unit) {
    this.doseUnit = unit;
  }

  //
  public void setIssueDate(String issue) {
    this.issueDate = issue;
  }

  //This method will set the new expiration date for a medication
  public void setExpDate(String expdate) {
    this.expDate = expdate;
  }
	
	public void setPatient(String patient) {
    this.patient = patient;
  }

  //
  public void setProvider(String provider) {
    this.provider = provider;
  }

  //This method will retrn the name of a medication
  public String getName() {
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
  public String getIssueDate() {
    return this.issueDate;
  }

  //This method will return the expiration date for the specified medication
  public String getExpDate() {
    return this.expDate;
  }
	
	//This method will return the name of the patient that is prescribed the medication
  public String getPatient() {
    return this.patient;
  }

  //This method will return the name of the physician that prescribed a particular prescription
  public String getProvider() {
    return this.provider;
  }
}
