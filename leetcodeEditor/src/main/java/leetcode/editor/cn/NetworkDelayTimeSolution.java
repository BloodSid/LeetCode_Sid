package leetcode.editor.cn;
//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， 
//wi 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
//
// 👍 822 👎 0


import java.util.*;

/**
 * 网络延迟时间
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-11-30 20:02:31 
 */
public class NetworkDelayTimeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int INF = (int) 1e9;

    public int networkDelayTime(int[][] times, int n, int start) {
        // 邻接表
        List<int[]>[] map = new List[n + 1];
        Arrays.setAll(map, k -> new ArrayList<>());
        for (int[] time : times) {
            int u = time[0], v = time[1], w = time[2];
            map[u].add(new int[]{v, w});
        }
        int achievable = 0;
        // Dijkstra 算法
        // 初始化
        int[] dis = new int[n + 1];
        Arrays.fill(dis, INF);
        dis[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        int max = 0; // 最远点
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0], d = p[1];
            if (d > dis[x]) { // x 之前出堆过
                continue;
            }
            // 每个可达的点只出队一次
            achievable++;
            // 最后一个出队为最远
            max = d;
            for (int[] t : map[x]) {
                int y = t[0], w = t[1];
                if (d + w < dis[y]) { // 入队，更新dis
                    dis[y] = d + w;
                    pq.offer(new int[]{y, d + w});
                }
            }
        }
        return achievable < n ? -1 : max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
