import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;
    private Book book;

    @Before
    public void before(){
        library = new Library();
        book = new Book("The Big Sleep", "Raymond Chandler", "Crime");
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

}
