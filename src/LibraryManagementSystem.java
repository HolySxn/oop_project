import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Borrow a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. Display Available Books");
            System.out.println("4. Add a Book");
            System.out.println("5. Remove a Book");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book to borrow: ");
                    scanner.nextLine();
                    String borrowTitle = scanner.nextLine();
                    library.borrowItem(borrowTitle);
                    break;

                case 2:
                    System.out.print("Enter the title of the book to return: ");
                    scanner.nextLine();
                    String returnTitle = scanner.nextLine();
                    library.returnItem(returnTitle);
                    break;

                case 3:
                    library.displayAvailableItems();
                    break;

                case 4:
                    System.out.print("Enter book ID: ");
                    int book_id = scanner.nextInt();
                    System.out.print("Enter the title of the new book: ");
                    scanner.nextLine();
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter the year of publication: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter the author of the new book: ");
                    scanner.nextLine();
                    String newAuthor = scanner.nextLine();

                    library.addItem(book_id, newTitle, year, newAuthor);
                    break;

                case 5:
                    System.out.print("Enter the ID of the item to remove: ");
                    int removeId = scanner.nextInt();

                    library.removeItem(removeId);
                    break;

                case 6:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}


