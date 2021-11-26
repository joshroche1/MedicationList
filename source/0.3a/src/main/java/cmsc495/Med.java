package cmsc495;


public class Med {

  private String name;
  private double dosage;
  private String doseUnit;
  private String issueDate;
  private String expDate;
  private String prescriber;

  public Med() {}

  public void setName(String name) { this.name = name; }
  public void setDosage(double dose) { this.dosage = dose; }
  public void setDoseUnit(String unit) { this.doseUnit = unit; }
  public void setIssueDate(String issue) { this.issueDate = issue; }
  public void setExpDate(String exp) { this.expDate = exp; }
  public void setPrescriber(String provider) { this.prescriber = provider; }

  public String getName() { return this.name; }
  public double getDosage() { return this.dosage; }
  public String getDoseUnit() { return this.doseUnit; }
  public String getIssueDate() { return this.issueDate; }
  public String getExpDate() { return this.expDate; }
  public String getPrescriber() { return this.prescriber; }

}
