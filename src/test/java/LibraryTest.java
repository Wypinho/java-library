import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;
    private Book book;
    private Borrower borrower;

    @Before
    public void before(){
        library = new Library();
        book = new Book("The Big Sleep", "Raymond Chandler", "Crime");
        borrower = new Borrower();
    }

    @Test
    public void canAddBookToCollection(){
        library.addToCollection(book);
        assertEquals(1, library.collectionCount());
    }

    @Test
    public void collectionCantExceedCapacity(){
        library.addToCollection(book);
        library.addToCollection(book);
        library.addToCollection(book);
        library.addToCollection(book);
        assertEquals(3, library.collectionCount());
    }

    @Test
    public void libraryCanLendBook(){
        library.addToCollection(book);
        library.addToCollection(book);
        library.addToCollection(book);
        library.lend(borrower);
        assertEquals(2, library.collectionCount());
        assertEquals(1, borrower.bookCount());
    }

    @Test
    public void libraryCantLendIfNoBooks(){
        library.lend(borrower);
        assertEquals(0, library.collectionCount());
        assertEquals(0, borrower.bookCount());
    }

}
