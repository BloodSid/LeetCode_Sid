package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * SearchA2dMatrixIiSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 10/25/2021
 */
public class SearchA2dMatrixIiSolutionTest {
    SearchA2dMatrixIiSolution.Solution solution = new SearchA2dMatrixIiSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: searchMatrix(int[][] matrix, int target)
     */
    @Test
    public void testSearchMatrix1() throws Exception {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 5;
        assertTrue("target: " + target, solution.searchMatrix(matrix, target));
    }

    @Test
    public void testSearchMatrix2() throws Exception {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 20;
        assertFalse("target: " + target, solution.searchMatrix(matrix, target));
    }

}
