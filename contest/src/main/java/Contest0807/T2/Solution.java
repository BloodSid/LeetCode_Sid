package Contest0807.T2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-08-07 10:24
 */
public class Solution {
    private boolean[] visited;
    private List<Integer>[] map;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        visited = new boolean[n];
        for (int i : restricted) {
            visited[i] = true;
        }
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            add(edge[0], edge[1], map);
            add(edge[1], edge[0], map);
        }
        return dfs(0);
    }

    int dfs(int cur) {
        visited[cur] = true;
        int sum = 1;
        for (Integer next : map[cur]) {
            if (!visited[next]) sum += dfs(next);
        }
        return sum;
    }

    void add(int f, int t, List<Integer>[] map) {
        map[f].add(t);
    }
}
