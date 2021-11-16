package leetcode.editor.cn;

import java.util.*;

/**
 * K 个一组翻转链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-16 00:45:07
 */
public class ReverseNodesInKGroupSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode nextGroup = head;
        for (int i = 0; i < k; i++) {
            if (nextGroup == null) {
                return head;
            }
            nextGroup = nextGroup.next;
        }
        ListNode pre = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = reverseKGroup(nextGroup, k);
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
