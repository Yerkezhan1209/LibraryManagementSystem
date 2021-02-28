package kz.aitu.oop.endterm.library.repositories.interfaces;

import kz.aitu.oop.endterm.library.entities.Book;
import java.util.List;

public interface IBookRepo {
    boolean createBook(Book book);
    Book getBook(int code);
    List<Book> getAllBooks();
    void changeA(int bookCode);
    void changeB(int bookCode);
    void changeC(int bookCode);
    List<Book> getBooksBySubject(String subject);
    List<Book> getBooksByAuthor(String author);
    Book getPopularBook();
}
