package Contest0709.T1;

import binaryTree.TreeNode;

/**
 * @author IronSid
 * @since 2022-07-09 22:21
 */
class Solution {
    public boolean evaluateTree(TreeNode root) {
        if (root.left == null) return root.val == 1;
        if (root.val == 2) return evaluateTree(root.left) || evaluateTree(root.right);
        else return evaluateTree(root.left) && evaluateTree(root.right);
    }
}