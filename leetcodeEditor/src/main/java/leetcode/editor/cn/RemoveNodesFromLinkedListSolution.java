package leetcode.editor.cn;
//给你一个链表的头节点 head 。 
//
// 移除每个右侧有一个更大数值的节点。 
//
// 返回修改后链表的头节点 head 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [5,2,13,3,8]
//输出：[13,8]
//解释：需要移除的节点是 5 ，2 和 3 。
//- 节点 13 在节点 5 右侧。
//- 节点 13 在节点 2 右侧。
//- 节点 8 在节点 3 右侧。
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,1]
//输出：[1,1,1,1]
//解释：每个节点的值都是 1 ，所以没有需要移除的节点。
// 
//
// 
//
// 提示： 
//
// 
// 给定列表中的节点数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 
//
// 👍 67 👎 0


import linkedList.ListNode;

/**
 * 从链表中移除节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-01-03 11:11:46 
 */
public class RemoveNodesFromLinkedListSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode removeNodes(ListNode head) {
        if (head.next == null) {
            return head;
        }
        // 返回的链表头一定是最大的
        ListNode next = removeNodes(head.next);
        if (next.val > head.val) {
            // 删除 head;
            return next;
        }
        head.next = next;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
