package Contest1022.T4;

import java.util.Arrays;

/**
 * @author IronSid
 * @since 2022-10-22 15:03
 */
// 221021天池-04. 意外惊喜
// https://leetcode.cn/contest/tianchi2022/problems/tRZfIV/
public class Solution {

    private int max;
    private int[][] present;
    private int[] sum;
    private int limit;

    public int brilliantSurprise(int[][] present, int limit) {
        this.present = present;
        int m = present.length;
        this.limit = limit;
        sum = new int[m];
        // 每个包的总价值
        for (int i = 0; i < present.length; i++) {
            for (int j = 0; j < present[i].length; j++) {
                sum[i] += present[i][j];
            }
        }
        // dp[i] 表示花费 i 的最大礼物总价值
        int[] dp = new int[limit + 1];
        max = 0;
        /* present[i] 中的元素单调递增。若两个不同的包中分别选至 present[i][x], present[j][y], 不妨有 present[i][x]
        >= present[j][y], 则 present[i][x + 1] >= present[j][y], 即从包 j 少选个，往包 i 多选一个一定更优，如此递推, 则可以
        由 j 转移至 i 直至 i 全选或者 j 全不选。 对任意两包都成立，则可知，最优的选法一定满足，只有一个包 选择部分，其他包全选或全
        不选。通过分治枚举每一个包作为那个不选的包的情况
         */
        dfs(dp, 0, m - 1);
        return max;
    }

    // dp 表示之前的礼包计算背包的结果，l 和 r 表示递归的范围
    void dfs(int[] dp, int l, int r) {
        // 递归到最后一个礼包，它可以不全取，计算这个礼包的取法，枚举前缀的长度
        if (r == l) {
            int[] last = present[r];
            for (int i = 0, pre = 0; i < last.length; i++) {
                if (i >= limit) break;
                pre += last[i];
                max = Math.max(max, dp[limit - (i + 1)] + pre);
            }
            return;
        }

        // 记录现场
        int[] copy = Arrays.copyOf(dp, dp.length);
        int mid = l + r >> 1;
        // 计算左侧，每个包只能全取或者全不取，递归右侧
        for (int j = l; j <= mid; j++) {
            int cost = present[j].length;
            for (int i = limit; i >= cost; i--) {
                // sum[j] 表示价值
                dp[i] = Math.max(dp[i], dp[i - cost] + sum[j]);
            }
        }
        dfs(dp, mid + 1, r);
        dp = copy;
        // 在和初始状态的 dp 上计算右侧，每个包只能全取或者全不取，递归左侧
        for (int j = mid + 1; j <= r; j++) {
            int cost = present[j].length;
            for (int i = limit; i >= cost; i--) {
                dp[i] = Math.max(dp[i], dp[i - cost] + sum[j]);
            }
        }
        dfs(dp, l, mid);
    }

}
