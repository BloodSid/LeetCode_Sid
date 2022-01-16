package leetcode.editor.cn;

import java.util.*;

/**
 * 链表随机节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-16 09:49:42
 */
public class LinkedListRandomNodeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Random r;
    ListNode head;

    public Solution(ListNode head) {
        r = new Random();
        this.head = head;
    }

    public int getRandom() {
        int index = 1; int ans = 0;
        for (ListNode node = head; node != null; node = node.next) {
            if (r.nextInt(index) == 0) {
                ans = node.val;
            }
            index++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
