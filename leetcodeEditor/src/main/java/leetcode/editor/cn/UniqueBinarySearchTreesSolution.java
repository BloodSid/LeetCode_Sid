package leetcode.editor.cn;
//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
// 👍 1791 👎 0


/**
 * 不同的二叉搜索树
 *
 * @author IronSid
 * @since 2022-06-09 23:42:16 
 * @version 1.0
 */
public class UniqueBinarySearchTreesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int left = 0; left < i; left++) {
                int right = i - 1 - left;
                dp[i] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
