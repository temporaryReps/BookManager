import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PrinterTest {
    private OutputStream outputStream;

    @Before
    public void setUp() {
        //redefine System.out
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @After
    public void tearDown() {
        outputStream = null;
    }

    @Test
    public void testPrint() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String expectedString = "Hello world!";
        Printer.print("Hello world!");

        assertEquals(expectedString, outputStream.toString());
    }

    @Test
    public void testPrintln() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        //for windows
        String expectedStringLn = "Hello world!\r\n";
        // for unix
//        String expectedStringLn = "Hello world!\n";
        Printer.println("Hello world!");

        assertEquals(expectedStringLn, outputStream.toString());
    }
}