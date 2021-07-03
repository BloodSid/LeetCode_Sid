import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-07-04 2:16
 */
public class MainTest {
    Main main = new Main();

    @Test
    public void mainTest1() {
        String input = "r 22-18-21-21-7-20 3-23-10-6;c;q0;p 1;b A6;c;b A5;b A1;c;q1;p 5;\n" +
                "r 28-12-11-1-16-10 19-30-8-11;b A1;p 1;\n";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        System.out.println("期望输出:");
        System.out.println("S001:Initialization is successful\n" +
                "E009:Work failure\n" +
                "E010:Parameter error\n" +
                "S002:Pay success,balance=1\n" +
                "E008:Lack of balance\n" +
                "1 yuan coin number=1\n" +
                "2 yuan coin number=0\n" +
                "5 yuan coin number=0\n" +
                "10 yuan coin number=0\n" +
                "E008:Lack of balance\n" +
                "E008:Lack of balance\n" +
                "E009:Work failure\n" +
                "E010:Parameter error\n" +
                "S002:Pay success,balance=5\n" +
                "S001:Initialization is successful\n" +
                "E008:Lack of balance\n" +
                "S002:Pay success,balance=1");
        System.out.println("实际输出:");
        Main.main(null);
    }
}