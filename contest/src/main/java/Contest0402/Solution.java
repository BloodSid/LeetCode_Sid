package Contest0402;

import java.util.HashSet;

/**
 * @author IronSid
 * @since 2022-04-02 22:27
 */
public class Solution {
    // T1
    public int minBitFlips(int start, int goal) {
        int cnt = 0;
        for (; start != 0 || goal != 0; start >>= 1, goal >>= 1) {
            cnt += (start & 1) ^ (goal & 1);
        }
        return cnt;
    }
    // T2
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                nums[j] = (nums[j] + nums[j + 1]) % 10;
            }
        }
        return nums[0];
    }

    // T3
    public long numberOfWays(String s) {
        int n = s.length();
        char[] array = s.toCharArray();
        int[] pre = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            pre[i] = t;
            t += array[i] - '0';
        }
        int[] suf = new int[n];
        t = 0;
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = t;
            t += array[i] - '0';
        }
        long sum = 0;
        for (int i = 1; i < n - 1; i++) {
            if (array[i] == '0') {
                sum += (long) pre[i] * suf[i];
            } else {
                sum += (long) (i - pre[i]) * (n - i - 1 - suf[i]);
            }
        }
        return sum;
    }

    // T4
    public long sumScores(String s) {
            long score = 0;
            int n = s.length();
            HashSet<String> pre = new HashSet<>();
            for (int i = 0; i <= n; i++) {
                pre.add(s.substring(0, i));
            }
            for (int i = n - 1; i >= 0; i--) {
                int l = 0, r = n - i;
                while (l <= r) {
                    int mid = l + r >> 1;
                    if (pre.contains(s.substring(i, i + mid))){
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                score += r;
            }
            return score;
        }

}
