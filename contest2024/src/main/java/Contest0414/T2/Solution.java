package Contest0414.T2;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2024-04-14 10:27
 */
public class Solution {
    static int M = 100;
    static boolean[] prime = new boolean[M + 1];
    static {
        Arrays.fill(prime, 2, M + 1, true);
        for (int i = 2; i <= M; i++) {
            for (int j = i * 2; j <= M && j <= i * i; j += i) {
                prime[j] = false;
            }
        }
    }

    public int maximumPrimeDifference(int[] nums) {
        int mn = nums.length;
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prime[nums[i]]) {
                mx = Math.max(mx, i);
                mn = Math.min(mn, i);
            }
        }
        return mx - mn;
    }
}
