package Contest1209.T1;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2023-12-09 22:16
 */
public class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        return new int[]{count(nums1, nums2), count(nums2, nums1)};
    }

    int count(int[] a, int[] b) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : b) {
            set.add(i);
        }
        int cnt = 0;
        for (int i : a) {
            if (set.contains(i)) cnt++;
        }
        return cnt;
    }
}