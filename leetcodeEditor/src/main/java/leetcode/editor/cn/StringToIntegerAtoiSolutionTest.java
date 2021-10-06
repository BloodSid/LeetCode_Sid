package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * StringToIntegerAtoiSolution Tester.
 *
 * @author IronSid
 * @since 10/06/2021
 * @version 1.0
 */
public class StringToIntegerAtoiSolutionTest {
    StringToIntegerAtoiSolution.Solution solution = new StringToIntegerAtoiSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: myAtoi(String s)
    */
    @Test
    public void testMyAtoi1() throws Exception {
        String s = "42";
        int expected = 42;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testMyAtoi2() throws Exception {
        String s = "   -42";
        int expected = -42;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testMyAtoi3() throws Exception {
        String s = "4193 with words";
        int expected = 4193;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testMyAtoi4() throws Exception {
        String s = "words and 987";
        int expected = 0;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }

    @Test
    public void testMyAtoi5() throws Exception {
        String s = "-91283472332";
        int expected = -2147483648;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }
    @Test
    public void testMyAtoi6() throws Exception {
        String s = "-2147483648";
        int expected = -2147483648;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }
    @Test
    public void testMyAtoi7() throws Exception {
        String s = "-2147483647";
        int expected = -2147483647;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }
    @Test
    public void testMyAtoi8() throws Exception {
        String s = "-2147483649";
        int expected = -2147483648;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }
    @Test
    public void testMyAtoi9() throws Exception {
        String s = "2147483648";
        int expected = 2147483647;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }
    @Test
    public void testMyAtoi10() throws Exception {
        String s = "2147483647";
        int expected = 2147483647;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }
    @Test
    public void testMyAtoi11() throws Exception {
        String s = "2147483646";
        int expected = 2147483646;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }
    @Test
    public void testMyAtoi12() throws Exception {
        String s = "     ";
        int expected = 0;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }
    @Test
    public void testMyAtoi13() throws Exception {
        String s = "+1";
        int expected = 1;
        int actual = solution.myAtoi(s);
        assertEquals(expected, actual);
    }

}
