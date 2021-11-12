package cmsc495;

import java.util.Date;

public class Medication {
  
  private String name = "";
  private double dosage = 0;
  private String doseUnit = "";
  private Date issueDate;
  private Date expDate;
  private Provider prescriber;
  
  public Medication(String name, double dosage, String doseunit, Date issued, Date expired, Provider provider) {
    this.name = name;
    this.dosage = dosage;
    this.doseUnit = doseunit;
    this.issueDate = issued;
    this.expDate = expired;
    this.prescriber = provider;
  }  
  
  public String setName(String name) {
    
    return name;
  }
  public double setDosage(double dose) {
    
    return dose;
  }
  public String setDoseUnit(String unit) {
    
    return unit;
  }
  public Date setExpDate(Date expdate) {
    
    return expdate;
  }
  
}
