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
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            } else {
                headB = headB.next;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
