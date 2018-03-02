public class Main {
    private BookManager manager;
    private User user;

    public static void main(String[] args) {
        new Main().start();
    }

    private Main(){
    }

    private void start() {
        init();
        communication();
    }

    private void init() {
        manager = BookManager.getInstance();
        user = new User();
    }

    /**
     * main loop for communicate with user
     */
    private void communication() {
        while (true) {
            startUserDialog();
            String answer = user.getAnswer();

            switch (answer) {
                case "2":
                    addBook();
                    break;
                case "3":
                    removeBook();
                    break;
                case "4":
                    return;
                default:
                    showBooks();
            }
        }
    }

    /**
     * start dialog with user
     */
    private void startUserDialog() {
        String startQuestion =
                "\nВведите 1 чтобы увидеть список книг\n" +
                        "Введите 2 если хотите добавить книгу\n" +
                        "Введите 3 если хотите удалить книгу\n" +
                        "Введите 4 если хотите выйти\n" +
                        "и нажмите Enter";

        Printer.println(startQuestion);
    }

    /**
     * show list of books
     */
    private void showBooks() {
        Printer.println(manager.showBookList());
    }

    /**
     * ask user to write book attributes
     */
    private void addBook() {
        String author;
        String title;

        Printer.println("Введите автора книги и нажмите Enter");
        author = user.getAnswer();
        Printer.println("Введите название книги и нажмите Enter");
        title = user.getAnswer();

        Printer.println(manager.addBook(author, title));
    }

    /**
     * ask user what book shout be removed and remove it
     */
    private void removeBook() {
        Printer.println("Введите номер книги которую хотите удалить и нажмите Enter");

        String answer = user.getAnswer();
        String report = manager.removeBookById(Integer.valueOf(answer));
        Printer.println(report);
    }
}
