package Contest0925.T4;

import java.util.*;

/**
 * @author IronSid
 * @since 2022-09-25 11:24
 */
public class Solution {

    private int[] p;
    private int[] f;
    private int[] max;
    private int cnt;
    private HashMap<Integer, List<Integer>> map;

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if(vals[a] > vals[b]) add(a, b);
            else add(b, a);
        }
        p = new int[n];
        max = new int[n];
        f = new int[n];
        cnt = 0;
        Integer[] nodes = new Integer[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
            p[i] = i;
            max[i] = vals[i];
            f[i] = 1;
        }
        Arrays.sort(nodes, Comparator.comparingInt(k -> vals[k]));
        for (Integer node : nodes) {
            if (map.containsKey(node)) {
                for (Integer child : map.get(node)) {
                    union(child, node);
                }
            }
            cnt += f[find(node)];
        }
        return cnt;
    }

    void add(int from, int to) {
        if (!map.containsKey(from)) {
            map.put(from, new ArrayList<>());
        }
        map.get(from).add(to);
    }

    void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        int maxA = max[ra];
        int maxB = max[rb];
        if (maxA > maxB) {
            p[rb] = ra;
        } else if (maxA < maxB) {
            p[ra] = rb;
        } else {
            p[rb] = ra;
            f[ra] += f[rb];
        }
    }

    int find(int a) {
        if (p[a] != a) p[a] = find(p[a]);
        return p[a];
    }
}
