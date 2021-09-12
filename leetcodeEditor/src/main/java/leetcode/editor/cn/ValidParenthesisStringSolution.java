package leetcode.editor.cn;
//给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则： 
//
// 
// 任何左括号 ( 必须有相应的右括号 )。 
// 任何右括号 ) 必须有相应的左括号 ( 。 
// 左括号 ( 必须在对应的右括号之前 )。 
// * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。 
// 一个空字符串也被视为有效字符串。 
// 
//
// 示例 1: 
//
// 
//输入: "()"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "(*)"
//输出: True
// 
//
// 示例 3: 
//
// 
//输入: "(*))"
//输出: True
// 
//
// 注意: 
//
// 
// 字符串大小将在 [1，100] 范围内。 
// 
// Related Topics 栈 贪心 字符串 动态规划 
// 👍 361 👎 0


import java.util.*;

/**
 * 有效的括号字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-09-12 21:41:53
 */
public class ValidParenthesisStringSolution {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkValidString(String s) {
            List<Integer> left = new LinkedList<>();
            List<Integer> star = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(':
                        left.add(0, i);
                        break;
                    case '*':
                        star.add(0, i);
                        break;
                    case ')':
                        if (!left.isEmpty()) {
                            left.remove(0);
                        } else if (!star.isEmpty()) {
                            star.remove(0);
                        } else {
                            return false;
                        }
                }
            }
            while ((!left.isEmpty()) && (!star.isEmpty()) && (left.get(0) < star.get(0))) {
                left.remove(0);
                star.remove(0);
            }
            return left.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
