package Contest1125.T4;

/**
 * @author IronSid
 * @since 2023-10-28 22:33
 */
public class Solution {
    public int findMaximumLength(int[] nums) {
        int n = nums.length;
//        long[] p = new long[n + 1];
//        for (int i = 0; i < n; i++) {
//            p[i + 1] = p[i] + nums[i];
//        }
        int res = 1;
        // 贪心
        long pre = nums[0];
        long[] sub = new long[n];
        sub[0] = nums[0];
        for (int i = 1; i < n; ) {
            long cur = 0;
            // 记录这一片的起始位置
            int start = i;
            for ( ; i < n; i++) {
                cur += nums[i];
                if (cur >= pre) break;
            }
            if (cur >= pre) {
                // 反悔，尝试把这一片的一部分还给前一部分
                while (cur - nums[start] >= pre + nums[start]) {
                    cur -= nums[start];
                    pre += nums[start];
                    start++;
                }
                sub[res] = cur;
                sub[res - 1] = pre;
                res++;
                pre = cur;
                i++;
            }
        }
        return res;
    }
}
