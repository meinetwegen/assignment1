import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static double readDoubleSafely(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Checking Rectangle class");

        Rectangle rectangle1 = new Rectangle(3.0, 2.0);
        System.out.println("Rectangle 1: " + rectangle1.toString());
        System.out.println("Area: " + rectangle1.area());
        System.out.println("Perimeter: " + rectangle1.perimeter());
        System.out.println("ID: " + rectangle1.getId());

        Rectangle rectangle2 = new Rectangle();
        System.out.println("Rectangle 2: " + rectangle2.toString());

        rectangle2.setHeight(5.0);
        rectangle2.setWidth(5.0);
        System.out.println("Rectangle 2: " + rectangle2.toString());

        try {
            System.out.print("Test Invalid Width: ");
            rectangle1.setWidth(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Hand-Checking Rectangle class");

        double inputWidth = readDoubleSafely("width: ");
        double inputHeight = readDoubleSafely("height: ");

        try {
            Rectangle interactiveRectangle = new Rectangle(inputWidth, inputHeight);
            System.out.println("\nCreated Rectangle: ");
            System.out.println(interactiveRectangle.toString());
            System.out.println("Area: " + interactiveRectangle.area());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nLibrary App check");

        LibraryApp app = new LibraryApp();
        app.run();
    }
}