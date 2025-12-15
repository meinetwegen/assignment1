import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class LibraryApp {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private int readIntSafely(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input");
            }
        }
    }

    public void run() {

        while (true) {
            System.out.println("\nWelcome to Library App!");
            System.out.println("1. Print all books");
            System.out.println("2. Add new book");
            System.out.println("3. Search books by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Delete a book by id");
            System.out.println("7. Quit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    printAllBooks();
                    break;
                case "2":
                    addNewBook();
                    break;
                case "3":
                    searchBooks();
                    break;
                case "4":
                    borrowBook();
                    break;
                case "5":
                    returnBook();
                    break;
                case "6":
                    deleteBook();
                    break;
                case "7":
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book b : books) {
                System.out.println(b.toString());
            }
        }
    }

    private void addNewBook() {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();

        int year = readIntSafely("Year: ");

        try {
            Book newBook = new Book(title, author, year);
            books.add(newBook);
            System.out.println("Book added id: " + newBook.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }

    private void searchBooks() {
        System.out.print("Enter part of the title: ");
        String part = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(part)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found");
        }
    }

    private void borrowBook() {
        int id = readIntSafely("Enter Book ID: ");

        for (Book b : books) {
            if (b.getId() == id) {
                if (b.getAvailable()) {
                    b.markAsBorrowed();
                    System.out.println("Book borrowed successfully");
                } else {
                    System.out.println("Book already borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void returnBook() {
        int id = readIntSafely("Enter Book ID: ");

        for (Book b : books) {
            if (b.getId() == id) {
                if (!b.getAvailable()) {
                    b.markAsReturned();
                    System.out.println("Book returned");
                } else {
                    System.out.println("Book already available");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void deleteBook() {
        int id = readIntSafely("Enter Book ID to delete: ");

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                System.out.println("Book deleted");
                return;
            }
        }
        System.out.println("Book not found");
    }
}