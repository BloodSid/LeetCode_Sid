package Contest0731.T4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author IronSid
 * @since 2022-07-31 10:59
 */
public class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        // 拓扑排序删去不在环上的边
        int[] inCnt = new int[n];
        for (int edge : edges) {
            if (edge != -1) inCnt[edge]++;
        }
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < inCnt.length; i++) {
            if (inCnt[i] == 0) q.offer(i);
        }
        while (!q.isEmpty()) {
            int from = q.poll();
            int to = edges[from];
            edges[from] = -1;
            if (to != -1) {
                inCnt[to]--;
                if (inCnt[to] == 0) q.offer(to);
            }
        }
        // dfs
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dfs(i, edges));
        }
        return max == 0 ? -1 : max;
    }

    int dfs(int cur, int[] edges) {
        if (edges[cur] == -1) return 0;
        int to = edges[cur];
        edges[cur] = -1;
        return dfs(to, edges) + 1;
    }
}
