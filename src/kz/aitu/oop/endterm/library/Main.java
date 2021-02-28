package kz.aitu.oop.endterm.library;

import kz.aitu.oop.endterm.library.data.PostgresDB;
import kz.aitu.oop.endterm.library.data.interfaces.IDB;
import kz.aitu.oop.endterm.library.repositories.BookRepo;
import kz.aitu.oop.endterm.library.repositories.CustomerRepo;
import kz.aitu.oop.endterm.library.repositories.OrderRepo;
import kz.aitu.oop.endterm.library.repositories.interfaces.IBookRepo;
import kz.aitu.oop.endterm.library.repositories.interfaces.ICustomerRepo;
import kz.aitu.oop.endterm.library.repositories.interfaces.IOrderRepo;

public class Main {
    public static void main(String[] args) {
//        String connectionUrl = "jdbc:postgresql://localhost:5432/library";
//        Connection con = null;
//        ResultSet rs = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.postgresql.Driver");
//            con = DriverManager.getConnection(connectionUrl, "postgres", "dwrlwine20022E");
//            stmt = con.createStatement();
//            rs = stmt.executeQuery("select * mistake from users");
//            while (rs.next())
//                System.out.println(rs.getInt("id") + "  "
//                        + rs.getString("name") + "  " + rs.getString("surname"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                rs.close();
//                stmt.close();
//                con.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

        IDB db = new PostgresDB();
        IBookRepo repo1 = new BookRepo(db);
        ICustomerRepo repo2 = new CustomerRepo(db);
        IOrderRepo repo3 = new OrderRepo(db);
        MyApplication app = new MyApplication(repo1, repo2, repo3);
        app.start();
    }
}
