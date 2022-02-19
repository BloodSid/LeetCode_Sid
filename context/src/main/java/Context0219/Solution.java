package Context0219;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-02-19 22:32
 */
public class Solution {
    static Solution solution = new Solution();

    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j] && i * j % k == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public List<Long> maximumEvenSplit(long finalSum) {
        if ((finalSum & 1) == 1) {
            return new ArrayList<>();
        }
        long even = 2;
        List<Long> list = new ArrayList<>();
        while (finalSum > even * 2) {
            list.add(even);
            finalSum -= even;
            even += 2;
        }
        list.add(finalSum);
        return list;
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        long cnt = 0;
        int n = nums1.length;
        HashSet<Integer> set = new HashSet<>();
        int[] goodZCount = new int[n];
        int[] goodXCount = new int[n];
        int[] hash = new int[n];
        for (int i = 0; i < n; i++) {
            hash[nums2[i]] = i;
        }
        for (int i1 = n - 1; i1 >= 0; i1--) {
            int temp = 0;
            for (int i2 = hash[nums1[i1]] + 1; i2 < n; i2++) {
                if (set.contains(nums2[i2])) {
                    temp++;
                }
            }
            goodZCount[i1] = temp;
            set.add(nums1[i1]);
        }
        set.clear();
        for (int i1 = 0; i1 < n; i1++) {
            int temp = 0;
            for (int i2 = hash[nums1[i1]] - 1; i2 >= 0; i2--) {
                if (set.contains(nums2[i2])) {
                    temp++;
                }
            }
            goodXCount[i1] = temp;
            set.add(nums1[i1]);
        }
        for (int i = 1; i < n - 1; i++) {
            cnt += (long) goodXCount[i] * goodZCount[i];
        }
        return cnt;
    }

    @Test
    public void testGoodTriplets1() {
        int[] nums1 = {4, 0, 1, 3, 2};
        int[] nums2 = {4, 1, 0, 2, 3};
        long actual = solution.goodTriplets(nums1, nums2);
        long expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void testGoodTriplets2() {
        int[] nums1 = {13, 14, 10, 2, 12, 3, 9, 11, 15, 8, 4, 7, 0, 6, 5, 1};
        int[] nums2 = {8, 7, 9, 5, 6, 14, 15, 10, 2, 11, 4, 13, 3, 12, 1, 0};
        long actual = solution.goodTriplets(nums1, nums2);
        long expected = 77;
        assertEquals(expected, actual);
    }
}
