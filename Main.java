import java.util.List;

public class Main {
    public static void main(String[] args) {

        Author author1 = new Author("Тарас Шевченко", 1814);
        Author author2 = new Author("Іван Франко", 1856);

        Book book1 = new Book("Кобзар", author1, 1840, "Збірка поезій");
        Book book2 = new Book("Захар Беркут", author2, 1883, "Історична повість");
        Book book3 = new Book("Іван Підкова", author1, 1840, "");

        Library library = new Library("Моя бібліотека");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book1);

        System.out.println("\n=== УСІ КНИГИ ===");
        for (String info : library.listBooks()) {
            System.out.println(info);
            System.out.println("------------------");
        }

        System.out.println("\n=== КНИГИ ШЕВЧЕНКА ===");
        List<Book> byAuthor = library.findBooksByAuthor("Тарас Шевченко");
        for (Book b : byAuthor) {
            System.out.println(b.getInfo());
            System.out.println("------------------");
        }

        System.out.println("\n=== ПОШУК: 'Іван' ===");
        List<Book> search = library.searchByTitle("Іван");
        for (Book b : search) {
            System.out.println(b.getInfo());
            System.out.println("------------------");
        }

        library.removeBook("Кобзар");

        System.out.println("\n=== ПІСЛЯ ВИДАЛЕННЯ ===");
        for (String info : library.listBooks()) {
            System.out.println(info);
            System.out.println("------------------");
        }

        Reader reader = new Reader("Степан");
        library.addReader(reader);

        System.out.println("\n=== ВЗЯТИ КНИГУ ===");
        library.lendBook(reader, book2);
        reader.showBorrowedBooks();

        System.out.println("\n=== ПОВЕРНУТИ КНИГУ ===");
        library.returnBook(reader, book2);
        reader.showBorrowedBooks();
    }
}
