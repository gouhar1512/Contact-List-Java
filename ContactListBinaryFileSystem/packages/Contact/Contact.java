package packages.Contact;

import java.io.Serializable;

public class Contact implements Serializable {
  public String id;
  public String name;
  public String phoneNum;

  public Contact() {
    id = "";
    name = "";
    phoneNum = "";
  }

  public Contact(String argId, String argName, String argPhNo) {
    id = argId;
    name = argName;
    phoneNum = argPhNo;
  }
}
