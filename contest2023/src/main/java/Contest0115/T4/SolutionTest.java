package Contest0115.T4;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 01/15/2023
 * @version 1.0
 */
public class SolutionTest {
    Solution solution = new Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: maxOutput(int n, int[][] edges, int[] price)
    */
    @Test
    public void testMaxOutput() throws Exception {
        int n = 8;
        int[][] edges = JSON.parseArray("[[1,7],[2,3],[4,0],[5,7],[6,3],[3,0],[0,7]]", int[].class).toArray(new int[0][]);
        int[] price = JSON.parseArray("[4,5,6,2,2,7,7,8]", int.class).stream().mapToInt(o -> o).toArray();
        long expected = 21;
        long actual = solution.maxOutput(n, edges, price);
        assertEquals(expected, actual);
    }


}
