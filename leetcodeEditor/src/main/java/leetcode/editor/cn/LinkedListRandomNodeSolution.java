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
    Random r = new Random();
    Integer[] values;

    public Solution(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        values = list.toArray(new Integer[0]);
    }

    public int getRandom() {
        return values[r.nextInt(values.length)];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
