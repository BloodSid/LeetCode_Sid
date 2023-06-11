package leetcode.editor.cn;
//给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。 
//
// 删除完毕后，请你返回最终结果链表的头节点。 
//
// 
//
// 你可以返回任何满足题目要求的答案。 
//
// （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 
//
// 示例 1： 
//
// 输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
// 
//
// 示例 2： 
//
// 输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
// 
//
// 示例 3： 
//
// 输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 给你的链表中可能有 1 到 1000 个节点。 
// 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
// 
//
// 👍 236 👎 0


import linkedList.ListNode;

/**
 * 从链表中删去总和值为零的连续节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-06-11 12:13:11 
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedListSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode preHead = new ListNode(-1, head);
        for (ListNode cur = head, pre = preHead; cur != null; cur = cur.next) {
            int sum = 0;
            for (ListNode t = cur; t != null; t = t.next) {
                sum += t.val;
                if (sum == 0) {
                    pre.next = t.next;
                    // 删除后一段后，这个位置新的节点仍有可能被删除
                    cur = pre;
                    break;
                }
            }
            pre = cur;
        }
        return preHead.next;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
