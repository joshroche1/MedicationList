package cmsc495;

public class dbtest {

  private Integer id;
  private String lastname;
  private String firstname;
  private Integer age;

  public dbtest() {}

  public dbtest(Integer id, String last, String first, Integer age) {
    this.id = id;
    this.lastname = last;
    this.firstname = first;
    this.age = age;
  }

  public Integer getid() { return id; }
  public String getlastname() { return lastname; }
  public String getfirstname() { return firstname; }
  public Integer getage() { return age; }

  public void setid(Integer id) { this.id = id; }
  public void setlastname(String last) { this.lastname = last; }
  public void setfirstname(String first) { this.firstname = first; }
  public void setage(Integer age) { this.age = age; }
}
