package Contest0401.T1;

/**
 * @author IronSid
 * @since 2023-04-01 23:29
 */
public class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] f = new int[10];
        int mn1 = 10, mn2 = 10;
        for (int i : nums1) {
            f[i]++;
            mn1 = Math.min(mn1, i);
        }
        for (int i : nums2) {
            f[i]++;
            mn2 = Math.min(mn2, i);
        }
        for (int i = 1; i <= 9; i++) {
            if (f[i] == 2) return i;
        }
        return Math.min(mn1 * 10 + mn2, mn2 * 10 + mn1);
    }
}
