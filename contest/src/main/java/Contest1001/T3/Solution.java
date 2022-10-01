package Contest1001.T3;

/**
 * @author IronSid
 * @since 2022-10-01 22:28
 */
public class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int xor1 = 0, xor2 = 0;
        if (n1 % 2 != 0) {
            for (int i : nums2) {
                xor2 ^= i;
            }
        }
        if (n2 % 2 != 0) {
            for (int i : nums1) {
                xor1 ^= i;
            }
        }
        return xor1 ^ xor2;
    }
}
