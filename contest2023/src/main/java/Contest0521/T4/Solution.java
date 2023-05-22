package Contest0521.T4;

import java.util.*;

/**
 * @author IronSid
 * @since 2023-05-21 10:21
 */
public class Solution {

    public static final int INF = (int) (1e9 + 7);
    private int[][] edges;
    private int source, destination, target;
    private int[][] dists;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        this.edges = edges;
        this.source = source;
        this.destination = destination;
        this.target = target;
        // {v, ei}
        List<int[]>[] map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            map[e[0]].add(new int[]{e[1], i});
            map[e[1]].add(new int[]{e[0], i});
        }
        dists = new int[2][n];
        // -1 的边建图，并在计算过程中取最小值1
        dijkstra(0, map);
        // 若最短路路径大于 target 则无法修改得到目标
        if (dists[0][destination] > target) return new int[][]{};
        // 根据最短路的结果修改原图
        dijkstra(1, map);
        // 若修改后的图最短路小于 target 则无法修改得到目标，这种情况见于本来的不包括-1的图的最短路就已经小于target
        if (dists[1][destination] < target) return new int[][]{};
        // 未修改的边赋很大的值
        for (int[] edge : edges) {
            if (edge[2] == -1) edge[2] = INF;
        }
        return edges;
    }

    void dijkstra(int di, List<int[]>[] map) {
        int[] dist = dists[di];
        Arrays.fill(dist, INF);
        dist[source] = 0;
        // {i, d}
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{source, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int cur = p[0], d = p[1];
            if (d > dist[cur]) continue;
            dist[cur] = d;
            // 找到终点
            if (cur == destination) return;
            for (int[] t : map[cur]) {
                int next = t[0], ei = t[1];
                int nd;
                if (di == 0) {
                    // 第一遍最短路把-1边取最小值1进行计算
                    nd = d + (edges[ei][2] == -1 ? 1 : edges[ei][2]);
                } else {
                    // 第二遍最短路中根据 d1,u + w + (d0,e - d0,v) = target 确定-1边的边权w，其中u，v是边的两个顶点，e是终点
                    if (edges[ei][2] == -1) {
                        int w = target - dists[1][cur] - dists[0][destination] + dists[0][next];
                        // 只能改大，且最小值为1
                        edges[ei][2] = Math.max(edges[ei][2],  Math.max(w, 1));
                    }
                    nd = d + edges[ei][2];
                }
                if (dist[next] > nd) {
                    dist[next] = nd;
                    pq.offer(new int[]{next, nd});
                }
            }
        }
    }
}