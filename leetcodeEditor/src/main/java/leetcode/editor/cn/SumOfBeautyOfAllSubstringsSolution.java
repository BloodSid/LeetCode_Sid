package leetcode.editor.cn;
//一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。 
//
// 
// 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。 
// 
//
// 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabcb"
//输出：5
//解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。 
//
// 示例 2： 
//
// 
//输入：s = "aabcbaa"
//输出：17
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
// 👍 23 👎 0


/**
 * 所有子字符串美丽值之和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-12-12 00:05:20 
 */
public class SumOfBeautyOfAllSubstringsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int beautySum(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int sum = 0;
        int[] f;
        for (int i = 0; i < n; i++) {
            f = new int[26];
            for (int j = i; j >= 0; j--) {
                f[s[j] - 'a']++;
                int max = 0;
                int min = n;
                for (int fi : f) {
                    if (fi != 0) {
                        max = Math.max(max, fi);
                        min = Math.min(min, fi);
                    }
                }
                sum += max - min;
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
