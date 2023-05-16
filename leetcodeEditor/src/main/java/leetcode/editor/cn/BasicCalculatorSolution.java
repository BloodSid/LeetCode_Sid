package leetcode.editor.cn;
//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "1 + 1"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s = " 2-1 + 2 "
//输出：3
// 
//
// 示例 3： 
//
// 
//输入：s = "(1+(4+5+2)-3)+(6+8)"
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由数字、'+'、'-'、'('、')'、和 ' ' 组成 
// s 表示一个有效的表达式 
// '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效) 
// '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的) 
// 输入中不存在两个连续的操作符 
// 每个数字和运行的计算将适合于一个有符号的 32位 整数 
// 
//
// 👍 908 👎 0


import java.util.*;

/**
 * 基本计算器
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-17 00:46:25 
 */
public class BasicCalculatorSolution {
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
        for (int i = 0; i < ch.length; ) {
            char c = ch[i];
            if (c == ' ') {
                // 跳过空格
                i++;
                continue;
            }
            if (c == '(') {
                ops.push('(');
                i++;
            } else if (c == ')') {
                // 逢右括号计算到左括号为止
                while (!ops.isEmpty() && ops.peek() != '(') calc();
                ops.pop();
                i++;
            } else if (c >= '0' && c <= '9') {
                // 数字
                int num = c & 15;
                int j = i + 1;
                for (; j < ch.length; j++) {
                    if (ch[j] < '0' || ch[j] > '9') break;
                    num = num * 10 + (ch[j] & 15);
                }
                i = j;
                nums.push(num);
            } else {
                // 防止括号内第一个数是负数
                if (pre == '(') nums.push(0);
                // 操作符入栈前，把栈中优先级更高或相等的先计算了
                while (!ops.isEmpty() && priority[ops.peek()] >= priority[c]) calc();
                ops.push(c);
                i++;
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
