package leetcode.editor.cn;

import java.util.*;

/**
 * 最接近原点的 K 个点
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-24 21:36:26
 */
public class KClosestPointsToOriginSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // 以距离大小做比较，建立一个大根堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> dis(o2) - dis(o1));
        for (int i = 0; i < k; i++) {
            queue.offer(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            if (dis(queue.peek()) > dis(points[i])) {
                // 若堆顶的点距离更大，则入堆
                queue.poll();
                queue.offer(points[i]);
            }
            // 若堆顶的点距离更小，则当前点比堆中的k个点距离都大，不入堆
        }
        int[][] ans = new int[k][];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    int dis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
