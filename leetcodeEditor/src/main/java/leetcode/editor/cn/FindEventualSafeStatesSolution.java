package leetcode.editor.cn;

import java.util.*;

/**
 * 找到最终的安全状态
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-09 17:06:43
 */
public class FindEventualSafeStatesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // colors[i] 可以是0，1，2。0表示未访问，1表示在递归栈中或者在环中，2表示已访问且是安全节点
    int[] colors;
    int[][] graph;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        colors = new int[n];
        this.graph = graph;
        List<Integer> safe = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i)) {
                safe.add(i);
            }
        }
        return safe;
    }

    boolean dfs(int node) {
        if (colors[node] != 0) {
            return colors[node] == 2;
        }
        colors[node] = 1;
        for (int next : graph[node]) {
            if(!dfs(next)) return false;
        }
        colors[node] = 2;
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
