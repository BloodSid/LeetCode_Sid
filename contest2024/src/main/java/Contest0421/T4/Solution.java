package Contest0421.T4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2024-04-21 9:39
 */
public class Solution {

    public static final int INF = (int) (1e9+7);

    public boolean[] findAnswer(int n, int[][] edges) {
        int m = edges.length;
        int[] dist = new int[n];
        Arrays.fill(dist, 1, n, INF);
        // 建图
        HashMap<Integer, int[]>[] map = new HashMap[n];
        for (int i = 0; i < n; i++) {
            map[i] = new HashMap<>();
        }
        for (int i = 0; i < m; i++) {
            int[] edge = edges[i];
            int u = edge[0], v = edge[1], w = edge[2];
            map[u].put(v, new int[]{w, i});
            map[v].put(u, new int[]{w, i});
        }

        // dijkstra 优先队列存储 {index, 距离}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int i = p[0], d = p[1];
            if (d > dist[i]) continue;
            dist[i] = d;
            for (Integer j : map[i].keySet()) {
                int[] e = map[i].get(j);
                int nd = d + e[0];
                if (dist[j] > nd) {
                    dist[j] = nd;
                    pq.offer(new int[]{j, nd});
                }
            }
        }
        boolean[] res = new boolean[m];
        boolean[] vis = new boolean[n];
        dfs(n - 1, dist, map, res, vis);
        return res;
    }

    private void dfs(int cur, int[] dist, HashMap<Integer, int[]>[] map, boolean[] res, boolean[] vis) {
        vis[cur] = true;
        for (Integer nxt : map[cur].keySet()) {
            int[] e = map[cur].get(nxt);
            int w = e[0], i = e[1];
            if (dist[cur] != dist[nxt] + w) continue;
            res[i] = true;
            if (!vis[nxt]) dfs(nxt, dist, map, res, vis);
        }
    }
}
