package Contest0416.T4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-04-16 10:30
 */
public class Solution {

    private List<Integer>[] map;
    private int[] price;
    private List<Integer> path;
    private boolean[] vis;
    private int[] cnt;
    private int[][] dp;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        map = new List[n];
        this.price = price;
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int a = edge[0], b= edge[1];
            map[a].add(b);
            map[b].add(a);
        }
        // 染色将节点分为两组
        // 所有的旅行只有唯一路径，计算所有路径上每个节点出现次数
        cnt = new int[n];
        int sum = 0;
        for (int[] trip : trips) {
            int start = trip[0], end = trip[1];
            vis = new boolean[n];
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            dfs0(start, end, stack);
            if (path != null) {
                for (Integer p : path) {
                    cnt[p]++;
                    sum += price[p];
                }
            }
        }
        // dp0 不选该节点的最大值，dp1 选该节点的最大值
        dp = new int[2][n];
        vis = new boolean[n];
        dfs1(0, -1);
        int max = Math.max(dp[0][0], dp[1][0]);
        return sum - max / 2;
    }

    private void dfs1(int cur, int parent) {
        vis[cur] = true;
        for (Integer next : map[cur]) {
            if (vis[next]) {
                continue;
            }
            dfs1(next, cur);
            dp[0][cur] += Math.max(dp[0][next], dp[1][next]);
            dp[1][cur] += dp[0][next];
        }
        dp[1][cur] += cnt[cur] * price[cur];
    }


    private boolean dfs0(int cur, int end, ArrayDeque<Integer> stack) {
        vis[cur] = true;
        stack.push(cur);
        if (cur == end) {
            path = new ArrayList<>(stack);
            return true;
        }
        for (Integer next : map[cur]) {
            if (vis[next]) continue;
            if (dfs0(next, end, stack)) return true;
        }
        stack.pop();
        return false;
    }

}