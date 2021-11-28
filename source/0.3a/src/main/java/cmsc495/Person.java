package cmsc495;

public class Person {

  private Integer id = 0;
  private String lastname = "";
  private String firstname = "";
  private Integer age = 0;

  public Person() {}
  public Person(Integer id, String last, String first, Integer age) {
    this.id = id;
    this.firstname = first;
    this.lastname = last;
    this.age = age;
  }

  public void setid(Integer id) { this.id = id; }
  public void setfirstname(String first) { this.firstname = first; }
  public void setlastname(String last) { this.lastname = last; }
  public void setage(Integer age) { this.age = age; }

  public Integer getid() { return this.id; }
  public String getfirstname() { return this.firstname; }
  public String getlastname() { return this.lastname; }
  public Integer getage() { return this.age; }
}
