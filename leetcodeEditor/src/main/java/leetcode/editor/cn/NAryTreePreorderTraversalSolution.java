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
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        dfs(root);
        return list;
    }

    void dfs(Node node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        for (Node child : node.children) {
            dfs(child);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
