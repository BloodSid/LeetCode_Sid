package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ArrangingCoinsSolution Tester.
 *
 * @author IronSid
 * @since 10/10/2021
 * @version 1.0
 */
public class ArrangingCoinsSolutionTest {
    ArrangingCoinsSolution.Solution solution = new ArrangingCoinsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: arrangeCoins(int n)
    */
    @Test
    public void testArrangeCoins1() throws Exception {
        int n = 5;
        int expected = 2;
        int actual = solution.arrangeCoins(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testArrangeCoins2() throws Exception {
        int n = 8;
        int expected = 3;
        int actual = solution.arrangeCoins(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testArrangeCoins3() throws Exception {
        for (int i = 1; i < 100; i++) {
            int n = i * (i + 1) / 2;
            int expected = i;
            int actual = solution.arrangeCoins(n);
            assertEquals("n:" + n, expected, actual);

            n++;
            actual = solution.arrangeCoins(n);
            assertEquals("n:" + n, expected, actual);

            n -= 2;
            expected--;
            actual = solution.arrangeCoins(n);
            assertEquals("n:" + n, expected, actual);
        }
    }
}
