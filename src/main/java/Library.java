import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> collection;
    private Book book;
    private int capacity;
    private HashMap<String, Integer> booksOfGenre;

    public Library(){
        collection = new ArrayList<Book>();
        capacity = 5;
        booksOfGenre = new HashMap<String, Integer>();
    }

    public void addToCollection(Book book) {
        if (!collectionIsFull()) {
            this.collection.add(book);
        }
    }

    public int collectionCount() {
        return this.collection.size();
    }

    public boolean collectionIsFull(){
        if (this.collection.size() == this.capacity){
            return true;
        }
        return false;
    }

    public void lend(Borrower borrower) {
        if (this.collection.size() > 0) {
            Book book = this.collection.remove(0);
            borrower.addBook(book);
        }

    }

    public void genreCountSetUp(){
        for (Book book : this.collection) {
            this.booksOfGenre.put(book.getGenre)
        }
    }

    public int genreCount(String crime) {

    }
}
