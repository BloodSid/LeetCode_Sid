package leetcode.editor.cn;

import java.util.*;

/**
 * 到达目的地的第二短时间
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-24 12:24:25
 */
public class SecondMinimumTimeToReachDestinationSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // 建图
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        // 堆里的元素 {p, t, arrival} p表示点，t表示已经经过的时间，arrival表示从别的点到达该点
        int ARRIVAL = 1, WAIT = 0;
        int fast = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.offer(new int[]{1, 0, WAIT});
        while (!pq.isEmpty()) {
            // pq.forEach(o -> System.out.print(Arrays.toString(o)));
            // System.out.println();
            int[] cur = pq.poll();
            int p = cur[0];
            int t = cur[1];
            if (p == n && cur[2] == ARRIVAL) {
                if (fast == 0) {
                    fast = t;
                } else if (t == fast) {
                    continue;
                } else {
                    return t;
                }
            }
            if ((t / change & 1) == 1) {
                // 红灯
                pq.offer(new int[]{p, (t / change + 1) * change, WAIT});
            } else {
                // 绿灯
                for (Integer neighbor : map.get(p)) {
                    pq.offer(new int[]{neighbor, t + time, ARRIVAL});
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
