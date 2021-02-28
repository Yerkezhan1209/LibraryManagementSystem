package kz.aitu.oop.endterm.library.controllers;

import kz.aitu.oop.endterm.library.entities.Book;
import kz.aitu.oop.endterm.library.repositories.interfaces.IBookRepo;

import java.util.List;

public class BookController {
    private final IBookRepo repo;

    public BookController(IBookRepo repo) {
        this.repo = repo;
    }

    public String createBook(String subject, String title, String author, String publisher, int pages, int numberOfBooks, int numberOfAvailableBooks, int numberOfBorrowedBooks) {
        Book book = new Book(subject, title, author, publisher, pages, numberOfBooks, numberOfAvailableBooks, numberOfBorrowedBooks);
        boolean created = repo.createBook(book);
        return (created ? "Book was added!" : "Book addition was failed!");
    }

    public String getBook(int code) {
        Book book = repo.getBook(code);
        return (book == null ? "Book was not found!" : book.toString());
    }

    public List<Book> getAllBooks() {
        List<Book> books = repo.getAllBooks();
        return books;
    }

    public void changeA(int bookCode) {
        repo.changeA(bookCode);
    }

    public void changeB(int bookCode) {
        repo.changeB(bookCode);
    }

    public void changeC(int bookCode) {
        repo.changeC(bookCode);
    }

    public List<Book> getBooksBySubject(String subject) {
        List<Book> books = repo.getBooksBySubject(subject);
        return books;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> books = repo.getBooksByAuthor(author);
        return books;
    }

    public String getPopularBook() {
        Book book = repo.getPopularBook();
        return book.toString();
    }
}
