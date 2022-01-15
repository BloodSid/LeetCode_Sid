package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * ShuZhiDeZhengShuCiFangLcofSolution Tester.
 *
 * @author IronSid
 * @since 01/15/2022
 * @version 1.0
 */
public class ShuZhiDeZhengShuCiFangLcofSolutionTest {
    ShuZhiDeZhengShuCiFangLcofSolution.Solution solution = new ShuZhiDeZhengShuCiFangLcofSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: myPow(double x, int n)
    */
    @Test
    public void testMyPow() throws Exception {
        double x = 2;
        int n = -1;
        double expected = 0.5;
        double actual = solution.myPow(x, n);
        assertEquals(expected, actual, 10e-5);
    }

}
