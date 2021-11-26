package cmsc495;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "beanMeds", eager = true)
public class MedBean {

  public List<Med> getMeds() {
    List<Med> meds = new ArrayList<Med>();
    Med med = new Med();
    med.setName("Placebo");
    med.setDosage(10.5);
    med.setDoseUnit("mg");
    med.setIssueDate("21 Sep 2021");
    med.setExpDate("20 Sep 2022");
    med.setPrescriber("Dr. Robotnik");
    meds.add(med);
    return meds;
  }

}
