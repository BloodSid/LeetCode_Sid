package leetcode.editor.cn;

import java.util.*;

/**
 * 反转链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-28 23:46:48 
 */
public class FanZhuanLianBiaoLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = null;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
