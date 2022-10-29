package leetcode.editor.cn;
//给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。 
//
// 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
// 
//
// 示例 2: 
//
// 
//输入: s = "3z4"
//输出: ["3z4","3Z4"]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 12 
// s 由小写英文字母、大写英文字母和数字组成 
// 
// 👍 425 👎 0


import java.util.*;

/**
 * 字母大小写全排列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-30 00:35:53 
 */
public class LetterCasePermutationSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    ArrayList list = new ArrayList();
    char[] c;
    public List<String> letterCasePermutation(String s) {
        c = s.toLowerCase().toCharArray();
        dfs(0);
        return list;
    }

    void dfs(int i) {
        if (i == c.length) {
            list.add(new String(c));
            return;
        }
        if (c[i] >= 'a' && c[i] <= 'z') {
            dfs(i + 1);
            c[i] -= 32;
            dfs(i + 1);
            c[i] += 32;
        } else {
            dfs(i + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
