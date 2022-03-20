package leetcode.editor.cn;

import java.util.*;

/**
 * 网络空闲的时刻
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-20 00:39:08 
 */
public class TheTimeWhenTheNetworkBecomesIdleSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashMap<Integer, List<Integer>> map;

    public int networkBecomesIdle(int[][] edges, int[] patience) {
        map = new HashMap<>();
        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            add(i, j, map);
            add(j, i, map);
        }
        int n = patience.length;
        boolean[] visited = new boolean[n];
        int max = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur != 0) {
                    int closetSent = (depth * 2 - 1) / patience[cur] * patience[cur];
                    max = Math.max(max, depth * 2 + closetSent);
                }
                if (map.containsKey(cur)) {
                    for (Integer next : map.get(cur)) {
                        if (!visited[next]) {
                            queue.offer(next);
                            visited[next] = true;
                        }
                    }
                }
            }
            depth++;
        }
        return max + 1;
    }

    private void add(int i, int j, HashMap<Integer, List<Integer>> map) {
        if (!map.containsKey(i)) {
            map.put(i, new LinkedList<>());
        }
        map.get(i).add(j);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
