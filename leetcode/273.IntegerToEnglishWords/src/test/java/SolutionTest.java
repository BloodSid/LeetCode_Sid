import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author IronSid
 * @create 2021-06-26 23:40
 */
public class SolutionTest {

    @Test
    public void numberToWordsTest1() {
        String expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";
        int input = 1234567891;
        assertEquals(expected,new Solution().numberToWords(input));
    }
    @Test
    public void numberToWordsTest2() {
        String expected = "Zero";
        int input = 0;
        assertEquals(expected,new Solution().numberToWords(input));
    }
    @Test
    public void numberToWordsTest3() {
        String expected = "One Hundred Million";
        int input = 100000000;
        assertEquals(expected,new Solution().numberToWords(input));
    }
    @Test
    public void numberToWordsTest4() {
        String expected = "Nineteen";
        int input = 19;
        assertEquals(expected,new Solution().numberToWords(input));
    }

}