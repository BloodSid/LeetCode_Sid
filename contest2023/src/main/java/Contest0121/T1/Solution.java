package Contest0121.T1;

/**
 * @author IronSid
 * @since 2023-01-21 22:32
 */
public class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] > nums2[j]) {
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                return nums1[i];
            }
        }
        return -1;
    }
}
