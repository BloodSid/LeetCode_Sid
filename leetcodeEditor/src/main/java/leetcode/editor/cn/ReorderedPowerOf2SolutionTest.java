package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ReorderedPowerOf2Solution Tester.
 *
 * @author IronSid
 * @since 10/28/2021
 * @version 1.0
 */
public class ReorderedPowerOf2SolutionTest {
    ReorderedPowerOf2Solution.Solution solution = new ReorderedPowerOf2Solution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: reorderedPowerOf2(int n)
    */
    @Test
    public void testReorderedPowerOf2_1() throws Exception {
        int n = 1;
        boolean expected = true;
        boolean actual = solution.reorderedPowerOf2(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testReorderedPowerOf2_2() throws Exception {
        int n = 10;
        boolean expected = false;
        boolean actual = solution.reorderedPowerOf2(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testReorderedPowerOf2_3() throws Exception {
        int n = 16;
        boolean expected = true;
        boolean actual = solution.reorderedPowerOf2(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testReorderedPowerOf2_4() throws Exception {
        int n = 24;
        boolean expected = false;
        boolean actual = solution.reorderedPowerOf2(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testReorderedPowerOf2_5() throws Exception {
        int n = 46;
        boolean expected = true;
        boolean actual = solution.reorderedPowerOf2(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testReorderedPowerOf2_6() throws Exception {
        int n = 218;
        boolean expected = true;
        boolean actual = solution.reorderedPowerOf2(n);
        assertEquals(expected, actual);
    }


}
