public class Book {
    private String title;
    private Author author;
    private int year;
    private String annotation;

    public Book(String title, Author author, int year, String annotation) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.annotation = annotation;
    }

    public String getInfo() {
        String info = "Назва: " + title +
                ", Рік: " + year +
                ", Автор: " + author.getName();

        if (annotation != null && !annotation.isEmpty()) {
            info += "\nАнотація: " + annotation;
        }

        return info;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getAnnotation() {
        return annotation;
    }
}
