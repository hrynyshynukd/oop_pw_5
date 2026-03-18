import java.util.ArrayList;
import java.util.List;

public class Reader {
    private String name;
    private List<Book> borrowedBooks;

    public Reader(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " взяв книгу: " + book.getTitle());
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(name + " повернув книгу: " + book.getTitle());
    }

    public void showBorrowedBooks() {
        System.out.println("Книги читача " + name + ":");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
}