import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private static final int LIST_SIZE = 5; // max count of books

    private static BookManager instance;
    private List<Book> books;

    private BookManager() {
    }

    public static BookManager getInstance() {
        if (instance == null) {
            instance = new BookManager();
            instance.initBookList();
        }

        return instance;
    }

    //TODO mush be removed after tests
    public static void instanceToNull() {
        instance = null;
    }

    /**
     * add book if list isn't overloaded
     *
     * @param author of book
     * @param title  of book
     */
    public String addBook(String author, String title) {
        if (books.size() >= LIST_SIZE) {
            return "Список переполнен, книга не добавлена";
        }

        books.add(new Book(author, title));
        return "Книга добавлена";
    }

    /**
     * @return books' list as string
     */
    public String showBookList() {
        int bookNumber = 1;
        StringBuilder builder = new StringBuilder();

        for (Book book : books) {
            String attributes = bookNumber + ") " + book.getAuthor() + ", " + book.getTitle();
            builder.append(attributes);
            builder.append("\n");

            bookNumber++;
        }

        return builder.toString();
    }

    /**
     * remove book from list by id
     *
     * @param id book which shout be removed
     * @return report
     */
    public String removeBookById(int id) {
        if (id > LIST_SIZE || id < 1) {
            return "Книги под таким номером не существует";
        }

        books.remove(id - 1);
        return "Книга удалена";
    }

    /**
     * init start list of books
     */
    private void initBookList() {
        books = new ArrayList<>(LIST_SIZE);
        books.add(new Book("Л.Н. Толстой", "Война и мир"));
        books.add(new Book("Ф.М. Достоевский", "Преступление и наказание"));
        books.add(new Book("Stephen King", "The Green Mile"));
    }
}