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
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Integer> map = new HashMap<>();
        int index = 0;
        while (cur != null) {
            map.put(cur, index);
            index++;
            cur = cur.next;
        }
        int n = map.size();
        int[] vals = new int[n];
        int[] randoms = new int[n];
        cur = head;
        for (int i = 0; i < n; i++) {
            vals[i] = cur.val;
            randoms[i] = cur.random == null ? -1 : map.get(cur.random);
            cur = cur.next;
        }
        Node[] arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node(vals[i]);
        }
        for (int i = 0; i < n; i++) {
            arr[i].next = i == n - 1 ? null : arr[i + 1];
            arr[i].random = randoms[i] == -1 ? null : arr[randoms[i]];
        }
        return arr[0];
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
