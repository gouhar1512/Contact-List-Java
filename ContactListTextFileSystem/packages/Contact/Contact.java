package packages.Contact;

public class Contact {
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
