package leetcode.editor.cn;
//给定两个字符串 order 和 s 。order 的所有单词都是 唯一 的，并且以前按照一些自定义的顺序排序。 
//
// 对 s 的字符进行置换，使其与排序的 order 相匹配。更具体地说，如果在 order 中的字符 x 出现字符 y 之前，那么在排列后的字符串中， x 
//也应该出现在 y 之前。 
//
// 返回 满足这个性质的 s 的任意排列 。 
//
// 
//
// 示例 1: 
//
// 
//输入: order = "cba", s = "abcd"
//输出: "cbad"
//解释: 
//“a”、“b”、“c”是按顺序出现的，所以“a”、“b”、“c”的顺序应该是“c”、“b”、“a”。
//因为“d”不是按顺序出现的，所以它可以在返回的字符串中的任何位置。“dcba”、“cdba”、“cbda”也是有效的输出。 
//
// 示例 2: 
//
// 
//输入: order = "cbafg", s = "abcd"
//输出: "cbad"
// 
//
// 
//
// 提示: 
//
// 
// 1 <= order.length <= 26 
// 1 <= s.length <= 200 
// order 和 s 由小写英文字母组成 
// order 中的所有字符都 不同 
// 
// 👍 122 👎 0


import java.util.*;

/**
 * 自定义字符串排序
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-13 01:22:24 
 */
public class CustomSortStringSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String customSortString(String order, String s) {
        int[] p = new int[128];
        int k = 1;
        for (char c : order.toCharArray()) {
            p[c] = k++;
        }
        Character[] cs = new Character[s.length()];
        for (int i = 0; i < cs.length; i++) {
            cs[i] = s.charAt(i);
        }
        Arrays.sort(cs, (o1, o2) -> p[o1] - p[o2]);
        char[] ch = new char[cs.length];
        for (int i = 0; i < ch.length; i++) {
            ch[i] = cs[i];
        }
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
