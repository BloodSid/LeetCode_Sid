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

    private int idx;
    private char[] val;

    public NestedInteger deserialize(String s) {
        idx = 0;
        val = s.toCharArray();
        if (val[0] != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }
        return getNested();
    }

    private NestedInteger getNested() {
        // 跳过一个左括号
        idx++;
        NestedInteger cur = new NestedInteger();
        for (int num = 0, sig = 1; idx < val.length; idx++) {
            char ch = val[idx];
            if (ch == '[') {
                cur.add(getNested());
            }
            else if (ch == ',') {
                continue;
            }
            else if (ch == ']') {
                return cur;
            }
            else if (ch == '-') {
                sig = -1;
            } else {
                num = num * 10 + sig * (ch & 15);
                if (val[idx + 1] == ',' || val[idx + 1] == ']') {
                    cur.add(new NestedInteger(num));
                    num = 0;
                    sig = 1;
                }
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
