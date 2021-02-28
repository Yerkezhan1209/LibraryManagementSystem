package kz.aitu.oop.endterm.library.controllers;

import kz.aitu.oop.endterm.library.entities.Customer;
import kz.aitu.oop.endterm.library.entities.Order;
import kz.aitu.oop.endterm.library.repositories.interfaces.IOrderRepo;

import java.sql.Date;
import java.util.List;

public class OrderController {
    private final IOrderRepo repo;

    public OrderController(IOrderRepo repo) {
        this.repo = repo;
    }

    public String createOrder(int customerID, int bookCode, String date, String returnDate, boolean returnStatus) {
        Order order = new Order(customerID, bookCode, date, returnDate, returnStatus);
        boolean created = repo.createOrder(order);
        return (created ? "Order was added!" : "Order addition was failed!");
    }

    public String getOrder(int code) {
        Order order = repo.getOrder(code);
        return (order == null ? "Order was not found!" : order.toString());
    }

    public List<Order> getAllOrders() {
        List<Order> orders = repo.getAllOrders();
        return orders;
    }

    public String updateOrderDate(int id, String date) {
        boolean updated = repo.updateOrderDate(id, date);
        return (updated ? "Return date was updated!" : "Return date update was failed!");
    }

    public String updateOrderStatus(int id, String status) {
        boolean returned = (status.toLowerCase().equals("yes"));
        boolean updated = repo.updateOrderStatus(id, returned);
        return (updated ? "Return status was updated!" : "Return status update was failed!");
    }

    public int getBookCode(int id) {
        int bookcode = repo.getBookCode(id);
        return bookcode;
    }
}
