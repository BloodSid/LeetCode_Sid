package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉搜索树与双向链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-10 09:42:42
 */
public class ErChaSouSuoShuYuShuangXiangLianBiaoLcofSolution {
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Deque<Node> stack = new ArrayDeque<>();
        Node head = null;
        Node pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (head == null) {
                head = root;
            } else {
                pre.right = root;
                root.left = pre;
            }
            pre = root;
            root = root.right;
        }
        pre.right = head;
        head.left = pre;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
