package leetcode.editor.cn;

import java.util.*;

/**
 * 重新规划路线
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-11 16:56:51
 */
public class ReorderRoutesToMakeAllPathsLeadToTheCityZeroSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Integer, List<int[]>> map = new HashMap<>();
    private boolean[] visited;

    // direction记录该边和原始边的方向， 1 表示同向，0 表示反向
    void add(int i, int j, int direction) {
        if (!map.containsKey(i)) {
            map.put(i, new ArrayList<>());
        }
        map.get(i).add(new int[]{j, direction});
    }

    public int minReorder(int n, int[][] connections) {
        for (int[] connection : connections) {
            int i = connection[0], j = connection[1];
            add(i, j, 1);
            add(j, i, 0);
        }
        visited = new boolean[n];
        // 0做根节点进行dfs遍历
        // 若某个子节点是通过反向边到达的，则该边不用变更方向，若某个子节点是通过正向边到达的，则该边需要变更方向
        // 所以树中同向边的数量就是需要变更方向的路线数
        return dfs(0);
    }

    // 返回当前节点中对应子树中同向边的数量
    int dfs(int node) {
        visited[node] = true;
        List<int[]> edges = map.get(node);
        int cnt = 0;
        for (int[] edge : edges) {
            int child = edge[0], direction = edge[1];
            if (!visited[child]) {
                cnt += direction + dfs(child);
            }
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
