package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * NumberComplementSolution Tester.
 *
 * @author IronSid
 * @since 10/18/2021
 * @version 1.0
 */
public class NumberComplementSolutionTest {
    NumberComplementSolution.Solution solution = new NumberComplementSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: findComplement(int num)
    */
    @Test
    public void testFindComplement1() throws Exception {
        int num = 5;
        int expected = 2;
        int actual = solution.findComplement(num);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindComplement2() throws Exception {
        int num = 1;
        int expected = 0;
        int actual = solution.findComplement(num);
        assertEquals(expected, actual);
    }


}
