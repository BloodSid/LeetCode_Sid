package leetcode.editor.cn;

import java.util.*;

/**
 * 移除链表元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-02 17:57:02
 */
public class RemoveLinkedListElementsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
