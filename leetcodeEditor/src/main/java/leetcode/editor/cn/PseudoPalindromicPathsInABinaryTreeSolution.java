package leetcode.editor.cn;
//给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。 
//
// 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [2,3,1,3,1,null,1]
//输出：2 
//解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
//     在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排
//列 [1,2,1] 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1,1,3,null,null,null,null,null,1]
//输出：1 
//解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
//     这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
// 
//
// 示例 3： 
//
// 
//输入：root = [9]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 给定二叉树的节点数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 9 
// 
//
// 👍 118 👎 0


import binaryTree.TreeNode;

/**
 * 二叉树中的伪回文路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-25 23:43:59 
 */
public class PseudoPalindromicPathsInABinaryTreeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int res;

    public int pseudoPalindromicPaths (TreeNode root) {
        int[] f = new int[10];
        res = 0;
        dfs(root, f);
        return res;
    }

    private void dfs(TreeNode cur, int[] f) {
        if (cur == null) return;
        f[cur.val]++;
        if (cur.left == null && cur.right == null) {
            int odd = 0;
            for (int i = 1; i <= 9; i++) {
                odd += f[i] & 1;
            }
            if (odd <= 1) res++;
        }
        dfs(cur.left, f);
        dfs(cur.right, f);
        f[cur.val]--;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
