package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * CatAndMouseSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 01/04/2022
 */
public class CatAndMouseSolutionTest {
    CatAndMouseSolution.Solution solution = new CatAndMouseSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: catMouseGame(int[][] graph)
     */
    @Test
    public void testCatMouseGame1() throws Exception {
        int[][] graph = {{2, 5}, {3}, {0, 4, 5}, {1, 4, 5}, {2, 3}, {0, 2, 3}};
        int expected = 0;
        int actual = solution.catMouseGame(graph);
        assertEquals(expected, actual);
    }

    @Test
    public void testCatMouseGame2() throws Exception {
        int[][] graph = {{1, 3}, {0}, {3}, {0, 2}};
        int expected = 1;
        int actual = solution.catMouseGame(graph);
        assertEquals(expected, actual);
    }

    @Test
    public void testCatMouseGame3() throws Exception {
        // 用2n做k的上界会判断错误的用例
        // [[5, 7, 9], [3, 4, 5, 6], [3, 4, 5, 8], [1, 2, 6, 7], [1, 2, 5, 7, 9], [0, 1, 2, 4, 8], [1, 3, 7, 8],
        //  [0, 3, 4, 6, 8], [2, 5, 6, 7, 9], [0, 4, 8]]
        // [[2, 4, 6], [2, 5, 6, 7], [0, 1, 6, 8, 9], [4, 5, 7, 9], [0, 3, 6, 7, 8], [1, 3, 6, 7, 9],
        //  [0, 1, 2, 4, 5, 9], [1, 3, 4, 5, 8], [2, 4, 7, 9], [2, 3, 5, 6, 8]]
        // [[7], [2, 6, 8, 9], [1, 4, 5, 6, 7], [4, 5, 7], [2, 3, 5, 8], [2, 3, 4, 7], [1, 2, 9],
        //  [0, 2, 3, 5, 9], [1, 4, 9], [1, 6, 7, 8]]
        // 上界4*N时会错 [[3],[2,4,6,7,12],[1,3,10],[0,2,4,5,7,11],[1,3,6,9,10],[3,7,10],[1,4,7,11,12],
        // [1,3,5,6],[9,11,12],[4,8,10],[2,4,5,9,11],[3,6,8,10,12],[1,6,8,11]]
        // 上界3*N时会错 [[8],[5,7,9],[3,6,7],[2,4,6,8],[3,5,6,8],[1,4,7,9],[2,3,4,9],[1,2,5,8],[0,3,4,7],[1,5,6]]
        int[][] graph = {{5, 7, 9}, {3, 4, 5, 6}, {3, 4, 5, 8}, {1, 2, 6, 7}, {1, 2, 5, 7, 9}, {0, 1, 2, 4, 8},
                {1, 3, 7, 8}, {0, 3, 4, 6, 8}, {2, 5, 6, 7, 9}, {0, 4, 8}};
        int expected = 1;
        // k = 2n 时结果是0, k = 2n^2 时结果是1
        int actual = solution.catMouseGame(graph);
        assertEquals(expected, actual);
    }

}
