package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ConvertANumberToHexadecimalSolution Tester.
 *
 * @author IronSid
 * @since 10/02/2021
 * @version 1.0
 */
public class ConvertANumberToHexadecimalSolutionTest {
    ConvertANumberToHexadecimalSolution.Solution solution = new ConvertANumberToHexadecimalSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: toHex(int num)
    */
    @Test
    public void testToHex1() throws Exception {
        int num = 26;
        String expected = "1a";
        String actual = solution.toHex(num);
        assertEquals(expected, actual);
    }

    /**
    * Method: toHex(int num)
    */
    @Test
    public void testToHex2() throws Exception {
        int num = -1;
        String expected = "ffffffff";
        String actual = solution.toHex(num);
        assertEquals(expected, actual);
    }


}
