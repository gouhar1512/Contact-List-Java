package packages.FileSystem;

import java.io.*;
import java.util.ArrayList;
import packages.Contact.Contact;

public class FileSystem {

  String file_url = "records.dat";

  public File createFile() {
    File f = new File(file_url);
    try {
      // Creating file and writing null as first entry
      f.createNewFile();
      ObjectOutputStream oos = null;
      FileOutputStream fos = new FileOutputStream(f);
      oos = new ObjectOutputStream(fos);
      oos.writeObject(null);
      oos.close();
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
    ObjectInputStream ois = null;
    try {
      File objFile = openFile();
      FileInputStream fis = new FileInputStream(objFile);
      ois = new ObjectInputStream(fis);
      while (true) {
        Contact c = (Contact) ois.readObject();
        if (c == null) {
          break;
        }
        contactList.add(c);
      }
    } catch (IOException | ClassNotFoundException e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        if (ois != null)
          ois.close();
      } catch (IOException ioe) {
      }
    }
    return contactList;
  }

  public void writeFile(ArrayList<Contact> contactList) {
    ObjectOutputStream oos = null;
    try {
      File objFile = openFile();
      FileOutputStream fos = new FileOutputStream(objFile);
      oos = new ObjectOutputStream(fos);
      for (Contact c : contactList) {
        oos.writeObject(c);
      }
      oos.writeObject(null);
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    } finally {
      try {
        oos.close();
      } catch (IOException ioe) {
        System.out.println(ioe.getMessage());
      }
    }
  }

}
