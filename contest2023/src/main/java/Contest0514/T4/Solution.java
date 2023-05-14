package Contest0514.T4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-05-14 16:46
 */
public class Solution {

    private boolean[] vis;
    private List<Integer>[] map;

    public int countCompleteComponents(int n, int[][] edges) {
        vis = new boolean[n];
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            map[x].add(y);
            map[y].add(x);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> component = new ArrayList<>();
            dfs(i, component);
            if (component.size() == 0) continue;
            int sum = 0;
            for (Integer v : component) {
                sum += map[v].size();
            }
            int size = component.size();
            if (sum == size * (size - 1)) cnt++;
        }
        return cnt;
    }

    private void dfs(int node, List<Integer> component) {
        if (vis[node]) return;
        component.add(node);
        vis[node] = true;
        for (Integer next : map[node]) {
            dfs(next, component);
        }
    }

}
