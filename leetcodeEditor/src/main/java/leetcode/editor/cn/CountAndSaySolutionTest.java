package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * CountAndSaySolution Tester.
 *
 * @author IronSid
 * @since 10/15/2021
 * @version 1.0
 */
public class CountAndSaySolutionTest {
    CountAndSaySolution.Solution solution = new CountAndSaySolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: countAndSay(int n)
    */
    @Test
    public void testCountAndSay1() throws Exception {
        int n = 1;
        String expected = "1";
        String actual = solution.countAndSay(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testCountAndSay2() throws Exception {
        int n = 4;
        String expected = "1211";
        String actual = solution.countAndSay(n);
        assertEquals(expected, actual);
    }

}
