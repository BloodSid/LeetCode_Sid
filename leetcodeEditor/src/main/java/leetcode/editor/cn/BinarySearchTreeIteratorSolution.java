package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉搜索树迭代器
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-20 18:31:53
 */
public class BinarySearchTreeIteratorSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class BSTIterator {
    List<Integer> list;
    Iterator<Integer> iterator;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        dfs(root);
        iterator = list.iterator();
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public int next() {
        return iterator.next();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
