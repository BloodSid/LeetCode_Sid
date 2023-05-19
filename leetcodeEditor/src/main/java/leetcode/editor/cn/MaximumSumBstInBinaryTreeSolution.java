package leetcode.editor.cn;
//给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。 
//
// 二叉搜索树的定义如下： 
//
// 
// 任意节点的左子树中的键值都 小于 此节点的键值。 
// 任意节点的右子树中的键值都 大于 此节点的键值。 
// 任意节点的左子树和右子树都是二叉搜索树。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
//输出：20
//解释：键值为 3 的子树是和最大的二叉搜索树。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [4,3,null,1,2]
//输出：2
//解释：键值为 2 的单节点子树是和最大的二叉搜索树。
// 
//
// 示例 3： 
//
// 
//输入：root = [-4,-2,-5]
//输出：0
//解释：所有节点键值都为负数，和最大的二叉搜索树为空。
// 
//
// 示例 4： 
//
// 
//输入：root = [2,1,3]
//输出：6
// 
//
// 示例 5： 
//
// 
//输入：root = [5,4,8,3,null,6,3]
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 每棵树有 1 到 40000 个节点。 
// 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。 
// 
//
// 👍 121 👎 0


import binaryTree.TreeNode;

/**
 * 二叉搜索子树的最大键值和
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-20 01:51:59 
 */
public class MaximumSumBstInBinaryTreeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int ans;

    public int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        ans = 0;
        dfs(root);
        return ans;
    }

    // {sum, min, max, isBST}
    int[] dfs(TreeNode node) {
        int[] l = null, r = null;
        int[] res = new int[]{node.val, node.val, node.val, 0};
        boolean isBST = true;
        if (node.left != null) {
            l = dfs(node.left);
            update(res, l);
            isBST &= l[3] == 1 &&  node.val > l[2];
        }
        if (node.right != null) {
            r = dfs(node.right);
            update(res, r);
            isBST &= r[3] == 1 && node.val < r[1];
        }
        if (isBST) {
            ans = Math.max(ans, res[0]);
        }
        res[3] = isBST ? 1 : 0;
        return res;
    }

    private void update(int[] res, int[] a) {
        res[0] += a[0];
        res[1] = Math.min(res[1], a[1]);
        res[2] = Math.max(res[2], a[2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
