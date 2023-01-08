package Contest0108.T4;

import com.alibaba.fastjson.JSON;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Solution Tester.
 *
 * @author IronSid
 * @since 01/08/2023
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
    * Method: findCrossingTime(int n, int k, int[][] time)
    */
    @Test
    public void testFindCrossingTime1() throws Exception {
        int n = 1;
        int k = 3;
        int[][] time = {{1,1,2,1}, {1,1,3,1}, {1,1,4,1}};
        int expected = 6;
        int actual = solution.findCrossingTime(n, k, time);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindCrossingTime2() throws Exception {
        int n = 3;
        int k = 2;
        String s = "[[1,9,1,8],[10,10,10,10]]";
        int[][] time = JSON.parseArray(s, int[].class).toArray(new int[0][]);
        int expected = 50;
        int actual = solution.findCrossingTime(n, k, time);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindCrossingTime3() throws Exception {
        int n = 10;
        int k = 6;
        String s = "[[2,10,5,8],[3,5,2,2],[5,8,10,10],[7,8,8,5],[5,6,6,10],[6,10,6,2]]";
        int[][] time = JSON.parseArray(s, int[].class).toArray(new int[0][]);
        int expected = 149;
        int actual = solution.findCrossingTime(n, k, time);
        assertEquals(expected, actual);
    }

    @Test
    public void testFindCrossingTime4() throws Exception {
        int n = 8;
        int k = 5;
        String s = "[[10,8,4,7],[10,6,9,10],[3,7,4,6],[7,3,9,10],[10,6,3,5]]";
        int[][] time = JSON.parseArray(s, int[].class).toArray(new int[0][]);
        int expected = 133;
        int actual = solution.findCrossingTime(n, k, time);
        assertEquals(expected, actual);
    }

}
