package Contest1223.T4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-12-23 22:24
 */
public class Solution {

    private int n;
    private int[] cost;
    private List<Integer>[] map;
    private long[] res;

    public long[] placedCoins(int[][] edges, int[] cost) {
        n = edges.length + 1;
        this.cost = cost;
        map = new List[n];
        for (int i = 0; i < map.length; i++) map[i] = new ArrayList<>();
        for (int[] e : edges) {
            int f = e[0], t = e[1];
            map[f].add(t);
            map[t].add(f);
        }
        res = new long[n];
        dfs(0, -1);
        return res;
    }

    int[] dfs(int cur, int p) {
        int[] sub = new int[]{1, cost[cur], 0, 0, cost[cur], 0};
        for (Integer next : map[cur]) {
            if (p == next) continue;
            int[] dfs = dfs(next, cur);
            merge(sub, dfs);
        }
        if (sub[0] < 3) {
            res[cur] = 1;
        } else {
            res[cur] = Math.max(0, Math.max((long) sub[1] * sub[2] * sub[3], (long) sub[1] * sub[4] * sub[5]));
        }
        return sub;
    }

    // {size, mx1, mx2, mx3, mn1, mn2}
    void merge(int[] a, int[] b) {
        // 用b更新a
        List<Integer> mx = new ArrayList<>();
        List<Integer> mn = new ArrayList<>();
        // 取出元素
        getElements(mx, mn, a);
        getElements(mx, mn, b);
        Collections.sort(mx);
        Collections.sort(mn);
        // 把 b 合入 a
        a[0] += b[0];
        for (int i = 0; i < Math.min(3, a[0]); i++) a[i + 1] = mx.get(mx.size() - i - 1);
        for (int i = 0; i < Math.min(2, a[0]); i++) a[i + 4] = mn.get(i);
    }

    void getElements(List<Integer> mx, List<Integer> mn, int[] a) {
        for (int i = 0; i < Math.min(3, a[0]); i++) mx.add(a[i + 1]);
        for (int i = 0; i < Math.min(2, a[0]); i++) mn.add(a[i + 4]);
    }
}
