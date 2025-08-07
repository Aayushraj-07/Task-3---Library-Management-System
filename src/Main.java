import model.Book;
import model.User;
import service.Library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("=== Library Management System ===");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. View Books");
            System.out.println("4. View Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> addUser();
                    case 3 -> library.viewBooks();
                    case 4 -> library.viewUsers();
                    case 5 -> issueBook();
                    case 6 -> returnBook();
                    case 7 -> {
                        System.out.println("Exiting... Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter Book Title: ");
        String title = scanner.nextLine();

        library.addBook(new Book(id, title));
    }

    private static void addUser() {
        System.out.print("Enter User ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter User Name: ");
        String name = scanner.nextLine();

        library.addUser(new User(id, name));
    }

    private static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = scanner.nextInt();
        library.issueBook(id);
    }

    private static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = scanner.nextInt();
        library.returnBook(id);
    }
}
