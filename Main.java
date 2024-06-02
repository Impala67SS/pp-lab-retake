import java.util.List;
import java.util.Scanner;

public class Main {
private static BookManager bookManager = new BookManager();
    private static Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
    while (true) {
    System.out.println("Menu:");
    System.out.println("[1] Add book");
    System.out.println("[2] Remove book");
    System.out.println("[3] Update book");
    System.out.println("[4] List books");
    System.out.println("[5] Exit");
    System.out.print("Choose an option: ");

    int choice = scanner.nextInt();
    scanner.nextLine();  

switch (choice) {
    case 1:
    addBook();
    break;
    case 2:
        removeBook();
        break;
        case 3:
        updateBook();
        break;
        case 4:
        listBooks();
        break;
        case 5:}
        }
    }

private static void addBook() {
    System.out.print("Wprowadź tyyuł: ");
    String title = scanner.nextLine();
    System.out.print("Wprowadź autora: ");
    String author = scanner.nextLine();
    System.out.print("Nadaj ISBN: ");
    String isbn = scanner.nextLine();
    System.out.print("Podaj rok: ");
    int year = scanner.nextInt();
    scanner.nextLine(); 



Book newBook = new Book(title, author, isbn, year);
bookManager.addBook(newBook);
System.out.println("Dodano.");
    }
private static void removeBook() {
    System.out.print("Wpisz ISBN aby usunąć: ");
    String isbn = scanner.nextLine();
    Book bookToRemove = findBookByIsbn(isbn);
    if (bookToRemove != null) {
        bookManager.removeBook(bookToRemove);
        System.out.println("Usunięto.");
    } else {
    System.out.println("Nie znaleziono.");
        }
    }
    private static void updateBook() {
        System.out.print("Wpisz ISBN książki aby edytować: ");
        String isbn = scanner.nextLine();
        Book oldBook = findBookByIsbn(isbn);
        if (oldBook != null) {
            System.out.print("Wprowadź tytil: ");
            String newTitle = scanner.nextLine();
            System.out.print("Wprowadz autora: ");
            String newAuthor = scanner.nextLine();
            System.out.print("Wprowadź rok: ");
            int newYear = scanner.nextInt();
            scanner.nextLine();  

            Book newBook = new Book(newTitle, newAuthor, oldBook.getIsbn(), newYear);
            bookManager.updateBook(oldBook, newBook);
            System.out.println("Zaktualizowano.");
        } else {
            System.out.println("Nie znaleziono.");
        }
    }
private static void listBooks() {
        List<Book> books = bookManager.getBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
private static Book findBookByIsbn(String isbn) {
    for (Book book : bookManager.getBooks()) {
        if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}