package Contest1210.T2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-12-10 22:29
 */
public class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n = vals.length;
        List<Integer>[] map = new List[n];
        for (int[] edge : edges) {
            add(edge[0], edge[1], map);
            add(edge[1], edge[0], map);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            List<Integer> next = map[i];
            if (next == null) {
                // 没有相邻节点
                max = Math.max(max, vals[i]);
                continue;
            }
            // 相邻节点进行排序
            next.sort((o1, o2) -> vals[o2] - vals[o1]);
            // 找至多 k 个相邻节点，使得节点和最大
            int sum = vals[i];
            for (int i1 = 0; i1 < Math.min(k, next.size()); i1++) {
                int o = next.get(i1);
                if (vals[o] <= 0) break;
                sum += vals[o];
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    void add(int from, int to, List<Integer>[] map) {
        if (map[from] == null) map[from] = new ArrayList<>();
        map[from].add(to);
    }
}
