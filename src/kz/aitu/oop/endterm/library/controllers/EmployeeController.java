package kz.aitu.oop.endterm.library.controllers;

import kz.aitu.oop.endterm.library.entities.Employee;
import kz.aitu.oop.endterm.library.repositories.interfaces.IEmployeeRepo;

import java.sql.Date;
import java.util.List;

public class EmployeeController {
    private final IEmployeeRepo repo;

    public EmployeeController(IEmployeeRepo repo) {
        this.repo = repo;
    }

    public String createEmployee(String name, String surname, String gender, int age, int salary) {
        boolean male = (gender.toLowerCase().equals("male"));
        Employee employee = new Employee(name, surname, male, age, salary);
        boolean created = repo.createEmployee(employee);
        return (created ? "Employee was added!" : "Employee addition was failed!");
    }

    public String getEmployee(int id) {
        Employee employee = repo.getEmployee(id);
        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();
        return employees;
    }

    public int getTotal() {
        int response = repo.getTotal();
        return response;
    }

    public int getMax() {
        int max = repo.getMax();
        return max;
    }

    public int getMin() {
        int min = repo.getMin();
        return min;
    }
}
