package Contest1210.T4;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-12-10 22:29
 */
public class Solution {
    public long minimumTotalCost(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] f = new int[n + 1];
        for (int i : nums1) f[i]++;
        for (int i : nums2) f[i]++;
        int maxF = 0;
        for (int i : f) maxF = Math.max(maxF, i);
        // 抽屉原理
        if (maxF > n) return -1;
        long sum = 0;
        // 记录相等元素的频率
        f = new int[n + 1];
        // 记录相等元素的下标
        HashSet<Integer> set = new HashSet<>();
        maxF = 0;
        // 众数
        int mode = 0;
        // 结果应该是需要交换的元素的下标的集合之和
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                f[nums1[i]]++;
                if (f[nums1[i]] > maxF) {
                    maxF = f[nums1[i]];
                    mode = nums1[i];
                }
                set.add(i);
            }
        }
        // 若相等元素的频率不集中，这些位置之间相互交换即可
        for (Integer idx : set) {
            sum += idx;
        }
        // 若相等元素的频率集中，则还需要再找一些位置
        if (maxF > set.size() / 2) {
            // 找的位置需要满足下标尽可能小，且在两个数组中的值都不能是众数，
            int request = maxF - (set.size() - maxF);
            for (int i = 0, j = 0; i < n && j < request; i++) {
                if (!set.contains(i) && nums1[i] != mode && nums2[i] != mode) {
                    sum += i;
                    j++;
                }
            }
        }
        return sum;
    }
}
