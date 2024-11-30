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
    public int networkDelayTime(int[][] times, int n, int k) {
        // 邻接表
        List<List<int[]>> points = new ArrayList<>();
        points.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            points.add(new ArrayList<>());
        }
        for (int[] time : times) {
            points.get(time[0]).add(time);
        }
        // Dijkstra 算法
        // 初始化
        int[] dis = new int[n + 1];
        int POSITIVE_INFINITE = 200;
        Arrays.fill(dis, POSITIVE_INFINITE);
        boolean[] visit = new boolean[n + 1];
        dis[k] = 0;
        visit[k] = true;
        Set<Integer> U = new HashSet<>();
        for (int[] edge : points.get(k)) {
            dis[edge[1]] = edge[2];
            U.add(edge[1]);
        }
        while (U.size() > 0) {
            // 在U中找最近的点p
            int minDis = POSITIVE_INFINITE;
            Integer closestPoint = 0;
            for (Integer p : U) {
                if (dis[p] < minDis) {
                    closestPoint = p;
                    minDis = dis[p];
                }
            }
            // 把点p的邻接的点的距离更新，未访问过的加入U
            for (int[] edge : points.get(closestPoint)) {
                dis[edge[1]] = Math.min(dis[edge[1]], dis[closestPoint] + edge[2]);
                if (!visit[edge[1]]) {
                    U.add(edge[1]);
                }
            }
            // 点p处理完毕，从U中移除
            U.remove(closestPoint);
            visit[closestPoint] = true;
        }

        // 找最远点
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == POSITIVE_INFINITE) {
                return -1;
            }
            max = Math.max(max, dis[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
