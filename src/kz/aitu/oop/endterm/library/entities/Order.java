package kz.aitu.oop.endterm.library.entities;

public class Order {
    private int id;
    private int customerID;
    private int bookCode;
    private String date;
    private String returnDate;
    private boolean returnStatus;

    public Order() { }

    public Order(int customerID, int bookCode, String date, String returnDate, boolean returnStatus) {
        setCustomerID(customerID);
        setBookCode(bookCode);
        setDate(date);
        setReturnDate(returnDate);
        setReturnStatus(returnStatus);
    }

    public Order(int id, int customerID, int bookCode, String date, String returnDate, boolean returnStatus) {
        setID(id);
        setCustomerID(customerID);
        setBookCode(bookCode);
        setDate(date);
        setReturnDate(returnDate);
        setReturnStatus(returnStatus);
    }

    public int getID() { return id; }

    public void setID(int id) { this.id = id; }

    public int getCustomerID() { return customerID; }

    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public int getBookCode() { return bookCode; }

    public void setBookCode(int bookCode) { this.bookCode = bookCode; }

    public String getDate() { return date; }

    public void setDate(String date) { this.date = date; }

    public String getReturnDate() { return returnDate; }

    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }

    public boolean isReturnStatus() { return returnStatus; }

    public void setReturnStatus(boolean returnStatus) { this.returnStatus = returnStatus; }

    @Override
    public String toString() {
        return "| Order  ||  " + "id=" + id + " | customerID=" + customerID +
                " | bookCode=" + bookCode + " | orderDate='" + date + '\'' +
                " | returnDate='" + returnDate + '\'' +
                " | returnStatus=" + (returnStatus ? "Returned" : "Not returned") + '|'; }
}
