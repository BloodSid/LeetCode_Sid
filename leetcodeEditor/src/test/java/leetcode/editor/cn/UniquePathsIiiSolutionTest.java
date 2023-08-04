package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author IronSid
 * @since 2023-08-05 0:27
 */
public class UniquePathsIiiSolutionTest {
    UniquePathsIiiSolution.Solution solution = new UniquePathsIiiSolution.Solution();

    /**
     * Method: uniquePathsIII(int[][] grid)
     */
    @Test
    public void testuniquePathsIII() throws Exception {
        String gs = "[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]";
        int[][] grid = JSON.parseArray(gs, int[].class).toArray(new int[0][]);
        int expected = 2;
        int actual = solution.uniquePathsIII(grid);
        assertEquals(expected, actual);
    }

}