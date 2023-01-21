import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author IronSid
 * @create 2021-06-12 17:03
 */
public class MainTest {

    @Test
    public void mainTest1() {
        System.out.println("测试1");
        String input =
                "0 0 8 7 1 9 2 4 5\n" +
                "9 0 5 2 3 4 0 8 6\n" +
                "0 7 4 8 0 6 1 0 3\n" +
                "7 0 3 0 9 2 0 0 0\n" +
                "5 0 0 0 0 0 0 0 0\n" +
                "8 6 1 4 0 3 5 2 9\n" +
                "4 0 0 0 2 0 0 0 8\n" +
                "0 0 0 0 0 0 0 7 0\n" +
                "1 0 7 0 6 8 0 5 0";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        System.out.println("期望输出:");
        System.out.println(
                "6 3 8 7 1 9 2 4 5\n" +
                "9 1 5 2 3 4 7 8 6\n" +
                "2 7 4 8 5 6 1 9 3\n" +
                "7 4 3 5 9 2 8 6 1\n" +
                "5 9 2 6 8 1 4 3 7\n" +
                "8 6 1 4 7 3 5 2 9\n" +
                "4 5 6 3 2 7 9 1 8\n" +
                "3 8 9 1 4 5 6 7 2\n" +
                "1 2 7 9 6 8 3 5 4");
        System.out.println("实际输出:");
        Main.main(null);
        System.out.println("_______________");
    }
    @Test
    public void mainTest2() {
        System.out.println("测试2");
        String input =
                "0 9 2 4 8 1 7 6 3\n" +
                "4 1 3 7 6 2 9 8 5\n" +
                "8 6 7 3 5 9 4 1 2\n" +
                "6 2 4 1 9 5 3 7 8\n" +
                "7 5 9 8 4 3 1 2 6\n" +
                "1 3 8 6 2 7 5 9 4\n" +
                "2 7 1 5 3 8 6 4 9\n" +
                "3 8 6 9 1 4 2 5 7\n" +
                "0 4 5 2 7 6 8 3 1\n";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        System.out.println("期望输出:");
        System.out.println(
                "5 9 2 4 8 1 7 6 3\n" +
                "4 1 3 7 6 2 9 8 5\n" +
                "8 6 7 3 5 9 4 1 2\n" +
                "6 2 4 1 9 5 3 7 8\n" +
                "7 5 9 8 4 3 1 2 6\n" +
                "1 3 8 6 2 7 5 9 4\n" +
                "2 7 1 5 3 8 6 4 9\n" +
                "3 8 6 9 1 4 2 5 7\n" +
                "9 4 5 2 7 6 8 3 1\n");
        System.out.println("实际输出:");
        Main.main(null);
        System.out.println("_______________");
    }

}