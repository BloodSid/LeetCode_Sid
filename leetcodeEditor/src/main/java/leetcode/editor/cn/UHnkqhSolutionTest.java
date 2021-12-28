package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * UHnkqhSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 12/28/2021
 */
public class UHnkqhSolutionTest {
    UHnkqhSolution.Solution solution = new UHnkqhSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: reverseList(ListNode head)
     */
    @Test
    public void testReverseList() throws Exception {
        ListNode head = new ListNode("1,2,3,4,5");
        String expected = "5,4,3,2,1,null";
        String actual = solution.reverseList(head).toString();
        assertEquals(expected, actual);
    }
}
