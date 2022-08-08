package leetcode.editor.cn;
//特殊的二进制序列是具有以下两个性质的二进制序列： 
//
// 
// 0 的数量与 1 的数量相等。 
// 二进制序列的每一个前缀码中 1 的数量要大于等于 0 的数量。 
// 
//
// 给定一个特殊的二进制序列 S，以字符串形式表示。定义一个操作 为首先选择 S 的两个连续且非空的特殊的子串，然后将它们交换。（两个子串为连续的当且仅当第一
//个子串的最后一个字符恰好为第二个子串的第一个字符的前一个字符。) 
//
// 在任意次数的操作之后，交换后的字符串按照字典序排列的最大的结果是什么？ 
//
// 示例 1: 
//
// 
//输入: S = "11011000"
//输出: "11100100"
//解释:
//将子串 "10" （在S[1]出现） 和 "1100" （在S[3]出现）进行交换。
//这是在进行若干次操作后按字典序排列最大的结果。
// 
//
// 说明: 
//
// 
// S 的长度不超过 50。 
// S 保证为一个满足上述定义的特殊 的二进制序列。 
// 
// 👍 162 👎 0


import java.util.*;

/**
 * 特殊的二进制序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-08 17:41:11 
 */
public class SpecialBinaryStringSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;
        List<String> peaks = new ArrayList<>();
        int n = s.length();
        char[] ch = s.toCharArray();
        // '1' 代表上升，'0' 代表下降，找出当前串中所有山峰(两侧的山脚高度都是0)
        for (int i = 0, y = 0, start = 0; i < n; i++) {
            y += ch[i] == '1' ? 1 : -1;
            if (y == 0) {
                peaks.add(new String(ch, start, i - start + 1));
                start = i + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (peaks.size() == 1) {
            // 当前串自身就是一个山峰, 两侧山脚向内缩减一格的结果递归调用
            sb.append('1').append(makeLargestSpecial(new String(ch, 1, n - 2))).append('0');
        } else {
            // 当前串由很多山峰组成, 分别处理完每个山峰之后逆序排列所有的山峰，即组成结果
            for (int i = 0; i < peaks.size(); i++) {
                peaks.set(i, makeLargestSpecial(peaks.get(i)));
            }
            peaks.sort(Comparator.reverseOrder());
            for (String peak : peaks) {
                sb.append(peak);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
