package leetcode.editor.cn;
//给定一个长度为 n 的链表 head 
//
// 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点
//，设置 answer[i] = 0 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [2,1,5]
//输出：[5,5,0]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：head = [2,7,4,3,5]
//输出：[7,0,5,5,0]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为 n 
// 1 <= n <= 10⁴ 
// 1 <= Node.val <= 10⁹ 
// 
//
// 👍 242 👎 0


import linkedList.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 链表中的下一个更大节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-04-10 01:39:29 
 */
public class NextGreaterNodeInLinkedListSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        // {i, v} 单调栈，栈顶最小
        Deque<int[]> stack = new ArrayDeque<>();
        int i = 0;
        for (ListNode cur = head; cur != null; cur = cur.next, i++, list.add(0)) {
            while (!stack.isEmpty() && stack.peek()[1] < cur.val) {
                list.set(stack.pop()[0], cur.val);
            }
            stack.push(new int[]{i, cur.val});
        }
        int[] res = new int[list.size()];
        for (int p = 0; p < res.length; p++) res[p] = list.get(p);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
