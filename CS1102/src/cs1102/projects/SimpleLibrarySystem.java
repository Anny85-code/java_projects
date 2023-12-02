package cs1102.projects;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleLibrarySystem {

    private static Map<String, Integer> library = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMenu();
            choice = getUserChoice();

            switch (choice) {
                case 1:
                    addBooks();
                    break;
                case 2:
                    borrowBooks();
                    break;
                case 3:
                    returnBooks();
                    break;
                case 4:
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Simple Library System Menu:");
        System.out.println("1. Add Books");
        System.out.println("2. Borrow Books");
        System.out.println("3. Return Books");
        System.out.println("4. Exit");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume the invalid input
        }

        return scanner.nextInt();
    }

    private static void addBooks() {
        System.out.println("Add Books:");
        System.out.print("Enter book title: ");
        String title = scanner.next();
        System.out.print("Enter quantity: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume the invalid input
        }

        int quantity = scanner.nextInt();

        library.put(title, library.getOrDefault(title, 0) + quantity);
        System.out.println("Book added/updated in the library: " + title);
    }

    private static void borrowBooks() {
        System.out.println("Borrow Books:");
        System.out.print("Enter book title: ");
        String title = scanner.next();
        System.out.print("Enter the number of books to borrow: ");

        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // consume the invalid input
        }

        int quantityToBorrow = scanner.nextInt();
        
        if(!library.containsKey(title)) {
        	System.out.println("The book you have entered is not available in the Library");
        	System.out.println("Please enter an available book");
        } else if (library.containsKey(title) && library.get(title) >= quantityToBorrow) {
            library.put(title, library.get(title) - quantityToBorrow);
            System.out.println("Borrow successful. Enjoy reading!");
        } 
        else {
            System.out.println("Sorry, the requested number of books is not available.");
        }
    }

    private static void returnBooks() {
        System.out.println("Return Books:");
        System.out.print("Enter book title: ");
        String title = scanner.next();

        if (library.containsKey(title)) {
            System.out.print("Enter the number of books to return: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume the invalid input
            }

            int quantityToReturn = scanner.nextInt();

            int currentQuantity = library.get(title);

            if (quantityToReturn <= currentQuantity) {
                library.put(title, currentQuantity - quantityToReturn);
                System.out.println("Return successful. Thank you!");
            } else {
                System.out.println("Error: The number of books to return exceeds the available quantity.");
            }
        } else {
            System.out.println("Error: Book not found in the library.");
        }
    }

}
