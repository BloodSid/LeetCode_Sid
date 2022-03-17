package leetcode.editor.cn;

/**
 * 最大网络秩
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-17 23:01:28
 */
public class MaximalNetworkRankSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] path = new boolean[n][n];
        int[] cnt = new int[n];
        for (int[] road : roads) {
            int i = road[0], j = road[1];
            path[i][j] = path[j][i] = true;
            cnt[i]++;
            cnt[j]++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (path[i][j]) {
                    max = Math.max(max, cnt[i] + cnt[j] - 1);
                } else {
                    max = Math.max(max, cnt[i] + cnt[j]);
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
