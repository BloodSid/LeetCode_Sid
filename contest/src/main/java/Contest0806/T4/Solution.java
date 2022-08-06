package Contest0806.T4;

/**
 * @author IronSid
 * @since 2022-08-06 19:16
 */
public class Solution {
    public long minimumReplacement(int[] nums) {
        long res = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int next = nums[i + 1];
            int cur = nums[i];
            if (cur <= next) continue;
            // 贪心地把 nums[i] 通过 op 次操作分开，使得其中的每一部分都小于等于 nums[i + 1]
            int op = (cur - 1) / next;
            res += op;
            // 把 nums[i] 分成尽量接近的 (op + 1) 个数字
            nums[i] = nums[i] / (op + 1);
        }
        return res;
    }
}
