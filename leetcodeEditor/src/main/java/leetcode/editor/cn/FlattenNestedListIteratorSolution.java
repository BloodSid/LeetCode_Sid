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

    Iterator<Integer> iterator;
    List<Integer> list;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            dfs(nestedInteger);
        }
        iterator = list.iterator();
    }

    void dfs(NestedInteger cur) {
        if (cur.isInteger()) {
            list.add(cur.getInteger());
            return;
        }
        for (NestedInteger nestedInteger : cur.getList()) {
            dfs(nestedInteger);
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
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
