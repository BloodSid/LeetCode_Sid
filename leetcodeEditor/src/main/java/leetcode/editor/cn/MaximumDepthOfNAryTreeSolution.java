package leetcode.editor.cn;

import java.util.*;

/**
 * N 叉树的最大深度
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-21 17:52:45
 */
public class MaximumDepthOfNAryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Deque<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if (cur.children != null) {
                    queue.addAll(cur.children);
                }
            }
            depth++;
        }
        return depth;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
