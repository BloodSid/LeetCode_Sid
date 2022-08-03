package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * OrderlyQueueSolution Tester.
 *
 * @author IronSid
 * @since 08/03/2022
 * @version 1.0
 */
public class OrderlyQueueSolutionTest {
    OrderlyQueueSolution.Solution solution = new OrderlyQueueSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: orderlyQueue(String s, int k)
    */
    @Test
    public void testOrderlyQueue1() throws Exception {
        String s = "baaaa";
        int k = 1;
        String expected = "aaaab";
        String actual = solution.orderlyQueue(s, k);
        assertEquals(expected, actual);
    }

    /**
    * Method: orderlyQueue(String s, int k)
    */
    @Test
    public void testOrderlyQueue2() throws Exception {
        String s = "cbacba";
        int k = 1;
        String expected = "acbacb";
        String actual = solution.orderlyQueue(s, k);
        assertEquals(expected, actual);
    }


}
