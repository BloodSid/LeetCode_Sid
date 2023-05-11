package leetcode.editor.cn;
//给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 
//false 。 
//
// 子字符串 是字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0110", n = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "0110", n = 4
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 不是 '0' 就是 '1' 
// 1 <= n <= 10⁹ 
// 
//
// 👍 101 👎 0


import java.util.HashSet;

/**
 * 子串能表示从 1 到 N 数字的二进制串
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-11 18:21:53 
 */
public class BinaryStringWithSubstringsRepresenting1ToNSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean queryString(String s, int n) {
        int m = 0;
        while (n >> m != 0) m++;
        char[] c = s.toCharArray();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < c.length; i++) {
            int t = 0;
            for (int j = 0; j < m && j <= i; j++) {
                t |= (c[i - j] & 1) << j;
                if (t >= 1 && t <= n) set.add(t);
                if (t > n) break;
            }
            if (set.size() == n) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
