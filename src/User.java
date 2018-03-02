import java.io.InputStream;
import java.util.Scanner;

public class User {
    private Scanner scanner;

    public User(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public User() {
        this(System.in);
    }

    public String getAnswer() {
        String result = null;
        if (scanner.hasNext()) {
            result = scanner.nextLine();
        }
        return result;
    }
}
