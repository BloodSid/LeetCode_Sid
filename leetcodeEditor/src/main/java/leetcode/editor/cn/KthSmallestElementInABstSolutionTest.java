package leetcode.editor.cn;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

/**
 * KthSmallestElementInABstSolution Tester.
 *
 * @author IronSid
 * @since 10/17/2021
 * @version 1.0
 */
public class KthSmallestElementInABstSolutionTest {
    KthSmallestElementInABstSolution.Solution solution = new KthSmallestElementInABstSolution().new Solution();
    BinaryTree binaryTree = new BinaryTree();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: kthSmallest(TreeNode root, int k)
    */
    @Test
    public void testKthSmallest1() throws Exception {
        TreeNode root = binaryTree.stringToBinaryTree("3,1,4,null,2");
        int k = 1;
        int expected = 1;
        int actual = solution.kthSmallest(root, k);
        assertEquals(expected, actual);
    }

    @Test
    public void testKthSmallest2() throws Exception {
        TreeNode root = binaryTree.stringToBinaryTree("5,3,6,2,4,null,null,1");
        int k = 3;
        int expected = 3;
        int actual = solution.kthSmallest(root, k);
        assertEquals(expected, actual);
    }

}
