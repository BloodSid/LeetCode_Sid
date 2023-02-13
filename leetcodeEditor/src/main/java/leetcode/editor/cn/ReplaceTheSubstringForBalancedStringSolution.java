package leetcode.editor.cn;
//有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。 
//
// 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。 
//
// 
//
// 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。 
//
// 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。 
//
// 请返回待替换子串的最小可能长度。 
//
// 如果原字符串自身就是一个平衡字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "QWER"
//输出：0
//解释：s 已经是平衡的了。 
//
// 示例 2： 
//
// 
//输入：s = "QQWE"
//输出：1
//解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
// 
//
// 示例 3： 
//
// 
//输入：s = "QQQW"
//输出：2
//解释：我们可以把前面的 "QQ" 替换成 "ER"。 
// 
//
// 示例 4： 
//
// 
//输入：s = "QQQQ"
//输出：3
//解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s.length 是 4 的倍数 
// s 中只含有 'Q', 'W', 'E', 'R' 四种字符 
// 
// 👍 102 👎 0


/**
 * 替换子串得到平衡字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-02-13 00:13:24 
 */
public class ReplaceTheSubstringForBalancedStringSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int balancedString(String ss) {
        char[] s = ss.toCharArray();
        int[] cnt = new int[128];
        for (char c : s) {
            cnt[c]++;
        }
        int n = s.length;
        for (char c : "QWER".toCharArray()) {
            cnt[c] = Math.max(0, cnt[c] - n / 4);
        }
        int min = n;
        int[] f = new int[128];
        for (int i = 0, j = 0; i < s.length; i++) {
            if (i > 0) {
                f[s[i - 1]]--;
            }
            while(!isEnough(cnt, f) && j < n) {
                f[s[j]]++;
                j++;
            }
            if (isEnough(cnt, f)) {
                min = Math.min(min, j - i);
            }
        }
        return min;
    }

    private boolean isEnough(int[] cnt, int[] f) {
        for (char c : "QWER".toCharArray()) {
            if (cnt[c] > f[c]) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
