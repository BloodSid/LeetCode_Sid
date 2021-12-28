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
        int n = 0;
        ListNode cur = null;
        ListNode pre = head;
        while (pre != null) {
            ListNode t = pre.next;
            pre.next = cur;
            cur = pre;
            pre = t;
            n++;
        }
        int[] ans = new int[n];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = cur.val;
            cur = cur.next;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
