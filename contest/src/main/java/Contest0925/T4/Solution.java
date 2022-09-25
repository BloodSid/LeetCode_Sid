package Contest0925.T4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-09-25 11:24
 */
public class Solution {
    private int[] vals;
    private int cnt;
    private HashMap<Integer, List<Integer>> map;
    private HashSet<Integer> vis;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        this.vals = vals;
        map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            add(a, b);
            add(b, a);
        }
        cnt = 0;
        vis = new HashSet<>();
        dfs(0);
        return vals.length + cnt;
    }

    // 返回最大值和最大值的数量
    int[] dfs(int node) {
        vis.add(node);
        List<int[]> list = new ArrayList<>();
        if (map.containsKey(node)) {
            for (Integer child : map.get(node)) {
                if (!vis.contains(child)) {
                    list.add(dfs(child));
                }
            }
        }
        list.add(new int[]{vals[node], 1});
        int max = Integer.MIN_VALUE;
        for (int[] arr : list) {
            max = Math.max(max, arr[0]);
        }
        int c = 0;
        for (int[] arr : list) {
            if (arr[0] == max) c += arr[1];
        }
        cnt += (long) c * (c - 1) / 2;
        return new int[]{max, c};
    }

    void add(int from, int to) {
        if (!map.containsKey(from)) {
            map.put(from, new ArrayList<>());
        }
        map.get(from).add(to);
    }
}
