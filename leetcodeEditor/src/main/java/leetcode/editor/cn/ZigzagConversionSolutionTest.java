package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ZigzagConversionSolution Tester.
 *
 * @author IronSid
 * @since 10/06/2021
 * @version 1.0
 */
public class ZigzagConversionSolutionTest {
    ZigzagConversionSolution.Solution solution = new ZigzagConversionSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: convert(String s, int numRows)
    */
    @Test
    public void testConvert1() throws Exception {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";
        String actual = solution.convert(s, numRows);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvert2() throws Exception {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI";
        String actual = solution.convert(s, numRows);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvert3() throws Exception {
        String s = "A";
        int numRows = 1;
        String expected = "A";
        String actual = solution.convert(s, numRows);
        assertEquals(expected, actual);
    }


}
