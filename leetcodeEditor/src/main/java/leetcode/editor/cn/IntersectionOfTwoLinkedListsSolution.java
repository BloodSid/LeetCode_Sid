package leetcode.editor.cn;

import linkedList.ListNode;

/**
 * 相交链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-14 10:47:40
 */
public class IntersectionOfTwoLinkedListsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
