package leetcode.editor.cn;
//给你一棵根为 root 的二叉树，请你返回二叉树中好节点的数目。 
//
// 「好节点」X 定义为：从根到该节点 X 所经过的节点中，没有任何节点的值大于 X 的值。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root = [3,1,4,3,null,1,5]
//输出：4
//解释：图中蓝色节点为好节点。
//根节点 (3) 永远是个好节点。
//节点 4 -> (3,4) 是路径中的最大值。
//节点 5 -> (3,4,5) 是路径中的最大值。
//节点 3 -> (3,1,3) 是路径中的最大值。 
//
// 示例 2： 
//
// 
//
// 输入：root = [3,3,null,4,2]
//输出：3
//解释：节点 2 -> (3, 3, 2) 不是好节点，因为 "3" 比它大。 
//
// 示例 3： 
//
// 输入：root = [1]
//输出：1
//解释：根节点是好节点。 
//
// 
//
// 提示： 
//
// 
// 二叉树中节点数目范围是 [1, 10^5] 。 
// 每个节点权值的范围是 [-10^4, 10^4] 。 
// 
// 👍 64 👎 0


import binaryTree.TreeNode;

/**
 * 统计二叉树中好节点的数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-25 15:28:10 
 */
public class CountGoodNodesInBinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    int dfs(TreeNode node, int max) {
        if (node == null) return 0;
        max = Math.max(node.val, max);
        return (node.val >= max ? 1 : 0) + dfs(node.left, max) + dfs(node.right, max);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
