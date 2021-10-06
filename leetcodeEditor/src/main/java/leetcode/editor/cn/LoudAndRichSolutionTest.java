package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * LoudAndRichSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/06/2021
 */
public class LoudAndRichSolutionTest {
    LoudAndRichSolution.Solution solution = new LoudAndRichSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: loudAndRich(int[][] richer, int[] quiet)
     */
    @Test
    public void testLoudAndRich1() throws Exception {
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        int[] expected = {5, 5, 2, 5, 4, 5, 6, 7};
        int[] actual = solution.loudAndRich(richer, quiet);
        assertArrayEquals("expected:\n" + Arrays.toString(expected) + "\nactual:\n"
                          + Arrays.toString(actual) + "\n", expected, actual);
    }

    @Test
    public void testLoudAndRich2() throws Exception {
        int[][] richer = {{0, 1}};
        int[] quiet = {0, 1, 2};
        int[] expected = {0, 0, 2};
        int[] actual = solution.loudAndRich(richer, quiet);
        assertArrayEquals("expected:\n" + Arrays.toString(expected) + "\nactual:\n"
                          + Arrays.toString(actual) + "\n", expected, actual);
    }


}
