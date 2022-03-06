package leetcode.editor.cn;

import linkedList.ListNode;

/**
 * 删除链表中的节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-02 16:32:18 
 */
public class DeleteNodeInALinkedListSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
