import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Додавання книги (з перевіркою на дублікати)
    public void addBook(Book book) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(book.getTitle()) &&
                b.getAuthor().getName().equalsIgnoreCase(book.getAuthor().getName())) {
                System.out.println("Книга вже існує!");
                return;
            }
        }
        books.add(book);
    }

    // Вивід всіх книг
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("Бібліотека порожня");
            return;
        }

        for (Book book : books) {
            System.out.println(book.getInfo());
            System.out.println("-------------------");
        }
    }

    // Пошук по автору
    public List<Book> findBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }

        return result;
    }

    // Пошук по назві (ключові слова)
    public List<Book> searchByTitle(String keyword) {
        List<Book> result = new ArrayList<>();

        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }

        return result;
    }

    // Видалення книги
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }
}