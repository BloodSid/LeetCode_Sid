package leetcode.editor.cn;

import java.util.*;

/**
 * 环形链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-02 17:51:36
 */
public class LinkedListCycleSolution {
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
