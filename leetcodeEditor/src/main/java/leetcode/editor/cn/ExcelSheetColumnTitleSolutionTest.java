package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ExcelSheetColumnTitleSolution Tester.
 *
 * @author IronSid
 * @since 10/30/2021
 * @version 1.0
 */
public class ExcelSheetColumnTitleSolutionTest {
    ExcelSheetColumnTitleSolution.Solution solution = new ExcelSheetColumnTitleSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: convertToTitle(int columnNumber)
    */
    @Test
    public void testConvertToTitle1() throws Exception {
        int columnNumber = 1;
        String expected = "A";
        String actual = solution.convertToTitle(columnNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToTitle2() throws Exception {
        int columnNumber = 28;
        String expected = "AB";
        String actual = solution.convertToTitle(columnNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToTitle3() throws Exception {
        int columnNumber = 701;
        String expected = "ZY";
        String actual = solution.convertToTitle(columnNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToTitle4() throws Exception {
        int columnNumber = 2147483647;
        String expected = "FXSHRXW";
        String actual = solution.convertToTitle(columnNumber);
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToTitle5() throws Exception {
        int columnNumber = 702;
        String expected = "ZZ";
        String actual = solution.convertToTitle(columnNumber);
        assertEquals(expected, actual);
    }

}
