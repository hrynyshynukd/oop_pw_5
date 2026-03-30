import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    private List<Book> books;
    private List<Reader> readers;

    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

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

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<String> listBooks() {
        List<String> result = new ArrayList<>();
        for (Book book : books) {
            result.add(book.getInfo());
        }
        return result;
    }

    public List<Book> findBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooksByYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getYear() == year) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByKeyword(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                (book.getAnnotation() != null &&
                 book.getAnnotation().toLowerCase().contains(keyword.toLowerCase()))) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    public void addReader(Reader reader) {
        readers.add(reader);
        reader.registerToLibrary(this);
    }

    public void lendBook(Reader reader, Book book) {
        if (!readers.contains(reader)) {
            System.out.println("Читач не зареєстрований у бібліотеці!");
            return;
        }

        if (!books.contains(book)) {
            System.out.println("Книги немає в бібліотеці!");
            return;
        }

        reader.borrowBook(book);
        System.out.println(reader.getName() + " отримав книгу: " + book.getTitle());
    }

    public void returnBook(Reader reader, Book book) {
        reader.returnBook(book);
        System.out.println(reader.getName() + " повернув книгу: " + book.getTitle());
    }

    public String getName() {
    return name;
    }
    
}
