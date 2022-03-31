package leetcode.editor.cn;

/**
 * 缺失的第一个正数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-28 23:12:47 
 */
public class FirstMissingPositiveSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置然后再遍历一次数组查当前下标是否和值对应，如果不对
    应那这个下标就是答案， 否则遍历完都没出现那么答案就是数组长度加1。
    */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] < n && nums[i] != nums[nums[i]]) {
                int t = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = t;
            }
        }
        for (int i = 1; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums[0] == n ? n + 1 : n;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
