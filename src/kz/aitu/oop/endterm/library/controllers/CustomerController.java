package kz.aitu.oop.endterm.library.controllers;

import kz.aitu.oop.endterm.library.entities.Customer;
import kz.aitu.oop.endterm.library.repositories.interfaces.ICustomerRepo;

import java.sql.Date;
import java.util.List;

public class CustomerController {
    private final ICustomerRepo repo;

    public CustomerController(ICustomerRepo repo) {
        this.repo = repo;
    }

    public String createCustomer(String name, String surname, String gender, String dateOfBirth, String email) {
        boolean male = (gender.toLowerCase().equals("male"));
        Customer customer = new Customer(name, surname, male, dateOfBirth, email);
        boolean created = repo.createCustomer(customer);
        return (created ? "Customer was added!" : "Customer addition was failed!");
    }

    public String getCustomer(int id) {
        Customer customer = repo.getCustomer(id);
        return (customer == null ? "Customer was not found!" : customer.toString());
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = repo.getAllCustomers();
        return customers;
    }

    public String updateCustomer(int id, String email) {
        boolean updated = repo.updateCustomer(id, email);
        return (updated ? "Customer email was updated!" : "Email update was failed!");
    }
}
