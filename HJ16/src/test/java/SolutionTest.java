import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-05-26 0:35
 */
public class SolutionTest {


    @Test
    public void test1() {
        System.out.println("测试1");
        String s =
                "4500 12\n" +
                "100 3 0\n" +
                "400 5 0\n" +
                "300 5 0\n" +
                "1400 2 0\n" +
                "500 2 0\n" +
                "800 2 4\n" +
                "1400 5 4\n" +
                "300 5 0\n" +
                "1400 3 8\n" +
                "500 2 0\n" +
                "1800 4 0\n" +
                "440 5 10\n";
        InputStream is = new ByteArrayInputStream(s.getBytes());
        System.setIn(is);
        System.out.println("期望输出:");
        System.out.println("16700");
        System.out.println("实际输出:");
        Solution.main(null);
        System.out.println("_______________");

    }
    @Test
    public void test2() {
        System.out.println("测试2");
        String s =
                "1000 5\n" +
                "800 2 0\n" +
                "400 5 1\n" +
                "300 5 1\n" +
                "400 3 0\n" +
                "500 2 0\n";
        InputStream is = new ByteArrayInputStream(s.getBytes());
        System.setIn(is);
        System.out.println("期望输出:");
        System.out.println("2200");
        System.out.println("实际输出:");
        Solution.main(null);
        System.out.println("_______________");

    }
}