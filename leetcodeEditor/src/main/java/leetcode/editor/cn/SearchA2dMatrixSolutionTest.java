package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * SearchA2dMatrixSolution Tester.
 *
 * @author IronSid
 * @since 10/26/2021
 * @version 1.0
 */
public class SearchA2dMatrixSolutionTest {
    SearchA2dMatrixSolution.Solution solution = new SearchA2dMatrixSolution().new Solution();
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
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean expected = true;
        boolean actual = solution.searchMatrix(matrix, target);
        assertEquals("target " + target, expected, actual);
    }

    @Test
    public void testSearchMatrix2() throws Exception {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        boolean expected = false;
        boolean actual = solution.searchMatrix(matrix, target);
        assertEquals("target " + target, expected, actual);
    }

}
