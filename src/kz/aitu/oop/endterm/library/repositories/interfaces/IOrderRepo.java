package kz.aitu.oop.endterm.library.repositories.interfaces;

import kz.aitu.oop.endterm.library.entities.Order;
import java.util.List;

public interface IOrderRepo {
    boolean createOrder(Order order);
    Order getOrder(int id);
    List<Order> getAllOrders();
    boolean updateOrderDate(int id, String date);
    boolean updateOrderStatus(int id, boolean returned);
    int getBookCode(int id);
}
