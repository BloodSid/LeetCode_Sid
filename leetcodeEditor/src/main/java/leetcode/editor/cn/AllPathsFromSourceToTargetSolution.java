package leetcode.editor.cn;

import java.util.*;

/**
 * 所有可能的路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-08 23:56:45
 */
public class AllPathsFromSourceToTargetSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> allPath = new ArrayList<>();
    Deque<Integer> stack = new ArrayDeque<>();
    int[][] graph;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        stack.offerLast(0);
        dfs(0);
        return allPath;
    }

    void dfs(int node) {
        if (node == graph.length - 1) {
            allPath.add(new LinkedList<>(stack));
            return;
        }
        for (int child : graph[node]) {
            stack.offerLast(child);
            dfs(child);
            stack.pollLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
