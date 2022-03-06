package leetcode.editor.cn;

import linkedList.ListNode;

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
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        head.next = deleteNode(head.next, val);
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
