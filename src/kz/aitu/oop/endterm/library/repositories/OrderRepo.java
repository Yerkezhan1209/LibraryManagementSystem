package kz.aitu.oop.endterm.library.repositories;

import kz.aitu.oop.endterm.library.data.interfaces.IDB;
import kz.aitu.oop.endterm.library.entities.Order;
import kz.aitu.oop.endterm.library.repositories.interfaces.IOrderRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OrderRepo implements IOrderRepo{
    private final IDB db;

    public OrderRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createOrder(Order order) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO orders(customerID, bookCode, date, returnDate, returnStatus) VALUES (?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, order.getCustomerID());
            st.setInt(2, order.getBookCode());
            st.setString(3, order.getDate());
            st.setString(4, order.getReturnDate());
            st.setBoolean(5,order.isReturnStatus());
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
    public Order getOrder(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,customerID, bookCode, date, returnDate, returnStatus FROM orders WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Order order = new Order(rs.getInt("id"),
                        rs.getInt("customerID"),
                        rs.getInt("bookCode"),
                        rs.getString("date"),
                        rs.getString("returnDate"),
                        rs.getBoolean("returnStatus"));
                return order;
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
    public List<Order> getAllOrders() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,customerID,bookCode,date,returnDate,returnStatus FROM orders";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Order> orders = new ArrayList<>();
            while (rs.next()) {
                Order order = new Order(rs.getInt("id"),
                        rs.getInt("customerID"),
                        rs.getInt("bookCode"),
                        rs.getString("date"),
                        rs.getString("returnDate"),
                        rs.getBoolean("returnStatus"));
                orders.add(order);
            }
            return orders;
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
    public boolean updateOrderDate(int id, String returndate) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE orders SET returndate=? WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, returndate);
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

    @Override
    public boolean updateOrderStatus(int id, boolean returned) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE orders SET returnstatus=? WHERE id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setBoolean(1, returned);
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

    @Override
    public int getBookCode(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT bookCode FROM orders WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            int response = 0;
            if (rs.next()) {
                response = rs.getInt("bookCode"); }
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
}
