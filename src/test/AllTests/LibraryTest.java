package AllTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import firstKatas.Book;
import firstKatas.ILibrary;

public class LibraryTest {
    private ILibrary library;

    @Before
    public void setBefore() {
        library = new ILibrary();
    }

    @Test
    public void borrowNullBook() {
        Book book1 = new Book();
        library.addNewBook(book1);
        library.borrowBook(book1, null);

        Assert.assertTrue(library.getBooks().get(book1).equals(""));
    }

    @Test
    public void borrowBookTest() {
        Book book1 = new Book();
        library.addNewBook(book1);
        library.borrowBook(book1, "John");

        Assert.assertTrue(library.getBooks().get(book1).equals("John"));
    }

    @Test
    public void addBookTest() {
        Book book1 = new Book();
        library.addNewBook(book1);

        Assert.assertTrue(library.getBooks().containsKey(book1));
        Assert.assertTrue(library.getBooks().get(book1).equals(""));
    }
}
