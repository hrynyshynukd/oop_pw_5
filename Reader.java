import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    private Library library;
    private List<Book> borrowedBooks;

    public Reader(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void registerToLibrary(Library library) {
        this.library = library;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    protected void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    protected void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    public Library getLibrary() {
        return library;
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " не має взятих книг.");
            return;
        }

        System.out.println("Книги читача " + name + ":");
        for (Book book : borrowedBooks) {
            System.out.println(book.getInfo());
        }
    }
}
