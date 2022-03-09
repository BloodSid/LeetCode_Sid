package leetcode.editor.cn;

import java.util.*;

/**
 * N 叉树的前序遍历
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-10 00:33:27 
 */
public class NAryTreePreorderTraversalSolution {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            list.add(cur.val);
            List<Node> children = cur.children;
            ListIterator<Node> iterator = children.listIterator(children.size());
            while (iterator.hasPrevious()) {
                stack.push(iterator.previous());
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
