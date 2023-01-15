package Contest0115.T4;

import java.util.*;

/**
 * @author IronSid
 * @since 2023-01-15 10:20
 */
public class Solution {

    private long max;
    int n;
    private List<Integer>[] map;
    private int[] price;

    public long maxOutput(int n, int[][] edges, int[] price) {
        this.n = n;
        map = new List[n];
        this.price = price;
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            add(edge[1], edge[0]);
            add(edge[0], edge[1]);
        }
        boolean[] vis = new boolean[n];
        dfs(0, vis);
        return max;
    }

    void add(int from, int to) {
        map[from].add(to);
    }


    // 返回此节点往下的最长路径 has , 和不含叶子节点的最长路径 no
    long[] dfs(int cur, boolean[] vis) {
        vis[cur] = true;
        // maxHas 最大的含端点的路径，maxNo 最大的不含端点的路径
        long p = price[cur], maxHas = p, maxNo = 0;
        for (Integer next : map[cur]) {
            if (!vis[next]) {
                long[] t = dfs(next, vis);
                long has = t[0], no = t[1];
                // 前面最大不含端点的路径 + 当前带叶子的路径
                max = Math.max(max, has + maxNo);
                // 前面最大含端点的路径 + 当前不含端点的路径
                max = Math.max(max, no + maxHas);
                // 遍历的过程中先更新 has+no 的最大值，再更新 has 和 no，这样就避免了 has 和 no 对应的路径重合
                maxHas = Math.max(maxHas, has + p);
                maxNo = Math.max(maxNo, no + p);
            }
        }
        return new long[]{maxHas, maxNo};
    }
}
