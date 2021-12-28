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
        ListNode pre = null;
        while (head != null) {
            ListNode t = head;
            head = head.next;
            t.next = pre;
            pre = t;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
