package cmsc495;


public class DAOlogin {

 public static boolean validatePatient(String user, String pass) {
    String username = user.trim();
    String password = pass.trim();
    if (username.equals("patient")) {
      if (password.equals("password")) { return true; }
    } else if (username.equals("student")) {
      if (password.equals("cmsc495")) { return true; }
    } else if (username.equals("default")) {
      if (password.equals("user")) { return true; }
    }
    return false;
  }

}
