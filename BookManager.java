import java.util.ArrayList;
import java.util.List;

public class BookManager implements BookOperations {
private List<Book> books;

public BookManager() {
        this.books = new ArrayList<>();
        books.add(new Book("W pustyni i w puszczy", "H. Sienkiewicz", "1", 1911));
        books.add(new Book("Mały Książę", "A. de Saint-Exupery", "2", 1943));
        books.add(new Book("Hobbit", "J.R.R. Tolkien", "3", 1937));
        books.add(new Book("Stary człowiek i morze", "Ernest Hemingway", "4", 1952));
        books.add(new Book("Makbet", "William Shakespeare", "5", 1623));
    }
    @Override
    public void addBook(Book book) {
        books.add(book);
    }
    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }
    @Override
    public void updateBook(Book oldBook, Book newBook) {
        int index = books.indexOf(oldBook);
        if (index != -1) {
            books.set(index, newBook);
        }
    }
    @Override
    public List<Book> getBooks() {
        return books;
    }
}