package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ShuZiXuLieZhongMouYiWeiDeShuZiLcofSolution Tester.
 *
 * @author IronSid
 * @since 01/26/2022
 * @version 1.0
 */
public class ShuZiXuLieZhongMouYiWeiDeShuZiLcofSolutionTest {
    ShuZiXuLieZhongMouYiWeiDeShuZiLcofSolution.Solution solution = new ShuZiXuLieZhongMouYiWeiDeShuZiLcofSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: findNthDigit(int n)
    */
    @Test
    public void testFindNthDigit1() throws Exception {
        int n = 10;
        int expected = 1;
        int actual = solution.findNthDigit(n);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindNthDigit2() throws Exception {
        int n = 1000000000;
        int expected = 1;
        int actual = solution.findNthDigit(n);
        assertEquals(expected, actual);
    }


}
