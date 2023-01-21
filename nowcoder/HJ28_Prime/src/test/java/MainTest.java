import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author IronSid
 * @create 2021-06-05 23:38
 */
public class MainTest {

    @Test
    public void mainTest1() {
        System.out.println("测试1");
        String input =      "4\n" +
                        "2 5 6 13\n" +
                        "2\n" +
                        "3 6";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        System.out.println("期望输出:");
        System.out.println( "2\n" +
                            "0\n");
        System.out.println("实际输出:");
        Main.main(null);
        System.out.println("_______________");


    }
    @Test
    public void mainTest2() {
        System.out.println("测试2");
        String input =      "62\n" +
                            "9360 2272 15078 15571 4734 18667 10392 17796 12207 14591 8380 10126 11627 1288 24523 568 15754 8400 11280 20964 15482 28433 26109 11147 9628 12296 8500 21628 22561 5532 8830 13253 3231 15580 27278 4824 19217 16038 10091 21071 19587 10243 8786 15529 23644 13228 21503 22706 13546 2937 24488 19924 16138 13815 22460 4122 26823 2987 25011 25469 27224 16237\n" +
                            "58\n" +
                            "621 10618 19556 29534 25791 11133 5713 26642 25994 16095 6618 11447 29386 24436 22551 21467 2633 25704 29460 24325 8964 4087 10560 6478 9615 5119 1114 6773 9409 21549 15336 18995 2151 27404 6296 21066 3147 27037 6177 5650 16224 14352 8999 991 3012 16447 17799 16265 27163 24118 9766 15355 6161 3909 19451 16838 9113 10877";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);
        System.out.println("期望输出:");
        System.out.println( "26\n" +
                            "25");
        System.out.println("实际输出:");
        Main.main(null);
        System.out.println("_______________");


    }

}