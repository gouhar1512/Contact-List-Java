package packages.FileSystem;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.ArrayList;
import packages.Contact.Contact;

public class FileSystem {

  String file_url = "records.txt";

  public File createFile() {
    File f = new File(file_url);
    try {
      f.createNewFile();
    } catch (IOException e) {
      System.out.println("Error: Can't create file");
    }
    return f;
  }

  public File openFile() {
    File f = new File(file_url);
    if (f.exists() == false) {
      f = createFile();
    }
    return f;
  }

  public ArrayList<Contact> readFile() {
    ArrayList<Contact> contactList = new ArrayList<Contact>();
    try {
      Scanner x;
      File f = openFile();
      x = new Scanner(f);
      while (x.hasNext()) {
        String id = x.next();
        String name = x.next();
        String phoneNum = x.next();
        Contact c = new Contact(id, name, phoneNum);
        contactList.add(c);
      }
      x.close();
    } catch (Exception e) {
      System.out.println("Error:  can't open file");
    }
    return contactList;
  }

  public void writeFile(ArrayList<Contact> contactList) {
    try {
      Formatter x;
      x = new Formatter("records.txt");
      for (Contact c : contactList) {
        x.format("%s %s %s\n", c.id, c.name, c.phoneNum);
      }
      x.close();
    } catch (Exception e) {
      System.out.println("Error:  can't save to file");
    }
  }
}
