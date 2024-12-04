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

public class Node {
    String name;
    String address;
    String city;
    String phoneNumber;
    Node next;

    // Initializing strings
    public Node(String name, String address, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = null;
    } // end of Node

    @Override
    public String toString() {
        return String.format("Name: %s, Address: %s, City: %s, Phone Number: %s", name, address, city, phoneNumber);
    }// end of public Node
}// end of class Node