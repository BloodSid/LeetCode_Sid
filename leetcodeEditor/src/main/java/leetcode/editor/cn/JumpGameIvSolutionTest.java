package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * JumpGameIvSolution Tester.
 *
 * @author IronSid
 * @since 01/23/2022
 * @version 1.0
 */
public class JumpGameIvSolutionTest {
    JumpGameIvSolution.Solution solution = new JumpGameIvSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: minJumps(int[] arr)
    */
    @Test
    public void testMinJumps() throws Exception {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        int expected = 3;
        int actual = solution.minJumps(arr);
        assertEquals(expected, actual);
    }


}
