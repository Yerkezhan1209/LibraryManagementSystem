package kz.aitu.oop.endterm.library.repositories.interfaces;

import kz.aitu.oop.endterm.library.entities.Employee;
import java.util.List;

public interface IEmployeeRepo {
    boolean createEmployee(Employee employee);
    Employee getEmployee(int id);
    List<Employee> getAllEmployees();
    int getTotal();
    int getMax();
    int getMin();
}
