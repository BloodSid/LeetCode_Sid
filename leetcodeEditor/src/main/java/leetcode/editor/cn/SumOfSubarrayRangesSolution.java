package leetcode.editor.cn;

import java.util.*;

/**
 * 子数组范围和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-04 15:14:03
 */
public class SumOfSubarrayRangesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long subArrayRanges(int[] nums) {
        long res = 0;
        int n = nums.length;
        int[] minRight = new int[n];
        int[] minLeft = new int[n];
        int[] maxRight = new int[n];
        int[] maxLeft = new int[n];
        // 栈底最小
        Deque<Integer> minStack = new LinkedList<>();
        // 栈底最大
        Deque<Integer> maxStack = new LinkedList<>();
        // 若数组中两个元素相等，比如nums[i] == nums[j] 则这两个元素的大小由i和j的大小决定
        // 所以从前向后和从后向前分别遍历数组的时候，比较当前元素和栈顶元素的操作符是不同的
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            while (!minStack.isEmpty() && nums[minStack.peek()] > cur) {
                minStack.pop();
            }
            minLeft[i] = minStack.isEmpty() ? -1 : minStack.peek();
            minStack.push(i);
            while (!maxStack.isEmpty() && nums[maxStack.peek()] <= cur) {
                maxStack.pop();
            }
            maxLeft[i] = maxStack.isEmpty() ? -1 : maxStack.peek();
            maxStack.push(i);
        }
        minStack.clear();
        maxStack.clear();
        for (int i = n - 1; i >= 0; i--) {
            int cur = nums[i];
            while (!minStack.isEmpty() && nums[minStack.peek()] >= cur) {
                minStack.pop();
            }
            minRight[i] = minStack.isEmpty() ? n : minStack.peek();
            minStack.push(i);
            while (!maxStack.isEmpty() && nums[maxStack.peek()] < cur) {
                maxStack.pop();
            }
            maxRight[i] = maxStack.isEmpty() ? n : maxStack.peek();
            maxStack.push(i);
        }
        // res = sumMax - sumMin, 下面的循环相当于于分别求出这两个和并相减
        for (int i = 0; i < n; i++) {
            // 所有以nums[i]为最小值的子数组的个数等于可能的左边界数量乘可能的右边界数量
            res += (long) (i - maxLeft[i]) * (maxRight[i] - i) * nums[i];
            res -= (long) (i - minLeft[i]) * (minRight[i] - i) * nums[i];
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
