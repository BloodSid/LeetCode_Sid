package leetcode.editor.cn;

import java.util.*;

/**
 * 迷你语法分析器
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-15 02:14:42
 */
public class MiniParserSolution {

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {
    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return null;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni) {
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private char[] val;
    private Deque<NestedInteger> stack;

    public NestedInteger deserialize(String s) {
        val = s.toCharArray();
        stack = new ArrayDeque<>();
        NestedInteger cur = null;
        for (int i = 0; i < val.length; ) {
            switch (val[i]) {
                case ('['):
                    NestedInteger newList = new NestedInteger();
                    stack.push(newList);
                    i++;
                    break;
                case (']'):
                    cur = stack.pop();
                    if (!stack.isEmpty()) stack.peek().add(cur);
                    i++;
                    break;
                case (','):
                    i++;
                    break;
                default:
                    // 负号和数字
                    int num = 0;
                    boolean negative = false;
                    if (val[i] == '-') {
                        negative = true;
                        i++;
                    }
                    for (; i < val.length && Character.isDigit(val[i]); i++) {
                        num *= 10;
                        num += val[i] & 15;
                    }
                    if (negative) num = -num;
                    if (stack.isEmpty())
                        return new NestedInteger(num);
                    else
                        stack.peek().add(new NestedInteger(num));
            }
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
