package Contest0807.T1;

/**
 * @author IronSid
 * @since 2022-08-07 10:24
 */
public class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int[] f = new int[201];
        int res = 0;
        for (int num : nums) {
            f[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur + diff * 2 < f.length && f[cur + diff] != 0 && f[cur + diff * 2] != 0) res++;
        }
        return res;
    }
}
