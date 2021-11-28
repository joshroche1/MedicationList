package cmsc495;

import cmsc495.DButil;

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
    } else {
      DButil dbu = new DButil();
      if (dbu.validateUser(username,password)) { return true; }
    }
    return false;
  }
  public static boolean validateProvider(String user, String pass, String tkn) {
    String username = user.trim();
    String password = pass.trim();
    String token = tkn.trim();
    if (username.equals("provider")) {
      if (password.equals("password") && token.equals("1111111")) { return true; }
    } else if (username.equals("instructor")) {
      if (password.equals("cmsc495") && token.equals("9999999")) { return true; }
    } else {
      DButil dbu = new DButil();
      if (dbu.validateUser(user, pass, tkn)) { return true; }
    }
    return false;
  }
}
