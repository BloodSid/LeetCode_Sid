package leetcode.editor.cn;
//给你一个数组 routes ，表示一系列公交线路，其中每个 routes[i] 表示一条公交线路，第 i 辆公交车将会在上面循环行驶。 
//
// 
// 例如，路线 routes[0] = [1, 5, 7] 表示第 0 辆公交车会一直按序列 1 -> 5 -> 7 -> 1 -> 5 -> 7 -> 1 
//-> ... 这样的车站路线行驶。 
// 
//
// 现在从 source 车站出发（初始时不在公交车上），要前往 target 车站。 期间仅可乘坐公交车。 
//
// 求出 最少乘坐的公交车数量 。如果不可能到达终点车站，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：routes = [[1,2,7],[3,6,7]], source = 1, target = 6
//输出：2
//解释：最优策略是先乘坐第一辆公交车到达车站 7 , 然后换乘第二辆公交车到车站 6 。 
// 
//
// 示例 2： 
//
// 
//输入：routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= routes.length <= 500. 
// 1 <= routes[i].length <= 10⁵ 
// routes[i] 中的所有值 互不相同 
// sum(routes[i].length) <= 10⁵ 
// 0 <= routes[i][j] < 10⁶ 
// 0 <= source, target < 10⁶ 
// 
//
// 👍 417 👎 0


import java.util.*;

/**
 * 公交路线
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-09-17 22:36:55 
 */
public class BusRoutesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int b = 0; b < routes.length; b++) {
            int[] route = routes[b];
            for (int stop : route) {
                // 低位bits表示车站，高位bits表示车次。为了避免左移后不变，b不得为0
                int bus = (b + 1) << 20;
                map.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
                map.computeIfAbsent(bus, k -> new ArrayList<>()).add(stop);
            }
        }
        Deque<Integer> q = new ArrayDeque<>();
        HashSet<Integer> vis = new HashSet<>();
        q.offer(source);
        vis.add(source);
        if (!map.containsKey(source) || !map.containsKey(target)) return -1;
        for (int d = 0; !q.isEmpty(); d++) {
            for (int sz = q.size(); sz > 0; sz--) {
                int cur = q.poll();
                if (cur == target) return d / 2;
                for (int next : map.get(cur)) {
                    if (vis.contains(next)) continue;
                    vis.add(next);
                    q.offer(next);
                }
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
