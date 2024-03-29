import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        DatabaseConnection connection = new DatabaseConnection();
        Library library = new Library(connection);
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("1. Sign in as manager");
            System.out.println("2. Sign in as user");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    ManagerAuthentication authentication = new ManagerAuthentication(connection);
                    System.out.print("Enter the id: ");
                    int manager_id = scanner.nextInt();
                    System.out.print("Enter the password: ");
                    scanner.nextLine();
                    String manager_password = scanner.nextLine();

                    if (authentication.authenticate(manager_id, manager_password)){
                        Manager manager = new Manager(manager_id, connection);
                        System.out.println("Welcome, " + manager.get_name(manager_id));
                        System.out.println();
                        while (true){
                            System.out.println("1. Display Available Books");
                            System.out.println("2. Add a Book");
                            System.out.println("3. Remove a Book");
                            System.out.println("4. Exit");

                            System.out.print("Enter your choice (1-4): ");
                            int choice2 = scanner.nextInt();
                            System.out.println();

                            switch (choice2) {
                                case 1:
                                    library.displayAvailableItems();
                                    break;
                                case 2:
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

                                    Book book = new Book(book_id, newTitle, newAuthor, year);
                                    library.addItem(book);
                                    break;
                                case 3:
                                    System.out.print("Enter the ID of the item to remove: ");
                                    int removeId = scanner.nextInt();

                                    library.removeItem(removeId);
                                    break;
                                case 4:
                                    System.out.println("Exiting the Library Management System. Goodbye!");
                                    scanner.close();
                                    System.exit(0);

                                default:
                                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                            }
                        }

                    }
                    break;

                case 2:
                    CustomerAuthentication authentication1 = new CustomerAuthentication(connection);
                    System.out.print("Enter the id: ");
                    int customer_id = scanner.nextInt();
                    System.out.print("Enter the password: ");
                    scanner.nextLine();
                    String customer_password = scanner.nextLine();

                    if (authentication1.authenticate(customer_id, customer_password)){
                        Customer customer = new Customer(customer_id, connection);
                        System.out.println("Welcome, " + customer.get_name(customer_id));
                        System.out.println();
                        while (true){
                            System.out.println("1. Display Available Books");
                            System.out.println("2. Borrow a Book");
                            System.out.println("3. Return a Book");
                            System.out.println("4. Exit");

                            System.out.print("Enter your choice (1-4): ");
                            int choice2 = scanner.nextInt();
                            System.out.println();

                            switch (choice2) {
                                case 1:
                                    library.displayAvailableItems();
                                    break;
                                case 2:
                                    System.out.print("Enter the title of the book to borrow: ");
                                    scanner.nextLine();
                                    String borrowTitle = scanner.nextLine();
                                    library.borrowItem(borrowTitle, customer_id);
                                    break;
                                case 3:
                                    System.out.print("Enter the title of the book to return: ");
                                    scanner.nextLine();
                                    String returnTitle = scanner.nextLine();
                                    library.returnItem(returnTitle);
                                    break;
                                case 4:
                                    System.out.println("Exiting the Library Management System. Goodbye!");
                                    scanner.close();
                                    System.exit(0);

                                default:
                                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                            }
                        }

                    }
                    break;

                case 3:
                    System.out.println("Exiting the Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }
}


