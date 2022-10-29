package Contest1029.T4;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-10-29 22:27
 */
public class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        // 记录下一个更大元素的位置
        int[] next = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            int cur = nums[i];
            while (!stack.isEmpty() && nums[stack.peek()] <= cur) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        // 记录下两个更大元素
        int[] next2 = new int[n];
        // 储存元素的位置，依次元素的大小顺序，元素的位置逆序排列
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> nums[o1] == nums[o2] ? o2 - o1 : nums[o1] - nums[o2]);
        List<Integer> rm = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rm.clear();
            for (Integer pre : set.headSet(i)) {
                if (next[pre] != i) {
                    next2[pre] = nums[i];
                    rm.add(pre);
                }
            }
            rm.forEach(set::remove);
            set.add(i);
        }
        for (Integer pre : set) {
            next2[pre] = -1;
        }
        return next2;
    }
}
