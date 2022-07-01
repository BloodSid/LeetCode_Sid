package leetcode.editor.cn;
//给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。 
//
// 生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：expression = "2-1-1"
//输出：[0,2]
//解释：
//((2-1)-1) = 0 
//(2-(1-1)) = 2
// 
//
// 示例 2： 
//
// 
//输入：expression = "2*3-4*5"
//输出：[-34,-14,-10,-10,10]
//解释：
//(2*(3-(4*5))) = -34 
//((2*3)-(4*5)) = -14 
//((2*(3-4))*5) = -10 
//(2*((3-4)*5)) = -10 
//(((2*3)-4)*5) = 10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20 
// expression 由数字和算符 '+'、'-' 和 '*' 组成。 
// 输入表达式中的所有整数值在范围 [0, 99] 
// 
// 👍 584 👎 0


import java.util.*;

/**
 * 为运算表达式设计优先级
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-01 00:00:43 
 */
public class DifferentWaysToAddParenthesesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private char[] ch;

    public List<Integer> diffWaysToCompute(String expression) {
        ch = expression.toCharArray();
        return dfs(0, ch.length - 1);
    }

    List<Integer> dfs(int l, int r) {
        List<Integer> res = new ArrayList<>();
        if (r - l <= 1) {
            res.add(r == l ? ch[l] - '0' : (ch[l] - '0') * 10 + ch[r] - '0');
            return res;
        }
        for (int i = l; i <= r; i++) {
            if (ch[i] <= '9' && ch[i] >= '0') continue;
            List<Integer> left = dfs(l, i - 1);
            List<Integer> right = dfs(i + 1, r);
            for (Integer i1 : left) {
                for (Integer i2 : right) {
                    int val;
                    if (ch[i] == '+') {
                        val = i1 + i2;
                    } else if (ch[i] == '-') {
                        val = i1 - i2;
                    } else {
                        val = i1 * i2;
                    }
                    res.add(val);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
