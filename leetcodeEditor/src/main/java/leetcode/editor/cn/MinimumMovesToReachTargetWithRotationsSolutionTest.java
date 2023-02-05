package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MinimumMovesToReachTargetWithRotationsSolution Tester.
 *
 * @author IronSid
 * @since 02/06/2023
 * @version 1.0
 */
public class MinimumMovesToReachTargetWithRotationsSolutionTest {
    MinimumMovesToReachTargetWithRotationsSolution.Solution solution = new MinimumMovesToReachTargetWithRotationsSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: minimumMoves(int[][] grid)
    */
    @Test
    public void testMinimumMoves1() throws Exception {
        String gs = "[[0,0,0,0,0,1],[1,1,0,0,1,0],[0,0,0,0,1,1],[0,0,1,0,1,0],[0,1,1,0,0,0],[0,1,1,0,0,0]]";
        int[][] grid = JSON.parseArray(gs, int[].class).toArray(new int[0][]);
        int expected = 11;
        int actual = solution.minimumMoves(grid);
        assertEquals(expected, actual);
    }

    /**
    * Method: minimumMoves(int[][] grid)
    */
    @Test
    public void testMinimumMoves2() throws Exception {
        String gs = "[[0,0,1,1,1,1],[0,0,0,0,1,1],[1,1,0,0,0,1],[1,1,1,0,0,1],[1,1,1,0,0,1],[1,1,1,0,0,0]]\n";
        int[][] grid = JSON.parseArray(gs, int[].class).toArray(new int[0][]);
        int expected = 9;
        int actual = solution.minimumMoves(grid);
        assertEquals(expected, actual);
    }


}
