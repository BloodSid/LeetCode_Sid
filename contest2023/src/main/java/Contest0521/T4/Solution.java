package Contest0521.T4;

import java.util.*;

/**
 * @author IronSid
 * @since 2023-05-21 10:21
 */
public class Solution {

    public static final int INF = (int) (1e9 + 7);
    private int[][] edges;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        this.edges = edges;
        HashMap<Integer, HashMap<Integer, Integer>> mp1 = new HashMap<>();
        HashMap<Integer, HashMap<Integer, Integer>> mp2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp1.put(i, new HashMap<>());
            mp2.put(i, new HashMap<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] e = edges[i];
            if (e[2] == -1) {
                e[2] = INF;
            } else {
                // -1 的边不建图1
                mp1.get(e[0]).put(e[1], i);
                mp1.get(e[1]).put(e[0], i);
            }
            mp2.get(e[0]).put(e[1], i);
            mp2.get(e[1]).put(e[0], i);
        }
        // 最短路的距离，和上一个点的边的下标
        int[] dist = new int[n], e = new int[n];
        dijkstra(dist, e, source, destination, mp1);
        // 终点可达且路径长度小于 target 则无法构成结果
        if (dist[destination] != INF) {
            if (dist[destination] < target) return new int[][]{};
            if (dist[destination] == target) return edges;
        }
        // -1 的边建图，并在计算过程中取最小值1。若结果小于等于target
        dijkstra(dist, e, source, destination, mp2);
        // 若最短路路径大于 target 则无法修改得到目标
        if (dist[destination] != INF && dist[destination] > target) return new int[][]{};
        // 根据最短路的结果修改原图
        List<Integer> list = new ArrayList<>();
        for (int cur = destination; cur != source; ) {
            int ei = e[cur];
            if (edges[ei][2] == INF) list.add(ei);
            int[] edge = edges[ei];
            cur = cur ^ edge[0] ^ edge[1];
        }
        for (int i1 = 0; i1 < list.size(); i1++) {
            int ei = list.get(i1);
            // 改一次边，判断一次最短路
            edges[ei][2] = 1;
            mp1.get(edges[ei][0]).put(edges[ei][1], ei);
            mp1.get(edges[ei][1]).put(edges[ei][0], ei);
            dijkstra(dist, e, source, destination, mp1);
            if (dist[destination] <= target) {
                edges[ei][2] += target - dist[destination];
                break;
            }
        }
        return edges;
    }

    void dijkstra(int[] dist, int[] e, int source, int destination, HashMap<Integer, HashMap<Integer, Integer>> map) {
        Arrays.fill(dist, INF);
        Arrays.fill(e, -1);
        dist[source] = 0;
        // {i, d, ei}
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{source, 0, -1});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int cur = p[0], d = p[1], ei = p[2];
            if (d > dist[cur]) continue;
            // 更新上一个节点
            e[cur] = ei;
            // 找到终点
            if (cur == destination) return;
            for (Map.Entry<Integer, Integer> et : map.get(cur).entrySet()) {
                int next = et.getKey(), nei = et.getValue();
                // 将无限长的边取最小值
                int nd = d + (edges[nei][2] == INF ? 1 : edges[nei][2]);
                if (dist[next] > nd) {
                    dist[next] = nd;
                    pq.offer(new int[]{next, nd, nei});
                }
            }
        }
    }
}