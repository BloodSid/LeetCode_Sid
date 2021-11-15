package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import static org.junit.Assert.*;

/**
 * DesignLinkedListSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 11/15/2021
 */
public class DesignLinkedListSolutionTest {
    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    @Test
    public void test1() throws Exception {
        DesignLinkedListSolution.MyLinkedList myLinkedList = new DesignLinkedListSolution().new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(3);
        myLinkedList.addAtIndex(1, 2);
        assertEquals(2, myLinkedList.get(1));
        myLinkedList.deleteAtIndex(1);
        assertEquals(3, myLinkedList.get(1));
    }


}
