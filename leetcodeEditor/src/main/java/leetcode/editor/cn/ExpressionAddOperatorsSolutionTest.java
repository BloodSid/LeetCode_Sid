package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.List;

import static org.junit.Assert.*;

/**
 * ExpressionAddOperatorsSolution Tester.
 *
 * @author IronSid
 * @since 10/17/2021
 * @version 1.0
 */
public class ExpressionAddOperatorsSolutionTest {
    ExpressionAddOperatorsSolution.Solution solution = new ExpressionAddOperatorsSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: addOperators(String num, int target)
    */
    @Test
    public void testAddOperators1() throws Exception {
        String num = "123";
        int target = 6;
        String[] expected = {"1+2+3", "1*2*3"};
        List<String> actual = solution.addOperators(num, target);
        assertEquals(expected.length, actual.size());
        for (String s : expected) {
            assertTrue("expected:" + s, actual.contains(s));
        }
    }

    @Test
    public void testAddOperators2() throws Exception {
        String num = "232";
        int target = 8;
        String[] expected = {"2*3+2", "2+3*2"};
        List<String> actual = solution.addOperators(num, target);
        assertEquals(expected.length, actual.size());
        for (String s : expected) {
            assertTrue("expected:" + s, actual.contains(s));
        }
    }

    @Test
    public void testAddOperators3() throws Exception {
        String num = "105";
        int target = 5;
        String[] expected = {"1*0+5","10-5"};
        List<String> actual = solution.addOperators(num, target);
        assertEquals(expected.length, actual.size());
        for (String s : expected) {
            assertTrue("expected:" + s, actual.contains(s));
        }
    }

    @Test
    public void testAddOperators4() throws Exception {
        String num = "00";
        int target = 0;
        String[] expected = {"0+0", "0-0", "0*0"};
        List<String> actual = solution.addOperators(num, target);
        assertEquals(expected.length, actual.size());
        for (String s : expected) {
            assertTrue("expected:" + s, actual.contains(s));
        }
    }

    @Test
    public void testAddOperators5() throws Exception {
        String num = "3456237490";
        int target = 9191;
        String[] expected = {};
        List<String> actual = solution.addOperators(num, target);
        assertEquals(expected.length, actual.size());
        for (String s : expected) {
            assertTrue("expected:" + s, actual.contains(s));
        }
    }

}
