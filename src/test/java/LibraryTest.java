import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;
    private Book book;
    private Book book2;
    private Book book3;
    private Book book4;
    private Borrower borrower;
    private Borrower borrower2;

    @Before
    public void before(){
        library = new Library();
        book = new Book("The Big Sleep", "Raymond Chandler", "Crime");
        book2 = new Book("The Long Goodbye", "Raymond Chandler", "Crime");
        book3 = new Book("The BFG", "Roald Dahl", "Childrens");
        book4 = new Book("The Lord of the Rings", "JRR Tolkein", "Fantasy");
        library.addToCollection(book);
        library.addToCollection(book2);
        library.addToCollection(book3);
        library.addToCollection(book4);
        borrower = new Borrower();
        borrower2 = new Borrower();
    }

    @Test
    public void canAddBookToCollection(){
        library.addToCollection(book);
        assertEquals(5, library.collectionCount());
    }

    @Test
    public void collectionCantExceedCapacity(){
        library.addToCollection(book);
        library.addToCollection(book);
        library.addToCollection(book);
        library.addToCollection(book);
        assertEquals(5, library.collectionCount());
    }

    @Test
    public void libraryCanLendBook(){
        library.addToCollection(book);
        library.addToCollection(book);
        library.addToCollection(book);
        library.lend(borrower);
        assertEquals(4, library.collectionCount());
        assertEquals(1, borrower.bookCount());
    }

    @Test
    public void libraryCantLendIfNoBooks(){
        library.lend(borrower);
        library.lend(borrower);
        library.lend(borrower);
        library.lend(borrower);
        library.lend(borrower2);
        assertEquals(0, library.collectionCount());
        assertEquals(4, borrower.bookCount());
        assertEquals(0, borrower2.bookCount());
    }

    @Test
    public void canCountBooksByGenre(){
        library.genreCountSetUp();
        assertEquals(2, library.genreCount("Crime"));
    }

}
