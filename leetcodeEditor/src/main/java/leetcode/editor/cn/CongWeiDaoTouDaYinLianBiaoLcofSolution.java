package leetcode.editor.cn;

import linkedList.ListNode;

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
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            n++;
        }
        int[] ans = new int[n];
        cur = head;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = cur.val;
            cur = cur.next;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
