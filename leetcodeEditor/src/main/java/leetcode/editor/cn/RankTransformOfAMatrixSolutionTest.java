    package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * RankTransformOfAMatrixSolution Tester.
 *
 * @author IronSid
 * @since 01/25/2023
 * @version 1.0
 */
public class RankTransformOfAMatrixSolutionTest {
    RankTransformOfAMatrixSolution.Solution solution = new RankTransformOfAMatrixSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: matrixRankTransform(int[][] matrix)
    */
    @Test
    public void testMatrixRankTransform1() throws Exception {
        String ms = "[[1,2],[3,4]]";
        String es = "[[1,2],[2,3]]";
        int[][] matrix = JSON.parseArray(ms, int[].class).toArray(new int[0][]);
        int[][] expected = JSON.parseArray(es, int[].class).toArray(new int[0][]);
        int[][] actual = solution.matrixRankTransform(matrix);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMatrixRankTransform2() throws Exception {
        String ms = "[[7,7],[7,7]]";
        String es = "[[1,1],[1,1]]";
        int[][] matrix = JSON.parseArray(ms, int[].class).toArray(new int[0][]);
        int[][] expected = JSON.parseArray(es, int[].class).toArray(new int[0][]);
        int[][] actual = solution.matrixRankTransform(matrix);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testMatrixRankTransform3() throws Exception {
        String ms = "[[20,-21,14],[-19,4,19],[22,-47,24],[-19,4,19]]";
        String es = "[[4,2,3],[1,3,4],[5,1,6],[1,3,4]]";
        int[][] matrix = JSON.parseArray(ms, int[].class).toArray(new int[0][]);
        int[][] expected = JSON.parseArray(es, int[].class).toArray(new int[0][]);
        int[][] actual = solution.matrixRankTransform(matrix);
        assertArrayEquals(expected, actual);
    }


}
