package leetcode.editor.cn;

import linkedList.ListNode;

/**
 * 删除排序链表中的重复元素 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-14 11:07:02
 */
public class RemoveDuplicatesFromSortedListIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-200, head);
        ListNode p1 = pre;
        while (p1 != null) {
            while (p1.next != null && p1.next.next != null && p1.next.val == p1.next.next.val) {
                int dup = p1.next.val;
                ListNode p2 = p1.next.next;
                while (p2 != null && p2.val == dup) {
                    p2 = p2.next;
                }
                p1.next = p2;
            }
            p1 = p1.next;
        }
        return pre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
