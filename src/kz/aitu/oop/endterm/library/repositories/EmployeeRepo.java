package kz.aitu.oop.endterm.library.repositories;

import kz.aitu.oop.endterm.library.data.interfaces.IDB;
import kz.aitu.oop.endterm.library.entities.Employee;
import kz.aitu.oop.endterm.library.repositories.interfaces.IEmployeeRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepo implements IEmployeeRepo {
    private final IDB db;

    public EmployeeRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO employees(name,surname,gender,age,salary) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setBoolean(3, employee.getGender());
            st.setInt(4, employee.getAge());
            st.setInt(5, employee.getSalary());
            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Employee getEmployee(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,age,salary FROM employees WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getInt("age"),
                        rs.getInt("salary"));
                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,age,salary FROM employees";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getInt("age"),
                        rs.getInt("salary"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public int getTotal() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary FROM employees";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            int response = 0;
            Operation add;
            add = (x,y) -> x+y;
            while (rs.next()) {
                int a = rs.getInt("salary");
                int b = response;
                response = add.calculate(a, b);
            }
            return response;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int getMax() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary FROM employees";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            int max = 0;
            while (rs.next()) {
                if ((rs.getInt("salary"))>max) {
                    max = rs.getInt("salary"); }
            }
            return max;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int getMin() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT salary FROM employees";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            int min = 999999999;
            while (rs.next()) {
                if ((rs.getInt("salary"))<min) {
                    min = rs.getInt("salary"); }
            }
            return min;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
}

interface Operation {
    int calculate (int x, int y);
}
