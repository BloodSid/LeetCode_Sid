package leetcode.editor.cn;
//给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
//输出：32
// 
//
// 示例 2： 
// 
// 
//输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 2 * 10⁴] 内 
// 1 <= Node.val <= 10⁵ 
// 1 <= low <= high <= 10⁵ 
// 所有 Node.val 互不相同 
// 
//
// 👍 364 👎 0


import binaryTree.TreeNode;

/**
 * 二叉搜索树的范围和
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-26 21:12:52 
 */
public class RangeSumOfBstSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
