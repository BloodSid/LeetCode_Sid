package leetcode.editor.cn;
//有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。 
//
// 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。 
//
// 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[
//j]。 
//
// 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：s1 = "xx", s2 = "yy"
//输出：1
//解释：
//交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。 
//
// 示例 2： 
//
// 输入：s1 = "xy", s2 = "yx"
//输出：2
//解释：
//交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
//交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
//注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。 
//
// 示例 3： 
//
// 输入：s1 = "xx", s2 = "xy"
//输出：-1
// 
//
// 示例 4： 
//
// 输入：s1 = "xxyyxyxyxx", s2 = "xyyxyxxxyx"
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 1000 
// s1, s2 只包含 'x' 或 'y'。 
// 
//
// 👍 124 👎 0


/**
 * 交换字符使得字符串相同
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-02-25 14:51:55 
 */
public class MinimumSwapsToMakeStringsEqualSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumSwap(String s1, String s2) {
        int n = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        // 统计两个字符串同一个位置上 xy, yx 的情况数量
        int t1 = 0, t2 = 0;
        int cx = 0, cy = 0;
        for (int i = 0; i < n; i++) {
            int t = c1[i] - 'x' + c2[i] - 'x';
            cx += 2 - t;
            cy += t;
            if (c1[i] == 'x' && c2[i] == 'y') t1++;
            if (c1[i] == 'y' && c2[i] == 'x') t2++;
        }
        // x 或 y 的总数为奇数，都无法相同
        if (cx % 2 == 1 || cy % 2 == 1) return -1;
        // 贪心地分别在 t1 和 t2 内部两两交换剩。最后一对 xy 和 yx 最少需要 2步
        int extra = 0;
        if (t1 % 2 == 1 && t2 % 2 == 1) extra = 2;
        return t1 / 2 + t2 / 2 + extra;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
