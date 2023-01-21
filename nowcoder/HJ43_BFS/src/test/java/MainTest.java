import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author IronSid
 * @create 2021-06-07 2:22
 */
public class MainTest {

    @Test
    public void mainTest1() {
        System.out.println("测试1");
        String input =
                "5 5\n" +
                "0 1 0 0 0\n" +
                "0 1 1 1 0\n" +
                "0 0 0 0 0\n" +
                "0 1 1 1 0\n" +
                "0 0 0 1 0\n";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        System.out.println("期望输出:");
        System.out.println(
                "(0,0)\n" +
                "(1,0)\n" +
                "(2,0)\n" +
                "(2,1)\n" +
                "(2,2)\n" +
                "(2,3)\n" +
                "(2,4)\n" +
                "(3,4)\n" +
                "(4,4)\n");
        System.out.println("实际输出:");
        Main.main(null);
        System.out.println("_______________");


    }
    @Test
    public void mainTest2() {
        System.out.println("测试2");
        String input =
                "6 5\n" +
                "0 0 0 1 1 \n" +
                "1 1 0 1 1 \n" +
                "1 1 0 0 1 \n" +
                "1 1 1 0 1 \n" +
                "1 1 1 0 1 \n" +
                "1 1 1 0 0 \n" +
                "3 3\n" +
                "0 1 1 \n" +
                "0 0 0 \n" +
                "1 1 0";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        System.out.println("期望输出:");
        System.out.println(
                "(0,0)\n" +
                "(0,1)\n" +
                "(0,2)\n" +
                "(1,2)\n" +
                "(2,2)\n" +
                "(2,3)\n" +
                "(3,3)\n" +
                "(4,3)\n" +
                "(5,3)\n" +
                "(5,4)\n" +
                "(0,0)\n" +
                "(1,0)\n" +
                "(1,1)\n" +
                "(1,2)\n" +
                "(2,2)");
        System.out.println("实际输出:");
        Main.main(null);
        System.out.println("_______________");


    }
}