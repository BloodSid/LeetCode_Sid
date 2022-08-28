package Contest0828.T1;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-08-28 0:33
 */
public class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] p = new int[n];
        for (int i = 0, t = 0; i < n; i++) {
            t += nums[i];
            p[i] = t;
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = l + r >> 1;
                if (p[mid] > queries[i]) r = mid - 1;
                else l = mid + 1;
            }
            ans[i] = l;
        }
        return ans;
    }
}
