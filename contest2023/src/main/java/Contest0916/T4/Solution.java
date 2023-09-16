package Contest0916.T4;


import java.util.HashMap;

/**
 * @author IronSid
 * @since 2023-09-16 22:21
 */
public class Solution {

    private int[] res;
    private HashMap<Integer, Integer>[] map;

    public int[] minEdgeReversals(int n, int[][] edges) {
        map = new HashMap[n];
        for (int i = 0; i < n; i++) map[i] = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            map[from].put(to, 1);
            map[to].put(from, -1);
        }
        res = new int[n];
        boolean[] vis = new boolean[n];
        res[0] = dfs1(0, vis);
        vis = new boolean[n];
        dfs2(0, res[0], vis);
        return res;
    }

    void dfs2(int cur, int ans, boolean[] vis) {
        vis[cur] = true;
        res[cur] = ans;
        for (Integer next : map[cur].keySet()) {
            if (vis[next]) continue;
            dfs2(next, ans + map[cur].get(next), vis);
        }
    }

    int dfs1(int cur, boolean[] vis) {
        vis[cur] = true;
        int res = 0;
        for (Integer next : map[cur].keySet()) {
            if (vis[next]) continue;
            if (map[cur].get(next) == -1) res++;
            res += dfs1(next, vis);
        }
        return res;
    }
}