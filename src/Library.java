import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(String title, int year) {
        books.add(new Book(title, year));
    }

    public class BookShelf implements Iterable<Book> {
        private int minYear;

        public BookShelf(int minYear) {
            this.minYear = minYear;
        }

        @Override
        public Iterator<Book> iterator() {
            return books.stream()
                        .filter(b -> b.getYear() >= minYear)
                        .iterator();
        }
    }

    public BookShelf getRecentBooks(int minYear) {
        return new BookShelf(minYear);
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook("Gedes", 1921);
        library.addBook("1984", 1949);
        library.addBook("Svvn zam", 2020);

        for (Book b : library.getRecentBooks(2000)) {
            System.out.println(b.getTitle() + ": " + b.getYear());
        }
    }
}

class Book {
    private String title;
    private int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
