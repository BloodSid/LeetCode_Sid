package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * TheKWeakestRowsInAMatrixSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 08/01/2021
 */
public class TheKWeakestRowsInAMatrixSolutionTest {
    TheKWeakestRowsInAMatrixSolution.Solution solution = new TheKWeakestRowsInAMatrixSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: kWeakestRows(int[][] mat, int k)
     */
    @Test
    public void testKWeakestRows1() throws Exception {
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int k = 3;
        int[] expected = {2, 0, 3};
        int[] actual = solution.kWeakestRows(mat, k);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    /**
     * Method: kWeakestRows(int[][] mat, int k)
     */
    @Test
    public void testKWeakestRows2() throws Exception {
        int[][] mat = {{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}};
        int k = 2;
        int[] expected = {0, 2};
        int[] actual = solution.kWeakestRows(mat, k);
        assertEquals(Arrays.toString(expected), Arrays.toString(actual));
    }

    /**
     * Method: search(int[] array)
     */
    @Test
    public void testSearch() throws Exception {
        int[] input = {0, 0, 0, 0, 0};
        int expected = 0,
                actual =
                        solution.search(input);
        assertEquals(expected, actual);
    }


}
