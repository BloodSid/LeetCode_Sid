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
        int b = 1_000_000;
        int a = (int) (b * num);
        // 约分
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        // 约分后的分母必须是2的幂
        if (Integer.bitCount(b) != 1) {
            return "ERROR";
        }
        // 分母的是2的几次幂，小数就有几位
        int fraction = 1;
        while (1 << fraction != b) fraction++;
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(a));
        while (sb.length() < fraction) {
            sb.insert(0, '0');
        }
        return "0." + sb;
    }

    int gcd(int a, int b) {
        // gcd(a, b) = gcd(b, a mod b)
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
