package cmsc495;

import java.util.Date;

public class Medication {
  
  private String name = "";
  private double dosage = 0;
  private String doseUnit = "";
  private Date issueDate;
  private Date expDate;
  private Provider prescriber;
  private String testinfo = "MEDICATION Meds meds!";
  
  public Medication(String name, double dosage, String doseunit, Date issued, Date expired, Provider provider) {
    this.name = name;
    this.dosage = dosage;
    this.doseUnit = doseunit;
    this.issueDate = issued;
    this.expDate = expired;
    this.prescriber = provider;
  }  
  
  public String getTest() {
    return this.testinfo;
  }
  
  public double setDosage(double dose) {
    this.dosage = dose;
    return dose;
  }
  public String setDoseUnit(String unit) {
    this.doseUnit = unit;
    return unit;
  }
  public Date setExpDate(Date expdate) {
    this.expDate = expdate;
    return expdate;
  }
  public String getName() {
    return this.name;
  }
  public double getDosage() {
    return this.dosage;
  }
  public String getDoseUnit() {
    return this.doseUnit;
  }
  public Date getIssueDate() {
    return this.issueDate;
  }
  public Date getExpDate() {
    return this.expDate;
  }
  public Provider getPrescriber() {
    return this.prescriber;
  }
}
