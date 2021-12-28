package leetcode.editor.cn;

import java.util.*;

/**
 * 从尾到头打印链表
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-28 20:39:20
 */
public class CongWeiDaoTouDaYinLianBiaoLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
