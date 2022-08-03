package leetcode.editor.cn;
//给定一个字符串 s 和一个整数 k 。你可以从 s 的前 k 个字母中选择一个，并把它加到字符串的末尾。 
//
// 返回 在应用上述步骤的任意数量的移动后，字典上最小的字符串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "cba", k = 1
//输出："acb"
//解释：
//在第一步中，我们将第一个字符（“c”）移动到最后，获得字符串 “bac”。
//在第二步中，我们将第一个字符（“b”）移动到最后，获得最终结果 “acb”。
// 
//
// 示例 2： 
//
// 
//输入：s = "baaca", k = 3
//输出："aaabc"
//解释：
//在第一步中，我们将第一个字符（“b”）移动到最后，获得字符串 “aacab”。
//在第二步中，我们将第三个字符（“c”）移动到最后，获得最终结果 “aaabc”。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= S.length <= 1000 
// s 只由小写字母组成。 
// 
// 👍 65 👎 0


/**
 * 有序队列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-03 00:55:36 
 */
public class OrderlyQueueSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String orderlyQueue(String s, int k) {
        int n = s.length();
        char[] ch = s.toCharArray();
        if (k == 1) {
            // 相当于字符串轮转
            int i = 0, j = 1, l = 0;
            while (i < n && j < n && l < n) {
                char a = ch[(i + l) % n], b = ch[(j + l) % n];
                if (a == b) {
                    l++;
                    continue;
                }
                else if (a > b) i += l + 1;
                else j += l + 1;
                l = 0;
                if (i == j) i++;
            }
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);
        } else {
            // 相当于随意排列
            int[] f = new int[128];
            for (char c : ch) {
                f[c]++;
            }
            int i = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                while (f[c]-- > 0) {
                    ch[i++] = c;
                }
            }
            return new String(ch);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
