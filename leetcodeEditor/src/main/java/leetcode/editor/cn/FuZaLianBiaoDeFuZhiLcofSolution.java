package leetcode.editor.cn;

import java.util.*;

/**
 * 复杂链表的复制
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-28 20:39:55
 */
public class FuZaLianBiaoDeFuZhiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 判断该节点是否已经创建副本。若不判断这一步，可能会导致死循环。
        if (!cachedNode.containsKey(head)) {
            Node newHead = new Node(head.val);
            cachedNode.put(head, newHead);
            newHead.next = copyRandomList(head.next);
            newHead.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}

//leetcode submit region end(Prohibit modification and deletion)
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
}
