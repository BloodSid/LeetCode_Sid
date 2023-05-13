package Contest0513.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2023-05-13 22:29
 */
public class Solution {

    public static final int M = (int) (1e9 + 7);

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long res = 0;
        // 表示当前位置之前所有的子序列的最小值之和
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            long sq = (long) nums[i] * nums[i] % M;
            res = (res + ((sum + nums[i]) * sq % M)) % M;
            // 所有之前的子序列选或不选当前元素构成 sum * k, 再加上 {ni} 这一子序列的最小值 ni
            sum = (sum * 2 + nums[i]) % M;
        }
        return (int) res;
    }
}
