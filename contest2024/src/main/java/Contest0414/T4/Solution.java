package Contest0414.T4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author IronSid
 * @since 2024-04-14 10:27
 */
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
        // dp(i,j)表示前i个元素划分得到v[0,j]的最小“值”之和
        int[][] dp = new int[n + 1][m];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        // 单调队列-增，{sum子数组值之和，idx最后一个元素的下标}
        Deque<int[]>[] q = new Deque[m];
        for (int i = 0; i < m; i++) {
            q[i] = new ArrayDeque<>();
        }
        // 全1
        int add = -1;
        for (int i = 1; i <= n; i++) {
            add &= nums[i - 1];
            for (int j = m - 1; j >= 0; j--) {
                if (j == 0) {
                    if (add == v[0]) {
                        dp[i][0] = nums[i - 1];
                    }
                } else {
                    int k = v[j];
                    if ((nums[i - 1] & k) == k) {
                        // 可以贴在上一个数组的后面
                        if (dp[i - 1][j] != INF) {
                            dp[i][j] = Math.min(dp[i][j], (dp[i - 1][j] + nums[i - 1] - nums[i - 2]));
                        }
                    }
                    // 不贴在上一个数组的后面，二分找这个子数组最远和最近的起点范围
                    int l = lowerBound(k, i - 1);
                    int r = lowerBound(k + 1, i - 1) - 1;
                    if (r < l) continue; // 没有合法的起点
                    // 从队首排除不合法的转移
                    while (!q[j - 1].isEmpty() && q[j - 1].peekFirst()[1] + 1 < l) {
                        q[j - 1].pollFirst();
                    }
                    if (!q[j - 1].isEmpty() && q[j - 1].peekFirst()[1] + 1 <= r) {
                        dp[i][j] = Math.min(dp[i][j], q[j - 1].peekFirst()[0] + nums[i - 1]);
                    }
                }
                // 更新单调队列
                if (dp[i][j] < INF) {
                    while (!q[j].isEmpty() && q[j].peekLast()[0] > dp[i][j]) {
                        q[j].pollLast();
                    }
                    q[j].offerLast(new int[]{dp[i][j], i - 1});
                }
            }
        }
        return dp[n][m-1] < INF ? dp[n][m-1] : -1;
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

