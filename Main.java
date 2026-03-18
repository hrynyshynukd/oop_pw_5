import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Автори
        Author author1 = new Author("Тарас Шевченко", 1814);
        Author author2 = new Author("Іван Франко", 1856);

        // Книги
        Book book1 = new Book("Кобзар", author1, 1840, "Збірка поезій");
        Book book2 = new Book("Захар Беркут", author2, 1883, "Історична повість");
        Book book3 = new Book("Іван Підкова", author1, 1840, "");

        // Бібліотека
        Library library = new Library("Моя бібліотека");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Дублікат (перевірка)
        library.addBook(book1);

        // Вивід
        System.out.println("=== Усі книги ===");
        library.listBooks();

        // Пошук по автору
        System.out.println("\n=== Книги Шевченка ===");
        List<Book> found = library.findBooksByAuthor("Тарас Шевченко");
        for (Book b : found) {
            System.out.println(b.getInfo());
        }

        // Пошук по назві
        System.out.println("\n=== Пошук 'Іван' ===");
        for (Book b : library.searchByTitle("Іван")) {
            System.out.println(b.getInfo());
        }

        // Видалення
        library.removeBook("Кобзар");

        System.out.println("\n=== Після видалення ===");
        library.listBooks();

        // Читач
        Reader reader = new Reader("Олена");

        reader.borrowBook(book2);
        reader.showBorrowedBooks();

        reader.returnBook(book2);
        reader.showBorrowedBooks();
    }
}