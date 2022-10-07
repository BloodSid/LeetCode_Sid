package Contest1007.T2;

import binaryTree.TreeNode;

/**
 * @author IronSid
 * @since 2022-10-07 14:58
 */
public class Solution {
    public TreeNode expandBinaryTree(TreeNode root) {
        if (root == null) return null;
        if (root.left != null) root.left = new TreeNode(-1, expandBinaryTree(root.left), null);
        if (root.right != null) root.right = new TreeNode(-1, null, expandBinaryTree(root.right));
        return root;
    }
}
