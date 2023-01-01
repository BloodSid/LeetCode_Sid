package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * NumberOfOrdersInTheBacklogSolution Tester.
 *
 * @author IronSid
 * @since 01/02/2023
 * @version 1.0
 */
public class NumberOfOrdersInTheBacklogSolutionTest {
    NumberOfOrdersInTheBacklogSolution.Solution solution = new NumberOfOrdersInTheBacklogSolution.Solution();
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: getNumberOfBacklogOrders(int{}{} orders)
    */
    @Test
    public void testGetNumberOfBacklogOrders() throws Exception {
        int[][] orders = {{26,7,0},{16,1,1},{14,20,0},{23,15,1},{24,26,0},{19,4,1},{1,1,0}};
        int expected = 34;
        int actual = solution.getNumberOfBacklogOrders(orders);
        assertEquals(expected, actual);
    }


}
