package kz.aitu.oop.endterm.library.repositories;

import kz.aitu.oop.endterm.library.data.interfaces.IDB;
import kz.aitu.oop.endterm.library.entities.Book;
import kz.aitu.oop.endterm.library.repositories.interfaces.IBookRepo;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookRepo implements IBookRepo{
    private final IDB db;

    public BookRepo(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createBook(Book book) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO books(subject,title,author,publisher,pages,numberOfBooks,numberOfAvailableBooks,numberOfBorrowedBooks) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, book.getSubject());
            st.setString(2, book.getTitle());
            st.setString(3, book.getAuthor());
            st.setString(4, book.getPublisher());
            st.setInt(5, book.getPages());
            st.setInt(6, book.getNumberOfBooks());
            st.setInt(7, book.getNumberOfAvailableBooks());
            st.setInt(8, book.getNumberOfBorrowedBooks());
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
    public Book getBook(int code) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,subject,title,author,publisher,pages,numberOfBooks,numberOfAvailableBooks,numberOfBorrowedBooks FROM books WHERE code=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, code);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("code"),
                        rs.getString("subject"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("pages"),
                        rs.getInt("numberOfBooks"),
                        rs.getInt("numberOfAvailableBooks"),
                        rs.getInt("numberOfBorrowedBooks"));
                return book;
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
    public List<Book> getAllBooks() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,subject,title,author,publisher,pages,numberOfBooks,numberOfAvailableBooks,numberOfBorrowedBooks FROM books";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book(rs.getInt("code"),
                        rs.getString("subject"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("pages"),
                        rs.getInt("numberOfBooks"),
                        rs.getInt("numberOfAvailableBooks"),
                        rs.getInt("numberOfBorrowedBooks"));
                books.add(book);
            }
            return books;
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
    public void changeA(int code) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE books SET numberofavailablebooks=? WHERE code=?";
            int a = 0;
            String sql2 = "SELECT numberofavailablebooks FROM books WHERE code=?";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setInt(1, code);
            ResultSet rs = st2.executeQuery();
            if (rs.next()) {
                a = rs.getInt("numberofavailablebooks") - 1; }
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, a);
            pstmt.setInt(2, code);
            pstmt.executeUpdate();
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
    }

    @Override
    public void changeB(int code) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE books SET numberofborrowedbooks=? WHERE code=?";
            int a = 0;
            String sql2 = "SELECT numberofborrowedBooks FROM books WHERE code=?";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setInt(1, code);
            ResultSet rs = st2.executeQuery();
            if (rs.next()) {
                a = rs.getInt("numberofborrowedBooks") + 1; }
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, a);
            pstmt.setInt(2, code);
            pstmt.executeUpdate();
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
    }

    @Override
    public void changeC(int code) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE books SET numberofavailablebooks=? WHERE code=?";
            int a = 0;
            String sql2 = "SELECT numberofavailablebooks FROM books WHERE code=?";
            PreparedStatement st2 = con.prepareStatement(sql2);
            st2.setInt(1, code);
            ResultSet rs = st2.executeQuery();
            if (rs.next()) {
                a = rs.getInt("numberofavailablebooks") + 1; }
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, a);
            pstmt.setInt(2, code);
            pstmt.executeUpdate();
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
    }

    @Override
    public List<Book> getBooksBySubject(String subject) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,subject,title,author,publisher,pages,numberOfBooks,numberOfAvailableBooks,numberOfBorrowedBooks FROM books";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                if (rs.getString("subject").equalsIgnoreCase(subject)) {
                    Book book = new Book(rs.getInt("code"),
                            rs.getString("subject"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getInt("pages"),
                            rs.getInt("numberOfBooks"),
                            rs.getInt("numberOfAvailableBooks"),
                            rs.getInt("numberOfBorrowedBooks"));
                    books.add(book);
                }
            }
            return books;
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
    public List<Book> getBooksByAuthor(String author) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT code,subject,title,author,publisher,pages,numberOfBooks,numberOfAvailableBooks,numberOfBorrowedBooks FROM books";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            List<Book> books = new ArrayList<>();
            while (rs.next()) {
                if (rs.getString("author").equalsIgnoreCase(author)) {
                    Book book = new Book(rs.getInt("code"),
                            rs.getString("subject"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getInt("pages"),
                            rs.getInt("numberOfBooks"),
                            rs.getInt("numberOfAvailableBooks"),
                            rs.getInt("numberOfBorrowedBooks"));
                    books.add(book);
                }
            }
            return books;
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
    public Book getPopularBook() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql2 = "SELECT numberofborrowedbooks FROM books";
            Statement st2 = con.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            int max = 0;
            while (rs2.next()) {
                if ((rs2.getInt("numberofborrowedbooks"))>max) {
                    max = rs2.getInt("numberofborrowedbooks"); }
            }
            String sql = "SELECT code,subject,title,author,publisher,pages,numberOfBooks,numberOfAvailableBooks,numberOfBorrowedBooks FROM books WHERE numberofborrowedbooks=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, max);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book book = new Book(rs.getInt("code"),
                        rs.getString("subject"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("pages"),
                        rs.getInt("numberOfBooks"),
                        rs.getInt("numberOfAvailableBooks"),
                        rs.getInt("numberOfBorrowedBooks"));
                return book;
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
}
