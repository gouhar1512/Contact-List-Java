package packages.Regex;

public class Regex {
  public static boolean isNumeric(char c) {
    String test = "" + c;
    return test.matches("[0-9]+");
  }

  public static boolean isAlpha(char c) {
    String test = "" + c;
    return test.matches("[A-Za-z]+");
  }

  public static boolean isAlphaNumeric(char c) {
    String test = "" + c;
    return test.matches("[A-Za-z0-9]+");
  }

  public static boolean isValidPhone() {
    return true;
  }

  public static boolean isValidEmail() {
    return true;
  }
}
