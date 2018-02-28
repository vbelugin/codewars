import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ILibrary implements Library {
    private HashMap<Book, String> bookMap;

    public ILibrary() {
        bookMap = new HashMap<>();
    }

    @Override
    public void addNewBook(Book book) {
        bookMap.put(book, "");
    }

    @Override
    public void borrowBook(Book book, String student) {
        if (student != null) {
            for (Map.Entry<Book, String> bookEntry : bookMap.entrySet()) {
                if (bookEntry.getKey().equals(book) && bookEntry.getValue().equals("")) {
                    bookEntry.setValue(student);
                }
            }
        } else {
            System.out.println("Student is null");
        }
    }

    @Override
    public void returnBook(Book book, String student) {
        for (Map.Entry<Book, String> bookEntry : bookMap.entrySet()) {
            if (bookEntry.getKey().equals(book) && bookEntry.getValue().equals(student)) {
                bookEntry.setValue("");
            }
        }
    }

    public HashMap<Book, String> getBooks() {
        return bookMap;
    }

    @Override
    public List<Book> findAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Map.Entry<Book, String> book : bookMap.entrySet()) {
            if (book.getValue().equals("")) {
                availableBooks.add(book.getKey());
            }
        }
        return availableBooks;
    }
}
