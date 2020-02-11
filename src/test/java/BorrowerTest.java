import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {
    private Book book;
    private Library library;
    private Borrower borrower;

    @Before
    public void before(){
        library = new Library();
        book = new Book("The Big Sleep", "Raymond Chandler", "Crime");
        borrower = new Borrower();
    }

    @Test
    public void borrowerStartsWithNoBooks(){
        assertEquals(0, borrower.bookCount());
    }

    @Test
    public void canAddBooks(){
        borrower.addBook(book);
        assertEquals(1, borrower.bookCount());
    }
}
