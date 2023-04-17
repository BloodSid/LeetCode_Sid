package leetcode.editor.cn;
//给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。 
//
//
// （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先） 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
//输出：7
//解释： 
//我们有大量的节点与其祖先的差值，其中一些如下：
//|8 - 3| = 5
//|3 - 7| = 4
//|8 - 1| = 7
//|10 - 13| = 3
//在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,null,2,null,0,3]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 2 到 5000 之间。 
// 0 <= Node.val <= 10⁵ 
// 
//
// 👍 142 👎 0


import binaryTree.TreeNode;

/**
 * 节点与其祖先之间的最大差值
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-18 00:39:15 
 */
public class MaximumDifferenceBetweenNodeAndAncestorSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int max;

    public int maxAncestorDiff(TreeNode root) {
        max = 0;
        dfs(root);
        return max;
    }

    // {lowest, greatest}
    int[] dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return new int[]{node.val, node.val};
        }
        int[] bound = null;
        if (node.left != null && node.right != null) {
            int[] left = dfs(node.left);
            int[] right = dfs(node.right);
            bound = new int[]{Math.min(left[0], right[0]), Math.max(left[1], right[1])};
        } else if (node.left != null) {
            bound = dfs(node.left);
        } else {
            bound = dfs(node.right);
        }
        max = Math.max(max, Math.abs(node.val - bound[0]));
        max = Math.max(max, Math.abs(bound[1] - node.val));
        return new int[]{Math.min(bound[0], node.val), Math.max(bound[1], node.val)};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
