package leetcode.editor.cn;
//给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。 
//
// 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,7,0,7,-8,null,null]
//输出：2
//解释：
//第 1 层各元素之和为 1，
//第 2 层各元素之和为 7 + 0 = 7，
//第 3 层各元素之和为 7 + -8 = -1，
//所以我们返回第 2 层的层号，它的层内元素之和最大。
// 
//
// 示例 2： 
//
// 
//输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在 [1, 10⁴]范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// 👍 59 👎 0


import binaryTree.TreeNode;

/**
 * 最大层内元素和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-31 00:24:48 
 */
public class MaximumLevelSumOfABinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MAX = (int) 1e4;
    // static
    final TreeNode[] q = new TreeNode[MAX];

    public int maxLevelSum(TreeNode root) {
        int res = 0, max = Integer.MIN_VALUE;
        q[0] = root;
        int l = 0, r = 1;
        int level = 1;
        while (r - l > 0) {
            int sum = 0;
            int end = r;
            for (; l < end; l++) {
                TreeNode cur = q[l];
                sum += cur.val;
                if (cur.left != null) q[r++] = cur.left;
                if (cur.right != null) q[r++] = cur.right;
            }
            if (sum > max) {
                max = sum;
                res = level;
            }
            level++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
