package Contest1001.T4;

import java.util.TreeSet;

/**
 * @author IronSid
 * @since 2022-10-01 22:28
 */
public class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = nums1[i] - nums2[i];
        }
        long res = 0;
        TreeSet<Integer> set = new TreeSet<>((o1, o2) -> {
            if (nums[o1] == nums[o2]) return o1 - o2;
            else return nums[o1] -nums[o2];
        });
        for (int i = 0; i < n; i++) {
            int bound = nums[i] + diff;
            nums[n] = bound;
            res += set.headSet(n).size();
            set.add(i);
        }
        return res;
    }
}