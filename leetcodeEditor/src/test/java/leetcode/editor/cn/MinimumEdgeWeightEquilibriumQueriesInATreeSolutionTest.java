package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author IronSid
 * @since 2024-01-30 22:17
 */
public class MinimumEdgeWeightEquilibriumQueriesInATreeSolutionTest {
    MinimumEdgeWeightEquilibriumQueriesInATreeSolution.Solution solution = new MinimumEdgeWeightEquilibriumQueriesInATreeSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: minOperationsQueries(int n, int[][] edges, int[][] queries)
     */
    @Test
    public void testMinOperationsQueries1() throws Exception {
        int n = 7;
        String eds = "[[0,1,1],[1,2,1],[2,3,1],[3,4,2],[4,5,2],[5,6,2]]";
        String qs = "[[0,3],[3,6],[2,6],[0,6]]";
        int[][] edges = JSON.parseArray(eds, int[].class).toArray(new int[0][]);
        int[][] queries = JSON.parseArray(qs, int[].class).toArray(new int[0][]);
        String exs = "[0,0,1,3]";
        int[] expected = JSON.parseArray(exs, int.class).stream().mapToInt(o -> o).toArray();
        int[] actual = solution.minOperationsQueries(n, edges, queries);
        assertArrayEquals(expected, actual);
    }
}