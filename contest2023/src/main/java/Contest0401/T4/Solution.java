package Contest0401.T4;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author IronSid
 * @since 2023-04-01 23:30
 */
public class Solution {
    private HashMap<Integer, HashSet<Integer>> map;

    public int findShortestCycle(int n, int[][] edges) {
        map = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0],  y = edge[1];
            addEdge(x, y);
            addEdge(y, x);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            dist[i] = 1;
            ArrayDeque<Integer> pq = new ArrayDeque<>();
            pq.offer(i);
            // bfs
            while (!pq.isEmpty()) {
                int poll = pq.poll();
                for (Integer next : map.getOrDefault(poll, new HashSet<>())) {
                    if (dist[next] == 0) {
                        // 相邻节点未访问
                        dist[next] = dist[poll] + 1;
                        pq.offer(next);
                    } else if (dist[next] != dist[poll] - 1) {
                        // 相邻节点不是当前节点的父亲节点
                        min = Math.min(min, dist[next] + dist[poll] - 1);
                    }
                }
            }
        }
        return min != Integer.MAX_VALUE ? min : -1;
    }

    void addEdge(int a, int b) {
        map.putIfAbsent(a, new HashSet<>());
        map.get(a).add(b);
    }

}