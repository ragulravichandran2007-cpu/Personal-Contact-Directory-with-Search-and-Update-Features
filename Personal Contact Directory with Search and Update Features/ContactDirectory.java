import java.util.ArrayList;
import java.util.Scanner;

public class ContactDirectory {

    static class Contact {
        String name;
        String phone;
        String email;
        String address;

        Contact(String name, String phone, String email, String address) {
            this.name = name;
            this.phone = phone;
            this.email = email;
            this.address = address;
        }

        void display() {
            System.out.println("Name: " + name);
            System.out.println("Phone: " + phone);
            System.out.println("Email: " + email);
            System.out.println("Address: " + address);
            System.out.println("---------------------------");
        }
    }

    static ArrayList<Contact> contacts = new ArrayList<>();

    static Contact searchContact(String name) {
        for (Contact c : contacts) {
            if (c.name.equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("\n=== Personal Contact Directory ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice. Enter a number.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter address: ");
                    String address = sc.nextLine();

                    if (searchContact(name) != null) {
                        System.out.println("Contact already exists.");
                    } else {
                        contacts.add(new Contact(name, phone, email, address));
                        System.out.println("Contact added successfully!");
                    }
                    break;

                case 2:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts available.");
                    } else {
                        for (Contact c : contacts) {
                            c.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter name to search: ");
                    name = sc.nextLine();

                    Contact found = searchContact(name);

                    if (found != null) {
                        found.display();
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter name to update: ");
                    name = sc.nextLine();

                    found = searchContact(name);

                    if (found != null) {
                        System.out.print("Enter new phone number: ");
                        found.phone = sc.nextLine();

                        System.out.print("Enter new email: ");
                        found.email = sc.nextLine();

                        System.out.print("Enter new address: ");
                        found.address = sc.nextLine();

                        System.out.println("Contact updated successfully!");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter name to delete: ");
                    name = sc.nextLine();

                    found = searchContact(name);

                    if (found != null) {
                        contacts.remove(found);
                        System.out.println("Contact deleted successfully!");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting Contact Directory.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }
}