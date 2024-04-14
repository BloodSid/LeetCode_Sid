package Contest0414.T4;

import java.util.Arrays;

public class Solution {

    public static final int INF = (int) (1e9+7);
    private int[][] p;
    private int M;

    public int minimumValueSum(int[] nums, int[] v) {
        int n = nums.length;
        int m = v.length;
        M = 32 - Integer.numberOfLeadingZeros((int) 1e5);
        p = new int[n+1][M];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < M; j++) {
                p[i+1][j] = p[i][j] + (1 & (~nums[i] >> j));
            }
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }

        // 全1
        int add = -1;
        for (int i = 1; i <= n; i++) {
            add &= nums[i - 1];
            if (add == v[0]) {
                dp[i][1] = nums[i - 1];
            }
            for (int j = 2; j <= m; j++) {
                int k = v[j - 1];
                if ((nums[i - 1] & k) == k) {
                    // 可以贴在上一个数组的后面
                    dp[i][j] = Math.min(dp[i][j], (dp[i - 1][j] != INF ? (dp[i - 1][j] + nums[i - 1] - (i >= 2 ? nums[i - 2] : 0)) : INF));
                }
                // 不贴在上一个数组的后面，二分找h的范围
                int l = lowerBound(k, i - 1);
                int r = lowerBound(k + 1, i - 1) - 1;
                if (addRange(l, i - 1) != k) {
                    continue;
                }
                for (int h = l; h <= r; h++) {
                    dp[i][j] = Math.min(dp[i][j], dp[h][j - 1] + nums[i - 1]);
                }
            }
        }
        return dp[n][m] < INF ? dp[n][m] : -1;
    }

    // target表示与运算目标值，end表示范围的上界，返回第一个与运算值大于等于target 的start下标
    int lowerBound(int target, int end) {
        int l = 0, r = end;
        while (l <= r) {
            int mid = l + r >> 1;
            if (addRange(mid, end) >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    int addRange(int l, int r) {
        int res = 0;
        for (int i = 0; i < M; i++) {
            if (p[r+1][i] - p[l][i] == 0) {
                res |= 1 << i;
            }
        }
        return res;
    }
}