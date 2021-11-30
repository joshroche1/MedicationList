package cmsc495;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "beanmyRx", eager = true)
public class myRx {

  private String testinfo = "myRx test";


  public String getTest() {
    return this.testinfo;
  }
/*
  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

  }
*/
}
