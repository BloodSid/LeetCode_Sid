package Contest1112.T3;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-11-12 21:44
 */
public class Solution {

    public static final int INF = (int) 1e9 + 100;
    private List<Integer>[] map;
    private int[] amount;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        this.amount = amount;
        int n = edges.length + 1;
        // 建图
        map = new List[n];
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        }
        // 找到从 bob 到 0 的路径，并把到达时间记下
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] vis = new boolean[n];
        dfs1(bob, stack, vis);
        int[] bTime = new int[n];
        Arrays.fill(bTime, INF);
        int p = 0;
        while (!stack.isEmpty()) {
            bTime[stack.pollLast()] = p++;
        }
        // 遍历所有的节点，并记录最大得分
        Arrays.fill(vis, false);
        return dfs2(0, 0, 0, vis, bTime);
    }

    void add(int from, int to) {
        if (map[from] == null) map[from] = new ArrayList<>();
        map[from].add(to);
    }

    boolean dfs1(int node, Deque<Integer> stack, boolean[] vis) {
        vis[node] = true;
        stack.push(node);
        if (node == 0) {
            return true;
        }
        for (Integer next : map[node]) {
            if (!vis[next] && dfs1(next, stack, vis)) {
                return true;
            }
        }
        stack.pop();
        return false;
    }

    int dfs2(int node, int aTime, int sum, boolean[] vis, int[] bTime) {
        vis[node] = true;
        // 如果到达时间和 bob 到达时间一致，则获得一半分数，如果到达时间晚于 bob，则不得分
        if (aTime == bTime[node]) {
            sum += amount[node] / 2;
        } else if (aTime < bTime[node]) {
            sum += amount[node];
        }
        // 叶子节点
        if (node != 0 && map[node].size() == 1) {
            return sum;
        }
        int res = -INF;
        for (Integer next : map[node]) {
            if (!vis[next]) {
                int t = dfs2(next, aTime + 1, sum, vis, bTime);
                res = Math.max(res, t);
            }
        }
        return res;
    }
}
