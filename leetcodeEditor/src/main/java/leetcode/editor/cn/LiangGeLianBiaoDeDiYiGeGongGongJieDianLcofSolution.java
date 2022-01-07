package leetcode.editor.cn;

import java.util.*;

/**
 * 两个链表的第一个公共节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-08 00:55:33
 */
public class LiangGeLianBiaoDeDiYiGeGongGongJieDianLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
