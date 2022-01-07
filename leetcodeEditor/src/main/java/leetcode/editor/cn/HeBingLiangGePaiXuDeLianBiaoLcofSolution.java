package leetcode.editor.cn;

import java.util.*;

/**
 * 合并两个排序的链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-08 00:46:04
 */
public class HeBingLiangGePaiXuDeLianBiaoLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode();
        ListNode cur = preHead;
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
        return preHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
