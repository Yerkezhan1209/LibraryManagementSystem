package kz.aitu.oop.endterm.library.entities;

public class Book {
    private int code;
    private String subject;
    private String title;
    private String author;
    private String publisher;
    private int pages;
    private int numberOfBooks;
    private int numberOfAvailableBooks;
    private int numberOfBorrowedBooks;

    public Book() { }

    public Book(String subject, String title, String author, String publisher, int pages, int numberOfBooks, int numberOfAvailableBooks, int numberOfBorrowedBooks) {
        setSubject(subject);
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setPages(pages);
        setNumberOfBooks(numberOfBooks);
        setNumberOfAvailableBooks(numberOfAvailableBooks);
        setNumberOfBorrowedBooks(numberOfBorrowedBooks);
    }

    public Book(int code, String subject, String title, String author, String publisher, int pages, int numberOfBooks, int numberOfAvailableBooks, int numberOfBorrowedBooks) {
        setBookCode(code);
        setSubject(subject);
        setTitle(title);
        setAuthor(author);
        setPublisher(publisher);
        setPages(pages);
        setNumberOfBooks(numberOfBooks);
        setNumberOfAvailableBooks(numberOfAvailableBooks);
        setNumberOfBorrowedBooks(numberOfBorrowedBooks);
    }

    public int getBookCode() { return code; }

    public void setBookCode(int code) { this.code = code; }

    public String getSubject() { return subject; }

    public void setSubject(String subject) { this.subject = subject; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }

    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getPages() { return pages; }

    public void setPages(int pages) { this.pages = pages; }

    public int getNumberOfBooks() { return numberOfBooks; }

    public void setNumberOfBooks(int numberOfBooks) { this.numberOfBooks = numberOfBooks; }

    public int getNumberOfAvailableBooks() { return numberOfAvailableBooks; }

    public void setNumberOfAvailableBooks(int numberOfAvailableBooks) { this.numberOfAvailableBooks = numberOfAvailableBooks; }

    public int getNumberOfBorrowedBooks() { return numberOfBorrowedBooks; }

    public void setNumberOfBorrowedBooks(int numberOfBorrowedBooks) { this.numberOfBorrowedBooks = numberOfBorrowedBooks; }

    @Override
    public String toString() {
        return "| Book  ||  " + "bookCode=" + code + " | subject='" + subject + '\'' +
                " | title='" + title + '\'' + " | author='" + author + '\'' +
                " | publisher='" + publisher + '\'' + " | numberOfPages=" + pages +
                " | numberOfBooks=" + numberOfBooks + " | numberOfAvailableBooks=" + numberOfAvailableBooks +
                " | numberOfBorrowedBooks=" + numberOfBorrowedBooks + '|'; }
}
