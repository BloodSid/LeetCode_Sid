package leetcode.editor.cn;

import java.util.*;

/**
 * 合并两个有序链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-29 11:06:27
 */
public class MergeTwoSortedListsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l2.val < l1.val) {
            ListNode temp = l2;
            l2 = l1;
            l1 = temp;
        }
        ListNode ans = l1;
        ListNode cur = ans;
        l1 = l1.next;
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
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
