package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * MergeIntervalsSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/05/2021
 */
public class MergeIntervalsSolutionTest {
    MergeIntervalsSolution.Solution solution = new MergeIntervalsSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: merge(int[][] intervals)
     */
    @Test
    public void testMerge1() throws Exception {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected = {{1, 6}, {8, 10}, {15, 18}};
        int[][] actual = solution.merge(intervals);
        assertTrue("actual: " + Arrays.deepToString(actual), Arrays.deepEquals(expected, actual));
    }

    @Test
    public void testMerge2() throws Exception {
        int[][] intervals = {{1, 4}, {4, 5}};
        int[][] expected = {{1, 5}};
        int[][] actual = solution.merge(intervals);
        assertTrue("actual: " + Arrays.deepToString(actual), Arrays.deepEquals(expected, actual));
    }

    @Test
    public void testMerge3() throws Exception {
        int[][] intervals = {{1, 4}, {2, 3}};
        int[][] expected = {{1, 4}};
        int[][] actual = solution.merge(intervals);
        assertTrue("actual: " + Arrays.deepToString(actual), Arrays.deepEquals(expected, actual));
    }

}
