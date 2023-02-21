package leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * MinimumNumberOfTapsToOpenToWaterAGardenSolution Tester.
 *
 * @author IronSid
 * @since 02/21/2023
 * @version 1.0
 */
public class MinimumNumberOfTapsToOpenToWaterAGardenSolutionTest {
    MinimumNumberOfTapsToOpenToWaterAGardenSolution.Solution solution = new MinimumNumberOfTapsToOpenToWaterAGardenSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: minTaps(int n, int[] ranges)
    */
    @Test
    public void testMinTaps1() throws Exception {
        int n = 5;
        String rangesText = "[3,4,1,1,0,0]";
        int[] ranges  = JSON.parseArray(rangesText, int.class).stream().mapToInt(o -> o).toArray();
        int actual = solution.minTaps(n, ranges);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void testMinTaps2() throws Exception {
        int n = 3;
        String rangesText = "[0,0,0,0]";
        int[] ranges  = JSON.parseArray(rangesText, int.class).stream().mapToInt(o -> o).toArray();
        int actual = solution.minTaps(n, ranges);
        int expected = -1;
        assertEquals(expected, actual);
    }


}
