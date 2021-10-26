package leetcode.editor.cn;

import java.util.*;

/**
 * 下一个更大元素 I
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-26 21:50:54
 */
public class NextGreaterElementISolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] hash = new int[10001];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peekFirst() < num) {
                int temp = stack.pollFirst();
                hash[temp] = num;
            }
            stack.offerFirst(num);
        }
        while (!stack.isEmpty()) {
            hash[stack.pollFirst()] = -1;
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = hash[nums1[i]];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
