package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * FractionToRecurringDecimalSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/03/2021
 */
public class FractionToRecurringDecimalSolutionTest {
    FractionToRecurringDecimalSolution.Solution solution = new FractionToRecurringDecimalSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: fractionToDecimal(int numerator, int denominator)
     */
    @Test
    public void testFractionToDecimal1() throws Exception {
        int numerator = 1;
        int denominator = 2;
        String expected = "0.5";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal2() throws Exception {
        int numerator = 2;
        int denominator = 1;
        String expected = "2";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal3() throws Exception {
        int numerator = 2;
        int denominator = 3;
        String expected = "0.(6)";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal4() throws Exception {
        int numerator = 4;
        int denominator = 333;
        String expected = "0.(012)";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal5() throws Exception {
        int numerator = 1;
        int denominator = 5;
        String expected = "0.2";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal6() throws Exception {
        int numerator = 1;
        int denominator = 8;
        String expected = "0.125";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal7() throws Exception {
        int numerator = 1;
        int denominator = 30;
        String expected = "0.0(3)";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal8() throws Exception {
        int numerator = -50;
        int denominator = 8;
        String expected = "-6.25";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal9() throws Exception {
        int numerator = 0;
        int denominator = 8;
        String expected = "0";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal10() throws Exception {
        int numerator = 0;
        int denominator = -8;
        String expected = "0";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void testFractionToDecimal11() throws Exception {
        int numerator = -1;
        int denominator = -2147483648;
        String expected = "0.0000000004656612873077392578125";
        String actual = solution.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

}
