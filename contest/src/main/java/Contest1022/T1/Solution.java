package Contest1022.T1;

import linkedList.ListNode;

/**
 * @author IronSid
 * @since 2022-10-22 15:00
 */
public class Solution {
    public int numberEvenListNode(ListNode head) {
        if (head == null) return 0;
        return (head.val & 1) + numberEvenListNode(head.next);
    }
}
