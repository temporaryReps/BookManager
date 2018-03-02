import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookManagerTest {
    private BookManager manager;

    @Before
    public void setUp() {
        manager = BookManager.getInstance();
    }

    @After
    public void tearDown() {
        BookManager.instanceToNull();
    }

    @Test
    public void showBookListTest() {
        String expected = "1) Л.Н. Толстой, Война и мир\n" +
                "2) Ф.М. Достоевский, Преступление и наказание\n" +
                "3) Stephen King, The Green Mile\n";

        assertEquals(expected, manager.showBookList());
    }

    @Test
    public void removeBookByIdTest() {
        manager.removeBookById(1);
        String expected1 = manager.removeBookById(2);
        assertEquals(expected1, "Книга удалена");

        String expected2 = "1) Ф.М. Достоевский, Преступление и наказание\n";
        assertEquals(expected2, manager.showBookList());

        String expected3 = "Книги под таким номером не существует";
        assertEquals(expected3, manager.removeBookById(47));
        assertEquals(expected3, manager.removeBookById(0));
        assertEquals(expected3, manager.removeBookById(-34));
    }

    @Test
    public void bookListOverloadedTest(){
        String report1 =  manager.addBook("Test author1", "Test book1");
        assertEquals("Книга добавлена", report1);

        manager.addBook("Test author2", "Test book2");

        String report2 =  manager.addBook("Test author3", "Test book3");
        assertEquals("Список переполнен, книга не добавлена", report2);
    }
}