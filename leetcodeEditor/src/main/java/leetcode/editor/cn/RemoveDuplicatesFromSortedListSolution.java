package leetcode.editor.cn;

import linkedList.ListNode;

/**
 * 删除排序链表中的重复元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-01 11:02:07 
 */
public class RemoveDuplicatesFromSortedListSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
