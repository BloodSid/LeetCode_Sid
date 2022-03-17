package leetcode.editor.cn;

/**
 * 判断二分图
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-17 23:38:42
 */
public class IsGraphBipartiteSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static final int BLUE = 1;
    private static final int RED = 2;
    private int n;
    private int[][] graph;
    private int[] colors;

    public boolean isBipartite(int[][] graph) {
        n = graph.length;
        this.graph = graph;
        colors = new int[n];
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0 && !dfs(i, BLUE)) {
                return false;
            }
        }
        return true;
    }

    boolean dfs(int node, int color) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }
        colors[node] = color;
        for (int next : graph[node]) {
            if (!dfs(next, color == BLUE ? RED : BLUE)) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
