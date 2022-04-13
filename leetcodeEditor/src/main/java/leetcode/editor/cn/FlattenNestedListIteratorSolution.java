package leetcode.editor.cn;

import java.util.*;

/**
 * 扁平化嵌套列表迭代器
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-13 23:35:19
 */
public class FlattenNestedListIteratorSolution {
//leetcode submit region begin(Prohibit modification and deletion)
public class NestedIterator implements Iterator<Integer> {

    Deque<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger cur = stack.pop();
            List<NestedInteger> list = cur.getList();
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }
        return !stack.isEmpty();
    }
}

//leetcode submit region end(Prohibit modification and deletion)
public interface NestedInteger {
    // return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
}
