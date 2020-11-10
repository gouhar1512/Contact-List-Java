import java.util.*;
import packages.ContactList.ContactList;
import packages.utilityFunction.utilityFunction;

public class Main {

    public static void print(String s) {
        System.out.print(s);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ContactList myContactList = new ContactList();
        utilityFunction.clearScreen();
        // myContactList.addDummyContacts();
        myContactList.loadContacts();
        print("\nWelcome to Phone Management System ");
        int wantToContinue = 1;
        while (wantToContinue != 0) {
            // Giving choice to users
            print("\n\nSelect Option: ");
            print("\n1. Add Contact");
            print("\n2. Find Contact");
            print("\n3. Update Contact");
            print("\n4. Delete Contact");
            print("\n5. Show all contacts");
            print("\n6. Exit");
            print("\nEnter choice : ");

            // Handling input
            String input = sc.next();
            if (input.length() != 1) {
                continue;
            }
            int option = Integer.parseInt(input);
            if (option < 0 || option > 6) {
                continue;
            }

            // Selecting option
            switch (option) {
                case 1 -> myContactList.addContact();
                case 2 -> myContactList.findContact();
                case 3 -> myContactList.updateContact();
                case 4 -> myContactList.deleteContact();
                case 5 -> myContactList.showAllContacts();
                default -> wantToContinue = 0;
            }
        }
        sc.close();
    }
}

/*
 * TO-DO =================================
 * 
 * Saving and retrieving data from
 * 
 * 1. Binary File 2.json file 3.mysql 4.mongodb
 * 
 * Adding UI using Applet Programming
 * 
 * Complete Full Stack with Java as backend
 *
 * Using set for storing unique contacts and sorted according to name
 * 
 * Using Regex for phone validation
 * 
 * variable arguments in java Adding feature that while updating contacts, if we
 * need to change only one field then remaining field remains the same as
 * earlier. Alternative : Give options which field number you want to update,
 * enter the fields * * separated by space.
 *
 */

/**
 * To study io streams in
 * 
 * java Serialization in java
 */