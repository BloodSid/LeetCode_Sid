package leetcode.editor.cn;

import java.util.*;

/**
 * 合并K个升序链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-29 12:29:56
 */
public class MergeKSortedListsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        for (int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        }
        return lists[0];
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode cur = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
