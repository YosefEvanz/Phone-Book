//  Yosyp Vasyliev
//  CS&145
//  Assignment 2
//  Phone Book
//  For extra credit I did the following:
//  1. Created an introduction
//  2. Created a menu listing all available op
//  3. Added an ability to modify enties
//  4. Added an ability to sort them by names
//  5. Added a method that saves the input


import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        PhoneBookManager phoneBook = new PhoneBookManager();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPhone Book Menu:");
            System.out.println("1. Add Entry");
            System.out.println("2. Modify Entry");
            System.out.println("3. Delete Entry");
            System.out.println("4. Sort Entries by Name");
            System.out.println("5. Print Entries");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    phoneBook.addEntry(name, address, city, phoneNumber);
                    System.out.println("Entry added.");
                    break;
                case 2:
                    System.out.print("Enter Name of Entry to Modify: ");
                    String modifyName = scanner.nextLine();
                    System.out.print("Enter New Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter New City: ");
                    String newCity = scanner.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    if (phoneBook.modifyEntry(modifyName, newAddress, newCity, newPhoneNumber)) {
                        System.out.println("Entry modified.");
                    } else {
                        System.out.println("Entry not found.");
                    }// end of if/else
                    break;
                case 3:
                    System.out.print("Enter Name of Entry to Delete: ");
                    String deleteName = scanner.nextLine();
                    if (phoneBook.deleteEntry(deleteName)) {
                        System.out.println("Entry deleted.");
                    } else {
                        System.out.println("Entry not found.");
                    }// end of if/else
                    break;
                case 4:
                    phoneBook.sortEntriesByName();
                    System.out.println("Entries sorted by name.");
                    break;
                case 5:
                    System.out.println("Phone Book Entries:");
                    phoneBook.printEntries();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting phone book.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }// end of switch/case
        }// end of while
        scanner.close();
    }// end of main
}// end of TestClass class