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
        // 邻接矩阵
        int[][] map = new int[n+1][n+1];
        for (int[] r : map) Arrays.fill(r, INF);
        for (int[] time : times) map[time[0]][time[1]] = time[2];

        int max = 0; // 最远点
        // Dijkstra 算法
        int[] dis = new int[n + 1]; //  初始化
        Arrays.fill(dis, INF);
        dis[start] = 0;
        boolean[] vis = new boolean[n + 1];
        for (; ; ) {
            // 找离起始点最近且未处理的点
            int x = -1;
            for (int i = 1; i <= n; i++) {
                if (!vis[i] && (x < 0 || dis[i] < dis[x])) {
                    x = i;
                }
            }
            if (x < 0) {
                break; // 所有的点都处理过
            }
            if (dis[x] == INF) {
                return -1;
            }
            max = dis[x]; // 求出的最短路会越来越大
            vis[x] = true; // 最短路长度已确定（无法变得更小）
            for (int y = 1; y <= n; y++) {
                // 邻接矩阵和邻接表不同细节：邻接表遍历到的边都是存在的，邻接矩阵遍历到的点可能是以INF表示的，实际不存在的边
                // 注意，在确保dis[x]+map[x][y]的加法不会溢出时，也可以把这里的if判断省掉
                if(map[x][y] != INF) dis[y] = Math.min(dis[y], dis[x] + map[x][y]); // 更新邻居的最短路
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
