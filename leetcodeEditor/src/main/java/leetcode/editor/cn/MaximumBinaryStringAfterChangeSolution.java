package leetcode.editor.cn;
//给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改： 
//
// 
// 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。 
// 
//
// 
// 比方说， "00010" -> "10010" 
// 
// 
// 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
// 
// 比方说， "00010" -> "00001" 
// 
// 
//
//
// 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制
//字符串 x 大于二进制字符串 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：binary = "000110"
//输出："111011"
//解释：一个可行的转换为：
//"000110" -> "000101" 
//"000101" -> "100101" 
//"100101" -> "110101" 
//"110101" -> "110011" 
//"110011" -> "111011"
// 
//
// 示例 2： 
//
// 
//输入：binary = "01"
//输出："01"
//解释："01" 没办法进行任何转换。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= binary.length <= 10⁵ 
// binary 仅包含 '0' 和 '1' 。 
// 
//
// 👍 62 👎 0


/**
 * 修改后的最大二进制字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-04-10 11:11:28 
 */
public class MaximumBinaryStringAfterChangeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String maximumBinaryString(String binary) {
        char[] ch = binary.toCharArray();
        int n = ch.length;
        // 把前缀是连续的1不变
        int m = 0;
        for (; m < n; m++) {
            if (ch[m] != '1') break;
        }
        // 把前缀之外的的1都通过操作2移动到最后，再把0通过操作一变成1，除了最后一个0
        int one = 0;
        for (int i = m; i < n; i++) {
            one += ch[i] & 1;
        }
        for (int i = 0; i < n - m; i++) {
            if (i == one) {
                ch[n - i - 1] = '0';
            } else {
                ch[n - i - 1] = '1';
            }
        }
        return new String(ch);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
