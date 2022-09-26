package leetcode.editor.cn;
//给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。 
//
// 示例 1： 
//
// 输入: s1 = "abc", s2 = "bca"
//输出: true 
// 
//
// 示例 2： 
//
// 输入: s1 = "abc", s2 = "bad"
//输出: false
// 
//
// 说明： 
//
// 
// 0 <= len(s1) <= 100 
// 0 <= len(s2) <= 100 
// 
// 👍 82 👎 0


/**
 * 判定是否互为字符重排
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-27 00:59:10 
 */
public class CheckPermutationLcciSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] f = new int[128];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (char c : c1) {
            f[c]++;
        }
        for (char c : c2) {
            f[c]--;
        }
        for (int i : f) {
            if (i != 0) return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
