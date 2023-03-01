package leetcode.editor.cn;
//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 
//
// 提示： 
//
// 
// 32位包括输出中的 "0." 这两位。 
// 题目保证输入用例的小数位数最多只有 6 位 
// 
// 👍 48 👎 0


/**
 * 二进制数转字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-02 02:23:13 
 */
public class BianryNumberToStringLcciSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String printBin(double num) {
        long l = Double.doubleToLongBits(num);
        // 1个符号位，11个指数位，52个尾数位，题目中都是正数，符号位都是0
        long significand = l << 12 >>> 12;
        // 尾数位最前有个 1
        significand |= 1L << 52;
        long exponent = (l >> 52) - 1023;
        // 指数位 -1 表示小数点后0个零，-2表示小数点后1个零
        StringBuilder sb = new StringBuilder("0.");
        for (int i = 0; i < -exponent - 1; i++) {
            sb.append('0');
        }
        sb.append(Long.toBinaryString(significand));
        int end = sb.lastIndexOf("1");
        String ans = sb.substring(0, end + 1);
        // 根据题意，如果这个数字可以精确表示，结果必然不会很长
        if (ans.length() > 32) return "ERROR";
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
