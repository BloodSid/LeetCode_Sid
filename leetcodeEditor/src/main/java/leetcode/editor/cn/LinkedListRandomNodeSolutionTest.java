package leetcode.editor.cn;

import linkedList.ListNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * LinkedListRandomNodeSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 01/16/2022
 */
public class LinkedListRandomNodeSolutionTest {
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getRandom()
     */
    @Test
    public void testGetRandom() throws Exception {
        ListNode head = new ListNode("1,2,3");
        LinkedListRandomNodeSolution.Solution solution = new LinkedListRandomNodeSolution().new Solution(head);
        long expected = (long) 1e10;
        System.out.println(expected);
        long[] freq = new long[4];
        for (long i = 0; i < expected; i++) {
            int n = solution.getRandom();
            assertTrue(n >= 1 && n <= 3);
            freq[n]++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("n:\t");
        for (int i = 0; i < freq.length; i++) {
            sb.append(i);
            sb.append('\t');
        }
        sb.append('\n').append("f:\t");
        long actual = 0;
        for (long i : freq) {
            actual += i;
            sb.append(i);
            sb.append('\t');
        }
        assertEquals(expected, actual);
        sb.append('\n').append("sum: ").append(actual);
        System.out.println(sb);
    }

}
