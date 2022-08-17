package leetcode.editor.cn;
//给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
//输出：15
// 
//
// 示例 2： 
//
// 
//输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
//输出：19
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 10⁴] 之间。 
// 1 <= Node.val <= 100 
// 
// 👍 134 👎 0


import binaryTree.TreeNode;

/**
 * 层数最深叶子节点的和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-17 22:52:07 
 */
public class DeepestLeavesSumSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int deepest = 0;
    int sum = 0;

    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (level > deepest) {
            deepest = level;
            sum = node.val;
        } else if (level == deepest) {
            sum += node.val;
        }
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
