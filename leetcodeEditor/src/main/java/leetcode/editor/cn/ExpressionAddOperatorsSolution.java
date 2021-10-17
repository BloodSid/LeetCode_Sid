package leetcode.editor.cn;
//给定一个仅包含数字 0-9 的字符串 num 和一个目标值整数 target ，在 num 的数字之间添加 二元 运算符（不是一元）+、- 或 * ，返回所
//有能够得到目标值的表达式。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = "123", target = 6
//输出: ["1+2+3", "1*2*3"] 
// 
//
// 示例 2: 
//
// 
//输入: num = "232", target = 8
//输出: ["2*3+2", "2+3*2"] 
//
// 示例 3: 
//
// 
//输入: num = "105", target = 5
//输出: ["1*0+5","10-5"] 
//
// 示例 4: 
//
// 
//输入: num = "00", target = 0
//输出: ["0+0", "0-0", "0*0"]
// 
//
// 示例 5: 
//
// 
//输入: num = "3456237490", target = 9191
//输出: [] 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 10 
// num 仅含数字 
// -231 <= target <= 231 - 1 
// 
// Related Topics 数学 字符串 回溯 
// 👍 253 👎 0


import java.util.*;

/**
 * 给表达式添加运算符
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-16 00:00:18
 */
public class ExpressionAddOperatorsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String num;
    int target;
    List<String> ans;
    String[] operators;

    public List<String> addOperators(String num, int target) {
        this.num = num;
        this.target = target;
        this.ans = new ArrayList<>();

        long source = Long.parseLong(num);
        if (!num.startsWith("0") && source <= target) {
            if (source == target) {
                ans.add(num);
            }
            return ans;
        }

        if (num.length() == 1) {
            return ans;
        }
        operators = new String[num.length() - 1];
        dfs(0, operators);
        return ans;
    }

    String[] operatorSet = {null, "+", "-", "*"};
    StringBuilder sb;

    void dfs(int index, String[] operators) {
        if (index > 0 && operators[index - 1] != null) {
            List<String> exp = getExp(operators);
            if (isLegal(exp)) {
                long result = calculateResult(exp);
                if (result == target) {
                    sb = new StringBuilder();
                    for (String e : exp) {
                        sb.append(e);
                    }
                    ans.add(sb.toString());
                }
            }
        }
        if (index == operators.length) {
            return;
        }
        for (String o1 : operatorSet) {
            operators[index] = o1;
            dfs(index + 1, operators);
        }
        operators[index] = null;
    }

    long calculateResult(List<String> exp) {
        Deque<Long> list = new ArrayDeque<>();
        list.offerLast(Long.parseLong(exp.get(0)));
        for (int i = 1; i < exp.size(); i += 2) {
            String operator = exp.get(i);
            long number = Long.parseLong(exp.get(i + 1));
            if (operator == "*") {
                list.offerLast(list.pollLast() * number);
            } else if (operator == "+") {
                list.offerLast(number);
            } else {
                list.offerLast(-number);
            }
        }
        long result = 0;
        for (Long aLong : list) {
            result += aLong;
        }
        return result;
    }

    boolean isLegal(List<String> exp) {
        for (String e : exp) {
            if (e.startsWith("0") && e.length() != 1) {
                return false;
            }
        }
        return true;
    }

    List<String> getExp(String[] operators) {
        List<String> exp = new LinkedList<>();
        int pre = -1;
        for (int cur = 0; cur < operators.length; cur++) {
            if (operators[cur] != null) {
                exp.add(num.substring(pre + 1, cur + 1));
                exp.add(operators[cur]);
                pre = cur;
            }
        }
        exp.add(num.substring(pre + 1));
        return exp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
