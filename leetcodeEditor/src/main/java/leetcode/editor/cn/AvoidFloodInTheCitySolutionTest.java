package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * AvoidFloodInTheCitySolution Tester.
 *
 * @author IronSid
 * @since 08/20/2022
 * @version 1.0
 */
public class AvoidFloodInTheCitySolutionTest {
    AvoidFloodInTheCitySolution.Solution solution = new AvoidFloodInTheCitySolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: avoidFlood(int[] rains)
    */
    @Test
    public void testAvoidFlood() throws Exception {
        int[] rains = {1,2,0,0,2,1};
        int[] expected = {-1,-1,2,1,-1,-1};
        int[] actual = solution.avoidFlood(rains);
        assertArrayEquals(expected, actual);
    }


}
