package leetcode.editor.cn;
//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
// 👍 287 👎 0


import binaryTree.TreeNode;

/**
 * 找树左下角的值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-22 00:33:03 
 */
public class FindBottomLeftTreeValueSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int maxDepth;
    private int value;

    public int findBottomLeftValue(TreeNode root) {
        maxDepth = 0;
        value = 0;
        dfs(root, 1);
        return value;
    }

    void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (depth > maxDepth) {
            maxDepth = depth;
            value = node.val;
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
