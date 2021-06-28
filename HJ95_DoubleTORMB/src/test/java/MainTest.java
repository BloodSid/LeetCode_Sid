import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-06-29 3:54
 */
public class MainTest {
    static Main main;

    @Test
    public void mainTest1() {
        String input = "30105000.00";
        System.out.println(input);
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Main.main(null);

    }
    @Test
    public void mainTest2() {
        String input = "30150.00";
        System.out.println(input);
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        Main.main(null);

    }
}