package leetcode.editor.cn;
//给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。 
//
// 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：5
//解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：15
//解释：仅由元音组成的 15 个字典序字符串为
//["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
//注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
// 
//
// 示例 3： 
//
// 
//输入：n = 33
//输出：66045
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 
// 👍 79 👎 0


import java.util.Arrays;

/**
 * 统计字典序元音字符串的数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-29 00:11:12 
 */
public class CountSortedVowelStringsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countVowelStrings(int n) {
        int[] f = new int[5];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            f[4] = f[0] + f[1] + f[2] + f[3] + f[4];
            f[3] = f[0] + f[1] + f[2] + f[3];
            f[2] = f[0] + f[1] + f[2];
            f[1] = f[0] + f[1];
        }
        int sum = 0;
        for (int i = 0; i < f.length; i++) {
            sum += f[i];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
