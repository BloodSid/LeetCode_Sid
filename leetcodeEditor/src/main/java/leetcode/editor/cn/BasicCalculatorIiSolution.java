package leetcode.editor.cn;
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
//
// 👍 696 👎 0


import java.util.*;

/**
 * 基本计算器 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-17 00:46:22 
 */
public class BasicCalculatorIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static int[] priority = new int[128];
    static {
        priority['+'] = 1;
        priority['-'] = 1;
        priority['*'] = 2;
        priority['/'] = 2;
        priority['%'] = 2;
        priority['^'] = 2;
    }

    private Deque<Integer> nums;
    private Deque<Character> ops;

    public int calculate(String s) {
        nums = new ArrayDeque<>();
        ops = new ArrayDeque<>();
        // 防止第一个数是负数
        nums.push(0);
        // 用 pre 记录非空格的上一个字符
        char pre = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == ' ') {
                // 跳过空格
                continue;
            }
            if (c == '(') {
                ops.push('(');
            } else if (c == ')') {
                // 逢右括号计算到左括号为止
                while (!ops.isEmpty() && ops.peek() != '(') calc();
                ops.pop();
            } else if (c >= '0' && c <= '9') {
                // 数字
                int num = c & 15;
                int j = i + 1;
                for (; j < ch.length; j++) {
                    if (ch[j] < '0' || ch[j] > '9') break;
                    num = num * 10 + (ch[j] & 15);
                }
                i = j - 1;
                nums.push(num);
            } else {
                // 防止括号内第一个数是负数
                if (pre == '(') nums.push(0);
                // 操作符入栈前，把栈顶优先级相等或更高的先计算掉
                while (!ops.isEmpty() && priority[ops.peek()] >= priority[c]) calc();
                ops.push(c);
            }
            pre = c;
        }
        while (!ops.isEmpty()) calc();
        return nums.peek();
    }

    void calc() {
        int b = nums.pop();
        int a = nums.pop();
        int res;
        char op = ops.pop();
        if (op == '+') res = a + b;
        else if (op == '-') res = a - b;
        else if (op == '*') res = a * b;
        else if (op == '/') res = a / b;
        else if (op == '%') res = a % b;
        else if (op == '^') res = (int) Math.pow(a, b);
        else res = 0;
        nums.push(res);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
