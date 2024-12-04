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


import java.io.*;
import java.util.Scanner;

public class PhoneBookManager {
    private Node head;
    private final String fileName = "phonebook.txt";

    public PhoneBookManager() {
        loadEntriesFromFile();
    }// end of PhoneBookManager

    // Add an entry to the end and save to file
    public void addEntry(String name, String address, String city, String phoneNumber) {
        Node newNode = new Node(name, address, city, phoneNumber);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }// end of while loop
            current.next = newNode;
        }// end of if/else
        saveEntriesToFile();
    }// end of addEntry

    // Modify an existing entry by name and save to file
    public boolean modifyEntry(String name, String newAddress, String newCity, String newPhoneNumber) {
        Node current = head;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                current.address = newAddress;
                current.city = newCity;
                current.phoneNumber = newPhoneNumber;
                saveEntriesToFile();
                return true;
            }// end of if
            current = current.next;
        }// end of while
        return false;
    }// end of modifyEntry

    // Delete an entry by name and save to file
    public boolean deleteEntry(String name) {
        if (head == null) return false;

        if (head.name.equalsIgnoreCase(name)) {
            head = head.next;
            saveEntriesToFile();
            return true;
        }// end of if

        Node current = head;
        while (current.next != null && !current.next.name.equalsIgnoreCase(name)) {
            current = current.next;
        }// end of while loop

        if (current.next != null) {
            current.next = current.next.next;
            saveEntriesToFile();
            return true;
        }// end of if
        return false;
    }//end of boolean deleteEntry

    // Sort entries by name and save to file
    public void sortEntriesByName() {
        if (head == null || head.next == null) return;

        for (Node current = head; current != null; current = current.next) {
            for (Node index = current.next; index != null; index = index.next) {
                if (current.name.compareToIgnoreCase(index.name) > 0) {
                    // Swap the node data
                    String tempName = current.name;
                    String tempAddress = current.address;
                    String tempCity = current.city;
                    String tempPhoneNumber = current.phoneNumber;

                    current.name = index.name;
                    current.address = index.address;
                    current.city = index.city;
                    current.phoneNumber = index.phoneNumber;

                    index.name = tempName;
                    index.address = tempAddress;
                    index.city = tempCity;
                    index.phoneNumber = tempPhoneNumber;
                }// end of if
            }// end of for
        }// end of for
        saveEntriesToFile();
    }// end of sortEntriesByName method

    // Print all entries
    public void printEntries() {
        Node current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }// end of while
    }// end of print Entries

    // Load entries from file
    private void loadEntriesFromFile() {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] entry = scanner.nextLine().split(",");
                if (entry.length == 4) {
                    addEntry(entry[0].trim(), entry[1].trim(), entry[2].trim(), entry[3].trim());
                }// end of if
            }// end of if
        } catch (FileNotFoundException e) {
            System.out.println("No existing phone book found. Starting fresh.");
        }// end of exception
    }// end of loadEntriesFromFile

    // Save all entries to file
    private void saveEntriesToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            Node current = head;
            while (current != null) {
                writer.println(current.name + "," + current.address + "," + current.city + "," + current.phoneNumber);
                current = current.next;
            }// end of while loop
        } catch (IOException e) {
            System.out.println("Error saving entries to file.");
        }// end of exception
    }// end of main 
}// end of PhoneBookManager