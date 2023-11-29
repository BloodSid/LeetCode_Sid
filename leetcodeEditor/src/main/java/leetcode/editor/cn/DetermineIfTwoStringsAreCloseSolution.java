package leetcode.editor.cn;
//如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ： 
//
// 
// 操作 1：交换任意两个 现有 字符。 
// 
//
// 
// 例如，abcde -> aecdb 
// 
// 
// 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
// 
// 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ） 
// 
// 
//
//
// 你可以根据需要对任意一个字符串多次使用这两种操作。 
//
// 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：word1 = "abc", word2 = "bca"
//输出：true
//解释：2 次操作从 word1 获得 word2 。
//执行操作 1："abc" -> "acb"
//执行操作 1："acb" -> "bca"
// 
//
// 示例 2： 
//
// 
//输入：word1 = "a", word2 = "aa"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。 
//
// 示例 3： 
//
// 
//输入：word1 = "cabbba", word2 = "abbccc"
//输出：true
//解释：3 次操作从 word1 获得 word2 。
//执行操作 1："cabbba" -> "caabbb"
//执行操作 2："caabbb" -> "baaccc"
//执行操作 2："baaccc" -> "abbccc"
// 
//
// 示例 4： 
//
// 
//输入：word1 = "cabbba", word2 = "aabbss"
//输出：false
//解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。 
//
// 
//
// 提示： 
//
// 
// 1 <= word1.length, word2.length <= 10⁵ 
// word1 和 word2 仅包含小写英文字母 
// 
//
// 👍 80 👎 0


import java.util.*;

/**
 * 确定两个字符串是否接近
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-30 03:32:14 
 */
public class DetermineIfTwoStringsAreCloseSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] f1 = freq(word1.toCharArray());
        int[] f2 = freq(word2.toCharArray());
        // 出现的字符集必须一致
        for (int i = 0; i < f1.length; i++) {
            if ((f1[i] == 0) != (f2[i] == 0)) return false;
        }
        Arrays.sort(f1);
        Arrays.sort(f2);
        for (int i = 0; i < f1.length; i++) {
            // 词频数和词频数出现次数不一样则两个字符串不接近
            if (f1[i] != f2[i]) return false;
        }
        return true;
    }

    // 统计字母词频
    int[] freq(char[] ch) {
        int[] f = new int[128];
        for (char c : ch) {
            f[c]++;
        }
        return f;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
