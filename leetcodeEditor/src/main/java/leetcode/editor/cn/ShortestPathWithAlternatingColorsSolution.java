package leetcode.editor.cn;

import java.util.*;

/**
 * 颜色交替的最短路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-11 16:08:22
 */
public class ShortestPathWithAlternatingColorsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static final int RED = 0;
    public static final int BLUE = 1;

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        buildMap(redEdges, redMap);
        buildMap(blueEdges, blueMap);
        int[] len = new int[n];
        Arrays.fill(len, -1);
        // BFS
        int depth = 0;
        boolean[] redVis = new boolean[n];
        boolean[] blueVis = new boolean[n];
        // {i, j} i表示当前节点，j表示一步的边的颜色
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, RED});
        queue.offer(new int[]{0, BLUE});
        // 每个节点允许从蓝色边进入一次，也允许从红色边进入一次，所以需要两个visited数组
        redVis[0] = true;
        blueVis[0] = true;
        Map<Integer, List<Integer>> map;
        boolean[] visited;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int cur = poll[0], color = poll[1];
                if (color == RED) {
                    map = redMap;
                    visited = redVis;
                } else {
                    map = blueMap;
                    visited = blueVis;
                }
                // 若搜索中有两次到达该节点，只记录较早的那一次
                if (len[cur] == -1) {
                    len[cur] = depth;
                }
                List<Integer> children = map.get(cur);
                if (children == null) {
                    continue;
                }
                for (Integer child : children) {
                    if (!visited[child]) {
                        queue.offer(new int[]{child, color == RED ? BLUE : RED});
                        visited[child] = true;
                    }
                }
            }
            depth++;
            // 交替使用图和visited数组
        }
        return len;
    }

    void buildMap(int[][] edges, Map<Integer, List<Integer>> map) {
        for (int[] edge : edges) {
            int i = edge[0], j = edge[1];
            if (!map.containsKey(i)) {
                map.put(i, new ArrayList<>());
            }
            map.get(i).add(j);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
