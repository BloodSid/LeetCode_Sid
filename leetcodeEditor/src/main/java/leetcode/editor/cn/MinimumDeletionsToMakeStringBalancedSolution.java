package leetcode.editor.cn;
//给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。 
//
// 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' 
//，此时认为 s 是 平衡 的。 
//
// 请你返回使 s 平衡 的 最少 删除次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aababbab"
//输出：2
//解释：你可以选择以下任意一种方案：
//下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
//下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
// 
//
// 示例 2： 
//
// 
//输入：s = "bbaaaaabb"
//输出：2
//解释：唯一的最优解是删除最前面两个字符。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 要么是 'a' 要么是 'b' 。 
// 
//
// 👍 135 👎 0


/**
 * 使字符串平衡的最少删除次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-06 19:31:44 
 */
public class MinimumDeletionsToMakeStringBalancedSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeletions(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] pa = new int[n + 1];
        int[] pb = new int[n + 1];
        for (int i = 0, ta = 0, tb = 0; i < ch.length; i++) {
            if (ch[i] == 'a') ta++;
            else tb++;
            pa[i + 1] = ta;
            pb[i + 1] = tb;
        }
        int min = n;
        for (int i = 0; i <= n; i++) {
            min = Math.min(min, pb[i] + pa[n] - pa[i]);
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
