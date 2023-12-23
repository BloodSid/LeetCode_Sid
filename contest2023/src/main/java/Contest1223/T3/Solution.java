package Contest1223.T3;

/**
 * @author IronSid
 * @since 2023-12-23 22:24
 */
public class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        int n = nums.length;
        int l1 = 0, l2 = n - 1;
        while (l1 < n - 1 && nums[l1] < nums[l1 + 1]) l1++;

        if (l1 == n - 1) {
            return (long) n * (n + 1) / 2;
        }
        while (l2 >= 1 && nums[l2 - 1] < nums[l2]) l2--;
        // 前缀可以组成结果，后缀可以组成结果，空数组可以组成结果。结果指移除后剩余的部分
        long res = l1 + 1 + n - l2 + 1;
        for (int i = 0, j = l2; i <= l1; i++) {
            while (j < n && nums[j] <= nums[i]) j++;
            res += n - j;
        }
        return res;
    }
}
