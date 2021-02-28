package kz.aitu.oop.endterm.library.repositories;

import kz.aitu.oop.endterm.library.data.interfaces.IDB;
import kz.aitu.oop.endterm.library.entities.Customer;
import kz.aitu.oop.endterm.library.repositories.interfaces.ICustomerRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomerRepo implements ICustomerRepo{
    private final IDB db;

    public CustomerRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createCustomer(Customer customer) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO customers(name,surname,gender,dateOfBirth,email) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, customer.getName());
            st.setString(2, customer.getSurname());
            st.setBoolean(3, customer.getGender());
            st.setString(4, customer.getDateOfBirth());
            st.setString(5, customer.getEmail());
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
    public Customer getCustomer(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,dateOfBirth,email FROM customers WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("dateOfBirth"),
                        rs.getString("email"));
                return customer;
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
    public List<Customer> getAllCustomers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender,dateOfBirth,email FROM customers";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Customer> customers = new ArrayList<>();
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"),
                        rs.getString("dateOfBirth"),
                        rs.getString("email"));
                customers.add(customer);
            }
            return customers;
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
    public boolean updateCustomer(int id, String email) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE customers SET email=? WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
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
}
