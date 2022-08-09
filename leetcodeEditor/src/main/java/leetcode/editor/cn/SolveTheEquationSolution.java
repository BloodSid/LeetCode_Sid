package leetcode.editor.cn;
//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 如果方程中只有一个解，要保证返回值 'x' 是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
// 
// 👍 93 👎 0


/**
 * 求解方程
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-10 00:08:48 
 */
public class SolveTheEquationSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String solveEquation(String equation) {
        char[] ch = equation.toCharArray();
        // ax + b = 0;
        int a = 0, b = 0;
        int left = 1;
        int sig = 1;
        int n = ch.length, i = 0;
        while (i < n) {
            char cur = ch[i];
            if (cur == '+' || cur == '-') {
                sig = cur == '+' ? 1 : -1;
                i++;
            } else if (cur == '=') {
                left = -1;
                sig = 1;
                i++;
            } else {
                // 解析当前项是一次项还是常数项, 并解析出数值
                int num = 0;
                boolean hasX = false;
                if (cur == 'x') {
                    num = 1;
                    hasX = true;
                } else {
                    while (true) {
                        num *= 10;
                        num += ch[i] - '0';
                        if (i < n - 1 && ch[i + 1] >= '0' && ch[i + 1] <= '9') i++;
                        else break;
                    }
                    if (i < n - 1 && ch[i + 1] == 'x') {
                        hasX = true;
                        i++;
                    }
                }
                i++;
                if (hasX) a += num * sig * left;
                else b += num * sig * left;
            }
        }
        if (a == 0) {
            return b == 0 ? "Infinite solutions" : "No solution";
        }
        return "x=" + -b / a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
