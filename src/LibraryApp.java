import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private ArrayList<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("Welcome to Library App!");

        while (true) {
            System.out.println("Menu");
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
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
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
        System.out.print("Year: ");
        int year = Integer.parseInt(scanner.nextLine());

        Book newBook = new Book(title, author, year);
        books.add(newBook);
        System.out.println("Book added");
    }

    private void searchBooks() {
        System.out.print("Input part of the title: ");
        String part = scanner.nextLine().toLowerCase();

        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(part)) {
                System.out.println(b);
            }
        }
    }

    private void borrowBook() {
        System.out.print("Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Book b : books) {
            if (b.getId() == id) {
                if (b.getAvailable() == true) {
                    b.markAsBorrowed();
                    System.out.println("Borrowed the book");
                } else {
                    System.out.println("The book is already borrowed");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void returnBook() {
        System.out.print("Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (Book b : books) {
            if (b.getId() == id) {
                if (b.getAvailable() == false) {
                    b.markAsReturned();
                    System.out.println("Book returned");
                } else {
                    System.out.println("This book is already available");
                }
                return;
            }
        }
        System.out.println("Book not found");
    }

    private void deleteBook() {
        System.out.print("Book ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                System.out.println("Book deleted");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}