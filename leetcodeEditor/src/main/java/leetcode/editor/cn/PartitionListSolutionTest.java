package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * PartitionListSolution Tester.
 *
 * @author IronSid
 * @since 02/25/2022
 * @version 1.0
 */
public class PartitionListSolutionTest {
    PartitionListSolution.Solution solution = new PartitionListSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: partition(ListNode head, int x)
    */
    @Test
    public void testPartition() throws Exception {
        ListNode head = new ListNode("1,4,3,2,5,2");
        int x = 3;
        String expected = "1,2,2,4,3,5,null";
        String actual = solution.partition(head, x).toString();
        assertEquals(expected, actual);
    }


}
