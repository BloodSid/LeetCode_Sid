package leetcode.editor.cn;

import java.util.*;

/**
 * 移除链表元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-02 17:57:02
 */
public class RemoveLinkedListElementsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode cur = preHead;
        while (cur != null) {
            while (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return preHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
