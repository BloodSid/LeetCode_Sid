package leetcode.editor.cn;

import binaryTree.BinaryTree;
import binaryTree.TreeNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * LowestCommonAncestorOfABinaryTreeSolution Tester.
 *
 * @author IronSid
 * @since 11/21/2021
 * @version 1.0
 */
public class LowestCommonAncestorOfABinaryTreeSolutionTest {
    LowestCommonAncestorOfABinaryTreeSolution.Solution solution = new LowestCommonAncestorOfABinaryTreeSolution().new Solution();
    @Before
    public void before() throws Exception {
        
    }

    @After
    public void after() throws Exception {
    }

    /**
    * Method: lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    */
    @Test
    public void testLowestCommonAncestor1() throws Exception {
        String data = "3,5,1,6,2,0,8,null,null,7,4";
        TreeNode root = BinaryTree.stringToBinaryTree(data);
        TreeNode p = dfs(root, 5);
        TreeNode q = dfs(root, 1);
        TreeNode expected = dfs(root, 3);
        TreeNode actual = solution.lowestCommonAncestor(root, p, q);
        assertEquals(expected, actual);
    }

    @Test
    public void testLowestCommonAncestor2() throws Exception {
        String data = "3,5,1,6,2,0,8,null,null,7,4";
        TreeNode root = BinaryTree.stringToBinaryTree(data);
        TreeNode p = dfs(root, 5);
        TreeNode q = dfs(root, 4);
        TreeNode expected = dfs(root, 5);
        TreeNode actual = solution.lowestCommonAncestor(root, p, q);
        assertEquals(expected, actual);
    }

    TreeNode dfs(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (val == root.val) {
            return root;
        }
        TreeNode left = dfs(root.left, val);
        TreeNode right = dfs(root.right, val);
        return left == null ? right : left;
    }
}
