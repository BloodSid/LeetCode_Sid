package leetcode.editor.cn;

import java.util.*;

/**
 * 反转链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-28 20:39:41
 */
public class UHnkqhSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
