package leetcode.editor.cn;

import java.util.*;

/**
 * 可以到达所有点的最少点数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-22 14:27:16
 */
public class MinimumNumberOfVerticesToReachAllNodesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] in = new int[n];
        for (List<Integer> edge : edges) {
            in[edge.get(1)]++;
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
