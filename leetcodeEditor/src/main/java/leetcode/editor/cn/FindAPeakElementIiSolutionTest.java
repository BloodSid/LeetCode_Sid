package leetcode.editor.cn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

/**
 * FindAPeakElementIiSolution Tester.
 *
 * @author IronSid
 * @since 10/25/2022
 * @version 1.0
 */
public class FindAPeakElementIiSolutionTest {
    FindAPeakElementIiSolution.Solution solution = new FindAPeakElementIiSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: findPeakGrid(int[][] mat)
    */
    @Test
    public void testFindPeakGrid() throws Exception {
        int[][] mat = {{10,20,15},{21,30,14},{7,16,32}};
        int[] actual = solution.findPeakGrid(mat);
        int i = actual[0], j = actual[1], cur = mat[i][j];
        assertTrue(Arrays.toString(actual), (i == 0 || cur > mat[i - 1][j]) && (j == 0 || cur > mat[i][j - 1])
                && (i == mat.length - 1 || cur > mat[i + 1][j]) && (j == mat[0].length - 1 || cur > mat[i][j + 1]));

    }


}
