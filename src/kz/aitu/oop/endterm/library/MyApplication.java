package kz.aitu.oop.endterm.library;

import kz.aitu.oop.endterm.library.controllers.BookController;
import kz.aitu.oop.endterm.library.controllers.CustomerController;
import kz.aitu.oop.endterm.library.controllers.OrderController;
import kz.aitu.oop.endterm.library.entities.Book;
import kz.aitu.oop.endterm.library.entities.Customer;
import kz.aitu.oop.endterm.library.entities.Order;
import kz.aitu.oop.endterm.library.repositories.interfaces.IBookRepo;
import kz.aitu.oop.endterm.library.repositories.interfaces.ICustomerRepo;
import kz.aitu.oop.endterm.library.repositories.interfaces.IOrderRepo;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    private final BookController controller1;
    private final CustomerController controller2;
    private final OrderController controller3;
    private final Scanner scanner;

    public MyApplication(IBookRepo bookRepository, ICustomerRepo customerRepository, IOrderRepo orderRepository) {
        controller1 = new BookController(bookRepository);
        controller2 = new CustomerController(customerRepository);
        controller3 = new OrderController(orderRepository);
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all books");
            System.out.println("2. Get a book by code");
            System.out.println("3. Add a new book");
            System.out.println("4. Get all customers");
            System.out.println("5. Get a customer by id");
            System.out.println("6. Add a new customer");
            System.out.println("7. Get all orders");
            System.out.println("8. Get an order by id");
            System.out.println("9. Add a new order");
            System.out.println("10. Update email of the customer by id");
            System.out.println("11. Update return date of the book by orderID");
            System.out.println("12. Update return status of the book by orderID");
            System.out.println("13. Get all books of a specific subject(genre)");
            System.out.println("14. Get all books of a specific author");
            System.out.println("15. Get the most popular book");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-15): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllBooksMenu();
                } else if (option == 2) {
                    getBookByCodeMenu();
                } else if (option == 3) {
                    createBookMenu();
                } else if (option == 4) {
                    getAllCustomersMenu();
                } else if (option == 5) {
                    getCustomerByIDMenu();
                } else if (option == 6) {
                    createCustomerMenu();
                } else if (option == 7) {
                    getAllOrdersMenu();
                } else if (option == 8) {
                    getOrderByIDMenu();
                } else if (option == 9) {
                    createOrderMenu();
                } else if (option == 10) {
                    updateCustomerByIDMenu();
                } else if (option == 11) {
                    updateReturnDateMenu();
                } else if (option == 12) {
                    updateReturnStatusMenu();
                } else if (option == 13) {
                    getBooksBySubjectMenu();
                } else if (option == 14) {
                    getBooksByAuthorMenu();
                } else if (option == 15) {
                    getPopularBookMenu();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next();
            }
            System.out.println("*************************");
        }
    }

    public void getAllBooksMenu() {
        List<Book> response = controller1.getAllBooks();
        for (int i=0; i<response.size(); i++) {
            System.out.println(response.get(i)); }
    }

    public void getBookByCodeMenu() {
        System.out.println("Please enter code:");
        int code = scanner.nextInt();
        String response = controller1.getBook(code);
        System.out.println(response);
    }

    public void createBookMenu() {
        System.out.println("Please enter subject:");
        String subject = scanner.next();
        System.out.println("Please enter title(put '_' instead of spaces):");
        String title = scanner.next();
        System.out.println("Please enter author(put '_' instead of spaces):");
        String author = scanner.next();
        System.out.println("Please enter publisher(put '_' instead of spaces):");
        String publisher = scanner.next();
        System.out.println("Please enter number of pages:");
        int pages = scanner.nextInt();
        System.out.println("Please enter number of books:");
        int numberOfBooks = scanner.nextInt();
        int numberOfAvailableBooks = numberOfBooks;
        int numberOfBorrowedBooks = 0;
        String response = controller1.createBook(subject, title, author, publisher, pages, numberOfBooks, numberOfAvailableBooks, numberOfBorrowedBooks);
        System.out.println(response);
    }

    public void getAllCustomersMenu() {
        List<Customer> response = controller2.getAllCustomers();
        for (int i=0; i<response.size(); i++) {
            System.out.println(response.get(i)); }
    }

    public void getCustomerByIDMenu() {
        System.out.println("Please enter id:");
        int id = scanner.nextInt();
        String response = controller2.getCustomer(id);
        System.out.println(response);
    }

    public void createCustomerMenu() {
        System.out.println("Please enter name:");
        String name = scanner.next();
        System.out.println("Please enter surname:");
        String surname = scanner.next();
        System.out.println("Please enter gender (male/female):");
        String gender = scanner.next();
        System.out.println("Please enter date of birth(dd/mm/yyyy format):");
        String dateOfBirth = scanner.next();
        System.out.println("Please enter email:");
        String email = scanner.next();
        String response = controller2.createCustomer(name, surname, gender, dateOfBirth, email);
        System.out.println(response);
    }

    public void getAllOrdersMenu() {
        List<Order> response = controller3.getAllOrders();
        for (int i=0; i<response.size(); i++) {
            System.out.println(response.get(i)); }
    }

    public void getOrderByIDMenu() {
        System.out.println("Please enter id:");
        int id = scanner.nextInt();
        String response = controller3.getOrder(id);
        System.out.println(response);
    }

    public void createOrderMenu() {
        System.out.println("Please enter customerID:");
        int customerID = scanner.nextInt();
        System.out.println("Please enter bookCode:");
        int bookCode = scanner.nextInt();
        System.out.println("Please enter date(dd/mm/yyyy format):");
        String date = scanner.next();
        System.out.println("Please enter return date(dd/mm/yyyy format):");
        String returnDate = scanner.next();
        boolean returnStatus = false;
        String response = controller3.createOrder(customerID, bookCode, date, returnDate, returnStatus);
        controller1.changeA(bookCode);
        controller1.changeB(bookCode);
        System.out.println(response);
    }

    public void updateCustomerByIDMenu() {
        System.out.println("Please enter id:");
        int id = scanner.nextInt();
        System.out.println("Please enter new email:");
        String email = scanner.next();
        String response = controller2.updateCustomer(id, email);
        System.out.println(response);
    }

    public void updateReturnDateMenu() {
        System.out.println("Please enter orderID:");
        int id = scanner.nextInt();
        System.out.println("Please enter new return date(dd/mm/yyyy format):");
        String date = scanner.next();
        String response = controller3.updateOrderDate(id, date);
        System.out.println(response);
    }

    public void updateReturnStatusMenu() {
        System.out.println("Please enter orderID:");
        int id = scanner.nextInt();
        System.out.println("Was the book returned(yes/no):");
        String status = scanner.next();
        String response = controller3.updateOrderStatus(id, status);
        int bookCode = controller3.getBookCode(id);
        controller1.changeC(bookCode);
        System.out.println(response);
    }

    public void getBooksBySubjectMenu() {
        System.out.println("Please enter the subject:");
        String subject = scanner.next();
        List<Book> response = controller1.getBooksBySubject(subject);
        for (int i=0; i<response.size(); i++) {
            System.out.println(response.get(i)); }
    }

    public void getBooksByAuthorMenu() {
        System.out.println("Please enter the author(put '_' instead of spaces):");
        String author = scanner.next();
        List<Book> response = controller1.getBooksByAuthor(author);
        for (int i=0; i<response.size(); i++) {
            System.out.println(response.get(i)); }
    }

    public void getPopularBookMenu() {
        String response = controller1.getPopularBook();
        System.out.println("The most popular book in the library is:");
        System.out.println(response);
    }
}
