package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MinimumScoreTriangulationOfPolygonSolution Tester.
 *
 * @author IronSid
 * @since 04/02/2023
 * @version 1.0
 */
public class MinimumScoreTriangulationOfPolygonSolutionTest {
    MinimumScoreTriangulationOfPolygonSolution.Solution solution = new MinimumScoreTriangulationOfPolygonSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: minScoreTriangulation(int[] values)
    */
    @Test
    public void testMinScoreTriangulation1() throws Exception {
        String ts = "[69,22,21,27,26,62,69,81,55,85,95,40,91,33,72,88,86]";
        int[] values = JSON.parseArray(ts, int.class).stream().mapToInt(o -> o).toArray();
        int expected = 1334781;
        int actual = solution.minScoreTriangulation(values);
        assertEquals(expected, actual);
    }

}
