package leetcode.editor.cn;

import java.util.*;

/**
 * 删除链表的节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-06 21:08:54
 */
public class ShanChuLianBiaoDeJieDianLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode prehead = new ListNode();
        prehead.next = head;
        ListNode cur = prehead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
        }
        return prehead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
