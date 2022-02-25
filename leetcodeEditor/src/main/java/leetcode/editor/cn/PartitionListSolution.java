package leetcode.editor.cn;

import java.util.*;

/**
 * 分隔链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-25 20:04:57
 */
public class PartitionListSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode(0, head);
        ListNode cur = preHead;
        ListNode greaterHead = new ListNode(), greater = greaterHead;
        while (cur != null && cur.next != null) {
            if (cur.next.val >= x) {
                greater.next = cur.next;
                greater = greater.next;
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        // 遍历结束后，将 greater 的 next 指针置空，这是因为当前节点复用的是原链表的节点，
        // 而其 next 指针可能指向一个小于 x 的节点，我们需要切断这个引用。
        greater.next = null;
        cur.next = greaterHead.next;
        return preHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
