package Contest0911.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-09-11 10:50
 */
public class Solution {
    public int lengthOfLIS(int[] nums, int k) {
        int n = nums.length;
        // end[i]表示长度 i + 1 的LIS的末尾元素的最小值
        int[] endmin = new int[n];
        int[] endMax = new int[n];
        endMax[0] = endmin[0] = nums[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > endmin[len - 1]) {
                endmin[len] = nums[i];
                len++;
            } else {
                int l = 0, r = len - 1;
                while (l <= r) {
                    int mid = l + r >> 1;
                    if (endmin[mid] < nums[i]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                endmin[l] = nums[i];
            }
            if (nums[i] > endMax[0]) {
                endMax[0] = nums[i];
            } else {
                int l = 0, r = len - 1;
                while (l <= r) {
                    int mid = l + r >> 1;
                    if (endMax[mid] >= nums[i] - k) {
                        l = mid + 1;
                    } else r = mid - 1;
                }
                endMax[l] = nums[i];
            }
        }
        System.out.println(Arrays.toString(endmin));
        System.out.println(Arrays.toString(endMax));
        return len;
    }
}
