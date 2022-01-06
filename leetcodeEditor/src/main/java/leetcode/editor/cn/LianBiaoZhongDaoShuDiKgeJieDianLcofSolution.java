package leetcode.editor.cn;

import java.util.*;

/**
 * 链表中倒数第k个节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-06 21:08:56
 */
public class LianBiaoZhongDaoShuDiKgeJieDianLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
