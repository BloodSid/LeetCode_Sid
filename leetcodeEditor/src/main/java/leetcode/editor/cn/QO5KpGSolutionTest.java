package leetcode.editor.cn;

import binaryTree.BinaryTree;
import binaryTree.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * QO5KpGSolution Tester.
 *
 * @author IronSid
 * @version 1.0
 * @since 04/17/2022
 */
public class QO5KpGSolutionTest {
    QO5KpGSolution.Solution solution = new QO5KpGSolution().new Solution();

    @Before
    public void before() throws Exception {

    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getNumber(TreeNode root, int[][] ops)
     */
    @Test
    public void testGetNumber1() throws Exception {
        TreeNode root = BinaryTree.stringToBinaryTree("1,null,2,null,3,null,4,null,5");
        int[][] ops = {{1, 2, 4}, {1, 1, 3}, {0, 3, 5}};
        int expected = 2;
        int actual = solution.getNumber(root, ops);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumber2() throws Exception {
        TreeNode root = BinaryTree.stringToBinaryTree("4,2,7,1,null,5,null,null,null,null,6");
        int[][] ops = {{0, 2, 2}, {1, 1, 5}, {0, 4, 5}, {1, 5, 7}};
        int expected = 5;
        int actual = solution.getNumber(root, ops);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNumber3() throws Exception {
        TreeNode root = BinaryTree.stringToBinaryTree("60,null,66");
        int[][] ops = {{0, 66, 66}, {1, 60, 60}, {1, 60, 60}};
        int expected = 1;
        int actual = solution.getNumber(root, ops);
        assertEquals(expected, actual);
    }


}
