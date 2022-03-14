package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MinimumJumpsToReachHomeSolution Tester.
 *
 * @author IronSid
 * @since 03/15/2022
 * @version 1.0
 */
public class MinimumJumpsToReachHomeSolutionTest {
    MinimumJumpsToReachHomeSolution.Solution solution = new MinimumJumpsToReachHomeSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: minimumJumps(int[] forbidden, int a, int b, int x)
    */
    @Test
    public void testMinimumJumps() throws Exception {
        int[] forbidden = {162,118,178,152,167,100,40,74,199,186,26,73,200,127,30,124,193,84,184,36,103,149,153,9,54,
                154,133,95,45,198,79,157,64,122,59,71,48,177,82,35,14,176,16,108,111,6,168,31,134,164,136,72,98};
        int a = 29;
        int b = 98;
        int x = 80;
        int expected = 121;
        int actual = solution.minimumJumps(forbidden, a, b, x);
        assertEquals(expected, actual);
    }


}
