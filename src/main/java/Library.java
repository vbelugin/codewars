import java.util.List;

public interface Library {
    /* Регистрация новой книги */
    default void addNewBook(Book book) {
        System.out.println("Implement addNewBook");
    }
    /* Студент берет книгу */
    default void borrowBook(Book book, String student) {
        System.out.println("Implement borrowBook");
    }
    /* Студент возвращает книгу */
    default void returnBook(Book book, String student) {
        System.out.println("Implement returnBook");
    }
    /* Получить список свободных книг */
    default List<Book> findAvailableBooks() {
        return null;
    }
}