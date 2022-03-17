package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 可能的二分法
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-17 23:12:07
 */
public class PossibleBipartitionSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] colors;
    public static final int BLUE = 1;
    public static final int RED = 2;
    private Map<Integer, List<Integer>> map;

    void add(int i, int j, Map<Integer, List<Integer>> map) {
        if (!map.containsKey(i)) {
            map.put(i, new ArrayList<>());
        }
        map.get(i).add(j);
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        colors = new int[n + 1];
        map = new HashMap<>();
        // 用不喜欢关系建无向图
        for (int[] dislike : dislikes) {
            int i = dislike[0], j = dislike[1];
            add(i, j, map);
            add(j, i, map);
        }
        for (int i = 1; i <= n; i++) {
            // 该节点未染色，且尝试染色失败
            if (colors[i] == 0 && !dfs(i, BLUE)) {
                return false;
            }
        }
        return true;
    }

    // 使用两种颜色对相邻的节点交替染色
    boolean dfs(int node, int color) {
        if (colors[node] != 0) {
            // 若尝试将一个已染色的节点染成另一颜色，则染色失败
            return colors[node] == color;
        }
        colors[node] = color;
        List<Integer> list = map.get(node);
        if (list != null) {
            for (Integer next : list) {
                if (!dfs(next, color == BLUE ? RED : BLUE)) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
