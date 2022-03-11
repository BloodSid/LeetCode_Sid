package leetcode.editor.cn;

import java.util.*;

/**
 * N 叉树的后序遍历
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-12 00:13:40 
 */
public class NAryTreePostorderTraversalSolution {
// Definition for a Node.
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
    private List<Integer> list;

    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        dfs(root);
        return list;
    }

    void dfs(Node node) {
        if (node == null) return;
        if (node.children != null) {
            for (Node child : node.children) {
                dfs(child);
            }
        }
        list.add(node.val);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
