package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MatchsticksToSquareSolution Tester.
 *
 * @author IronSid
 * @since 06/01/2022
 * @version 1.0
 */
public class MatchsticksToSquareSolutionTest {
    MatchsticksToSquareSolution.Solution solution = new MatchsticksToSquareSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: makesquare(int[] matchsticks)
    */
    @Test
    public void testMakesquare() throws Exception {
        int[] matchsticks = {1,1,2,2,2};
        boolean expected = true;
        boolean actual = solution.makesquare(matchsticks);
        assertEquals(expected, actual);
    }



}
