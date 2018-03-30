package java;

import java.awt.print.Book;
import java.util.List;

public interface Library2 {
    /* Регистрация новой книги */
    default void addNewBook2(Book book) {
        System.out.println("Implement addNewBook");
    }
    /* Студент берет книгу */
    default void borrowBook2(Book book, String student) {
        System.out.println("Implement borrowBook");
    }
    /* Студент возвращает книгу */
    default void returnBook2(Book book, String student) {
        System.out.println("Implement returnBook");
    }
    /* Получить список свободных книг */
    default List<Book> findAvailableBooks2() {
        return null;
    }
}