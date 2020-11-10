package packages.utilityFunction;

import java.util.concurrent.TimeUnit;

public class utilityFunction {
  public static void clearScreen() {
    try {
      if (System.getProperty("os.name").contains("Windows"))
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      else
        Runtime.getRuntime().exec("clear");
    } catch (Exception exception) {

    }
  }

  public static void showProgressBar() {
    for (int i = 0; i < 40; i++) {
      System.out.print("#");
      try {
        TimeUnit.MILLISECONDS.sleep(40);
      } catch (Exception e) {

      }
    }
  }

}
