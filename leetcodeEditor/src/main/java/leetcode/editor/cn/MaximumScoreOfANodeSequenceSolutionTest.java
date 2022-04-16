package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MaximumScoreOfANodeSequenceSolution Tester.
 *
 * @author IronSid
 * @since 04/17/2022
 * @version 1.0
 */
public class MaximumScoreOfANodeSequenceSolutionTest {
    MaximumScoreOfANodeSequenceSolution.Solution solution = new MaximumScoreOfANodeSequenceSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: maximumScore(int[] scores, int[][] edges)
    */
    @Test
    public void testMaximumScore1() throws Exception {
        int[] scores = {5,2,9,8,4};
        int[][] edges = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        int expected = 24;
        int actual = solution.maximumScore(scores, edges);
        assertEquals(expected, actual);
    }

    @Test
    public void testMaximumScore2() throws Exception {
        int[] scores = {9,20,6,4,11,12};
        int[][] edges = {{0,3},{5,3},{2,4},{1,3}};
        int expected = -1;
        int actual = solution.maximumScore(scores, edges);
        assertEquals(expected, actual);

    }


}
