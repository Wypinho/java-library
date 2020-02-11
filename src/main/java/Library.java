import java.util.ArrayList;

public class Library {
    private ArrayList<Book> collection;
    private Book book;
    private int capacity;

    public Library(){
        collection = new ArrayList<Book>();
        capacity = 3;
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
}
