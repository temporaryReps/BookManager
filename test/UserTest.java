import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import static org.junit.Assert.*;

public class UserTest {

    /**
     * Getting answer from user
     */
    @Test
    public void getAnswerTest() throws UnsupportedEncodingException {
        String findBook = "1";
        InputStream inputStream = new ByteArrayInputStream(findBook.getBytes(StandardCharsets.UTF_8.name()));
        User user = new User(inputStream);
        String answer = user.getAnswer();

        assertEquals(findBook, answer);
    }
}