package leetcode.editor.cn;

import java.util.*;

/**
 * 反转链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-16 13:44:49
 */
public class ReverseLinkedListSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
