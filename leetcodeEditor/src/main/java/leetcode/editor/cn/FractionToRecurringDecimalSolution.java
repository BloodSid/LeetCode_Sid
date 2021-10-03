package leetcode.editor.cn;
//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 104 。 
//
// denominator
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -231 <= numerator, denominator <= 231 - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 
// 👍 290 👎 0


import java.util.*;

/**
 * 分数到小数
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-03 15:50:54
 */
public class FractionToRecurringDecimalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 运算中可能会溢出，改用long接受入参
    public String fractionToDecimal(long numerator, long denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        // 判断结果正负
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append('-');
        }
        // 都转换成正数
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        sb.append(numerator / denominator);
        numerator %= denominator;
        if (numerator != 0) {
            sb.append('.');
            // 被除数到字符串下标的映射
            Map<Long, Integer> map = new HashMap<>();
            while (numerator != 0) {
                // 在除不尽的余数后添零做新的被除数
                numerator *= 10;
                // 商
                long quotient = numerator / denominator;
                // 出现重复的被除数说明成为无限循环小数
                if (map.containsKey(numerator)) {
                    sb.insert((int) map.get(numerator), '(');
                    sb.append(')');
                    break;
                } else {
                    map.put(numerator, sb.length());
                }
                // 余数
                numerator %= denominator;
                sb.append(quotient);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}
