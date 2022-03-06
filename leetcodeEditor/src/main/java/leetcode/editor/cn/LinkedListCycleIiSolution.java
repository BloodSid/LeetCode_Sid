package leetcode.editor.cn;

import linkedList.ListNode;

/**
 * 环形链表 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-13 12:27:20
 */
public class LinkedListCycleIiSolution {
    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null) return null;
            if (head.next == null) return null;

            ListNode s = head;
            ListNode f = head;
            while (f != null && f.next != null) {
                s = s.next;
                f = f.next.next;
                if (s == f) break;
            }
            if (s == f) {
                f = head;
                while (s != f) {
                    s = s.next;
                    f = f.next;
                }
                return f;
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
