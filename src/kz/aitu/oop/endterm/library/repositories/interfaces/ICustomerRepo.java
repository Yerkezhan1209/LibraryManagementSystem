package kz.aitu.oop.endterm.library.repositories.interfaces;

import kz.aitu.oop.endterm.library.entities.Customer;
import java.util.List;

public interface ICustomerRepo {
    boolean createCustomer(Customer customer);
    Customer getCustomer(int id);
    List<Customer> getAllCustomers();
    boolean updateCustomer(int id, String email);
}
