package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 节点序列的最大得分
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-17 00:28:04
 */
public class MaximumScoreOfANodeSequenceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, List<int[]>> map = new HashMap<>();
    int[] scores;
    int n;

    void add(int x, int y) {
        if (!map.containsKey(x)) {
            map.put(x, new ArrayList<>());
        }
        map.get(x).add(new int[]{y, scores[y]});
    }

    public int maximumScore(int[] scores, int[][] edges) {
        n = scores.length;
        this.scores = scores;
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            add(a, b);
            add(b, a);
        }
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(i)) {
                continue;
            }
            List<int[]> list = map.get(i);
            list.sort((o1, o2) -> o2[1] - o1[1]);
        }
        int max = -1;
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            List<int[]> listA = map.get(a);
            List<int[]> listB = map.get(b);
            for (int i = 0; i < Math.min(3, listA.size()); i++) {
                int[] x = listA.get(i);
                for (int j = 0; j < Math.min(3, listB.size()); j++) {
                    int[] y = listB.get(j);
                    if (a != y[0] && b != x[0] && x[0] != y[0]) {
                        max = Math.max(max, x[1] + y[1] + scores[a] + scores[b]);
                    }
                }
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
