package Contest0121.T2;

/**
 * @author IronSid
 * @since 2023-01-21 22:32
 */
public class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[] diff = new int[n];
        long sum = 0;
        long absSum = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = nums1[i] - nums2[i];
            sum += diff[i];
            absSum += Math.abs(diff[i]);
        }
        if (sum != 0) return -1;
        if (absSum == 0) return 0;
        if (k == 0) return -1;
        long op = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] % k == 0) {
                op += Math.max(0, diff[i] / k);
            } else {
                return -1;
            }
        }
        return op;
    }
}