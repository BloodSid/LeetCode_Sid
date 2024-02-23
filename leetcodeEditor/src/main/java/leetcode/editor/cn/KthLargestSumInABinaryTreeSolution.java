package leetcode.editor.cn;
//给你一棵二叉树的根节点 root 和一个正整数 k 。 
//
// 树中的 层和 是指 同一层 上节点值的总和。 
//
// 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。 
//
// 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,8,9,2,1,3,7,4,6], k = 2
//输出：13
//解释：树中每一层的层和分别是：
//- Level 1: 5
//- Level 2: 8 + 9 = 17
//- Level 3: 2 + 1 + 3 + 7 = 13
//- Level 4: 4 + 6 = 10
//第 2 大的层和等于 13 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,null,3], k = 1
//输出：3
//解释：最大的层和是 3 。
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 
// 2 <= n <= 10⁵ 
// 1 <= Node.val <= 10⁶ 
// 1 <= k <= n 
// 
//
// 👍 24 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树中的第 K 大层和
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-23 13:24:33 
 */
public class KthLargestSumInABinaryTreeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<Long> sum;

    public long kthLargestLevelSum(TreeNode root, int k) {
        sum = new ArrayList<>();
        dfs(root, 0);
        int n = sum.size();
        if (n < k) {
            return -1;
        }
        Collections.sort(sum);
        return sum.get(n - k);
    }

    void dfs(TreeNode rt, int d) {
        if (rt == null) {
            return;
        }
        if (d == sum.size()) {
            sum.add(0L);
        }
        sum.set(d, sum.get(d) + rt.val);
        dfs(rt.left, d + 1);
        dfs(rt.right, d + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
