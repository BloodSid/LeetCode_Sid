package leetcode.editor.cn;

import java.util.*;

/**
 * 最小高度树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-06 00:04:43 
 */
public class MinimumHeightTreesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashSet<Integer> visited = new HashSet<>();
    private List<List<Integer>> map;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        map = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            map.add(new LinkedList<>());
        }
        for (int[] edge : edges) {
            add(edge[0], edge[1]);
            add(edge[1], edge[0]);
        }
        List<Integer> minRoots = new ArrayList<>();
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            visited.clear();
            int height = dfs(i);
            if (height == minHeight) {
                minRoots.add(i);
            } else if (height < minHeight) {
                minHeight = height;
                minRoots.clear();
                minRoots.add(i);
            }
        }
        return minRoots;
    }

    private void add(int from, int to) {
        map.get(from).add(to);
    }

    private int dfs(int i) {
        visited.add(i);
        int max = 0;
        for (Integer child : map.get(i)) {
            if (!visited.contains(child)) {
                max = Math.max(max, dfs(child));
            }
        }
        return max + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
