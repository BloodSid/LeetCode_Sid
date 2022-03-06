package leetcode.editor.cn;

import linkedList.ListNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * ReorderListSolution Tester.
 *
 * @author IronSid
 * @since 11/16/2021
 * @version 1.0
 */
public class ReorderListSolutionTest {
    ReorderListSolution.Solution solution = new ReorderListSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: reorderList(ListNode head)
    */
    @Test
    public void testReorderList1() throws Exception {
        ListNode head = new ListNode("1,2,3,4");
        ListNode expected = new ListNode("1,4,2,3");
        solution.reorderList(head);
        while (head != null && expected != null) {
            assertEquals(expected.val, head.val);
            expected = expected.next;
            head = head.next;
        }
        assertEquals(expected, head);
    }

}
