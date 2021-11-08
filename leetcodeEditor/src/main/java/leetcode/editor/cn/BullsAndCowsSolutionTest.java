package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * BullsAndCowsSolution Tester.
 *
 * @author IronSid
 * @since 11/08/2021
 * @version 1.0
 */
public class BullsAndCowsSolutionTest {
    BullsAndCowsSolution.Solution solution = new BullsAndCowsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: getHint(String secret, String guess)
    */
    @Test
    public void testGetHint1() throws Exception {
        String secret = "1807";
        String guess = "7810";
        String expected = "1A3B";
        String actual = solution.getHint(secret, guess);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetHint2() throws Exception {
        String secret = "1123";
        String guess = "0111";
        String expected = "1A1B";
        String actual = solution.getHint(secret, guess);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetHint3() throws Exception {
        String secret = "1";
        String guess = "0";
        String expected = "0A0B";
        String actual = solution.getHint(secret, guess);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetHint4() throws Exception {
        String secret = "1";
        String guess = "1";
        String expected = "1A0B";
        String actual = solution.getHint(secret, guess);
        assertEquals(expected, actual);
    }

}
