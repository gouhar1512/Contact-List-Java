package packages.ContactList;

import java.util.*;
import java.nio.charset.*;
import packages.Regex.*;
import packages.Contact.*;
import packages.FileSystem.FileSystem;

public class ContactList {

  public void print(String s) {
    System.out.print(s);
  }

  Scanner sc = new Scanner(System.in);
  ArrayList<Contact> contactList = new ArrayList<Contact>();

  public void printContact(Contact c) {
    System.out.printf("\nName : %s", c.name);
    System.out.printf("\nPhone : %s", c.phoneNum);
  }

  public String generateUniqueId() {

    int lenghtOfUniqueId = 10;
    byte array[] = new byte[256];
    new Random().nextBytes(array);
    String randomString = new String(array, Charset.forName("UTF-8"));
    StringBuffer uid = new StringBuffer();

    for (int i = 0; i < randomString.length(); i++) {
      char ch = randomString.charAt(i);
      if (Regex.isAlphaNumeric(ch)) {
        uid.append(ch);
        lenghtOfUniqueId--;
      }
      if (lenghtOfUniqueId <= 0) {
        break;
      }
    }
    return uid.toString();
  }

  public void addContact() {
    String name, phoneNum;
    print("\nEnter name: ");
    name = sc.next();
    print("Enter phone: ");
    phoneNum = sc.next();

    Boolean nameAlreadyPresent = false;
    Boolean phoneAlreadyPresent = false;

    if (findContactBy(name) != null) {
      nameAlreadyPresent = true;
    }
    if (findContactBy(phoneNum) != null) {
      phoneAlreadyPresent = true;
    }

    if (nameAlreadyPresent) {
      print("\nContact with same name already present");
    } else if (phoneAlreadyPresent) {
      print("\nContact with same number already present");
    } else {
      Contact newContact = new Contact(generateUniqueId(), name, phoneNum);
      print("\nContact added");
      contactList.add(newContact);
    }

    saveToFile();
  }

  public Contact findContactBy(String str) {
    for (Contact c : contactList) {
      if (str.equalsIgnoreCase(c.name) || str.equalsIgnoreCase(c.phoneNum)) {
        return c;
      }
    }
    return null;

  }

  public Contact findContact() {
    print("\nEnter name: ");
    String name;
    name = sc.next();
    Contact c = findContactBy(name);
    if (c != null) {
      printContact(c);
    } else {
      print("\nContact not found");
    }
    return c;
  }

  public void updateContact() {

    print("\nUpdate Contact");
    Contact c = findContact();
    if (c != null) {
      Contact newContact = new Contact(generateUniqueId(), c.name, c.phoneNum);
      System.out.printf("\nNew Name: ");
      newContact.name = sc.next();
      System.out.printf("New Phone: ");
      newContact.phoneNum = sc.next();
      c.name = newContact.name;
      c.phoneNum = newContact.phoneNum;
      print("\nContact Updated\n");
    }
    saveToFile();

  }

  public void deleteContact() {
    print("\nDelete Contact");
    Contact c = findContact();
    if (c != null) {
      char confirm;
      while (true) {
        print("\nDo you want to delete[y / n]: ");
        confirm = sc.next().charAt(0);
        if (confirm == 'y' || confirm == 'Y' || confirm == 'n' || confirm == 'N') {
          break;
        }
      }
      if (confirm == 'y' || confirm == 'Y') {
        contactList.remove(c);
        print("\nContact deleted");
      }
    }
    saveToFile();

  }

  public void showAllContacts() {
    print("\n\t\t--------------------------------------");
    print("\n\t\tSno.\tID\t\tName\tPhone");
    print("\n\t\t--------------------------------------");
    int sNo = 0;
    for (Contact c : contactList) {
      System.out.printf("\n\t\t%s\t%s\t%s\t%s", ++sNo, c.id, c.name, c.phoneNum);
    }
    print("\n\t\t--------------------------------------");
  }

  public void saveToFile() {
    FileSystem myFileSystem = new FileSystem();
    myFileSystem.writeFile(contactList);
  }

  public void loadContacts() {
    FileSystem myFileSystem = new FileSystem();
    ArrayList<Contact> dataFromFile = new ArrayList<Contact>();
    dataFromFile = myFileSystem.readFile();

    for (Contact c : dataFromFile) {
      contactList.add(c);
    }
  }

}

// BKr5gyvsuI ushran 852
// vsQLP1rCbW aman 9887
// IPf62I7Eff vaibhav 4865
// vWXhQ5Uawm rahul 788755
// xDKsvlk5IM sadique 9887554
