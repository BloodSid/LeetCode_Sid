package leetcode.editor.cn;
//给你一个以字符串形式表述的 布尔表达式（boolean） expression，返回该式的运算结果。 
//
// 有效的表达式需遵循以下约定： 
//
// 
// "t"，运算结果为 True 
// "f"，运算结果为 False 
// "!(expr)"，运算过程为对内部表达式 expr 进行逻辑 非的运算（NOT） 
// "&(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 与的运算（AND） 
// "|(expr1,expr2,...)"，运算过程为对 2 个或以上内部表达式 expr1, expr2, ... 进行逻辑 或的运算（OR） 
// 
//
// 
//
// 示例 1： 
//
// 输入：expression = "!(f)"
//输出：true
// 
//
// 示例 2： 
//
// 输入：expression = "|(f,t)"
//输出：true
// 
//
// 示例 3： 
//
// 输入：expression = "&(t,f)"
//输出：false
// 
//
// 示例 4： 
//
// 输入：expression = "|(&(t,f,t),!(t))"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= expression.length <= 20000 
// expression[i] 由 {'(', ')', '&', '|', '!', 't', 'f', ','} 中的字符组成。 
// expression 是以上述形式给出的有效表达式，表示一个布尔值。 
// 
// 👍 65 👎 0


import java.util.*;

/**
 * 解析布尔表达式
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-11-05 00:11:29
 */
public class ParsingABooleanExpressionSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean parseBoolExpr(String expression) {
        char[] ch = expression.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        Deque<Character> operators = new ArrayDeque<>();
        for (int i = 0; i < ch.length; ) {
            switch (ch[i]) {
                case 't':
                case 'f':
                case '(':
                    // 入表达式栈
                    stack.push(ch[i++]);
                    break;
                case '|':
                case '&':
                case '!':
                    // 入操作符栈
                    operators.push(ch[i++]);
                    break;
                case ',':
                    // 跳过
                    i++;
                    break;
                case ')':
                    char op = operators.pop();
                    boolean b = stack.pop() == 't';
                    while (true) {
                        char cur = stack.pop();
                        // 当遇到右括号，循环出栈直到左括号。如果是 ! 运算，因为只对一个值运算，所以这里必跳出。
                        if (cur == '(') break;
                        if (op == '&') b &= cur == 't';
                        else if (op == '|') b |= cur == 't';
                    }
                    if (op == '!') stack.push(b ? 'f' : 't');
                    else stack.push(b ? 't' : 'f');
                    i++;
                    break;
            }
        }
        return stack.peek() == 't';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
