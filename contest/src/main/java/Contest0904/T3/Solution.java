package Contest0904.T3;

/**
 * @author IronSid
 * @since 2022-09-04 10:28
 */
public class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int res = 1;
        int[] f = new int[32];
        for (int i = 0, j = 0; i < n && j < n; i++) {
            while (j < n) {
                add(nums[j], f, 1);
                int k;
                for (k = 0; k < 32; k++) {
                    if (f[k] > 1) break;
                }
                if (k != 32) {
                    add(nums[j], f, -1);
                    break;
                }
                j++;
            }
            res = Math.max(res, j - i);
            add(nums[i], f, -1);
        }
        return res;
    }

    void add(int num, int[] f, int d) {
        for (int i = 0; num >> i != 0; i++) {
            if ((num >> i & 1) == 1) f[i] += d;
        }
    }
}
