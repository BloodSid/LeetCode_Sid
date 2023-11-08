package leetcode.editor.cn;
//给你一个仅由 0 和 1 组成的二进制字符串 s 。 
//
// 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字
//符串。 
//
// 返回 s 中最长的平衡子字符串长度。 
//
// 子字符串是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "01000111"
//输出：6
//解释：最长的平衡子字符串是 "000111" ，长度为 6 。
// 
//
// 示例 2： 
//
// 
//输入：s = "00111"
//输出：4
//解释：最长的平衡子字符串是 "0011" ，长度为  4 。
// 
//
// 示例 3： 
//
// 
//输入：s = "111"
//输出：0
//解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 50 
// '0' <= s[i] <= '1' 
// 
//
// 👍 39 👎 0


/**
 * 最长平衡子字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-08 10:21:47 
 */
public class FindTheLongestBalancedSubstringOfABinaryStringSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int[] cnt0 = new int[n];
        for (int i = 0, t = 0; i < n; i++) {
            if (ch[i] == '0') t++;
            else t = 0;
            cnt0[i] = t;
        }
        int ans = 0;
        for (int i = n - 1, t = 0; i >= 1; i--) {
            if (ch[i] == '1') t++;
            else t = 0;
            ans = Math.max(ans, Math.min(cnt0[i - 1], t));
        }
        return ans * 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
