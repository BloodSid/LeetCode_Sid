package Contest1029.T4;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-10-29 22:27
 */
public class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        // 记录下两个更大元素的位置
        int[] next = new int[n];
        Deque<Integer> t = new ArrayDeque<>();
        Deque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            while (!s.isEmpty() && nums[s.peek()] < cur) {
                next[s.pop()] = cur;
            }
            List<Integer> temp = new ArrayList<>();
            while (!t.isEmpty() && nums[t.peek()] < cur) {
                temp.add(t.pop());
            }
            t.push(i);
            // 把 t 中一次出栈的元素保持原有顺序加入 s
            for (int j = temp.size() - 1; j >= 0; j--) {
                s.push(temp.get(j));
            }
        }
        for (Integer i : t) next[i] = -1;
        for (Integer i : s) next[i] = -1;
        return next;
    }
}
