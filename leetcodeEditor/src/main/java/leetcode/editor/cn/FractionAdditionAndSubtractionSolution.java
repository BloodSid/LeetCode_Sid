package leetcode.editor.cn;
//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。 
//
// 
//
// 示例 1: 
//
// 
//输入: expression = "-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入: expression = "1/3-1/2"
//输出: "-1/6"
// 
//
// 
//
// 提示: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
// 👍 71 👎 0


/**
 * 分数加减运算
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-27 00:51:07 
 */
public class FractionAdditionAndSubtractionSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionAddition(String expression) {
        int[][] fractions = new int[10][2];
        char[] ch = expression.toCharArray();
        boolean positive = true;
        int cur = 0;
        int p = 0;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] <= '9' && ch[i] >= '0') {
                cur = 10 * cur + ch[i] - '0';
                if (i == ch.length - 1 || ch[i + 1] < '0' || ch[i + 1] > '9') {
                    fractions[p / 2][p % 2] = positive ? cur : -cur;
                    p++;
                    cur = 0;
                    positive = true;
                }
            } else if (ch[i] == '-') {
                positive = false;
            }
        }
        int[] res = fractions[0];
        for (int i = 1; i < p / 2; i++) {
            res = add(res, fractions[i]);
        }
        return res[0] + "/" + res[1];
    }

    // 分数加法，分母为正数
    int[] add(int[] a, int[] b) {
        int[] res = {a[1] * b[0] + a[0] * b[1], a[1] * b[1]};
        int gcd = gcd(res[1], Math.abs(res[0]));
        res[0] /= gcd; res[1] /= gcd;
        return res;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
