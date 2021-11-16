package leetcode.editor.cn;

import java.util.*;

/**
 * 反转链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-16 13:44:49
 */
public class ReverseLinkedListSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 递归的意思：我子节点下的所有节点都已经反转好了
        ListNode newHead = reverseList(head.next);
        // 现在就剩我和我的子节点 没有完成最后的反转了，所以反转一下我和我的子节点。
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
