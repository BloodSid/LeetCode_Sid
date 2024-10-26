package leetcode.editor.cn;
//树可以看成是一个连通且 无环 的 无向 图。 
//
// 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信
//息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。 
//
// 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的那个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: edges = [[1,2], [1,3], [2,3]]
//输出: [2,3]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
//输出: [1,4]
// 
//
// 
//
// 提示: 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ai < bi <= edges.length 
// ai != bi 
// edges 中无重复元素 
// 给定的图是连通的 
// 
//
// 👍 646 👎 0


import java.util.*;

/**
 * 冗余连接
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-10-27 00:56:22 
 */
public class RedundantConnectionSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        Set<Integer>[] map = new Set[n + 1];
        Arrays.setAll(map, k -> new HashSet<>());
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            map[u].add(v);
            map[v].add(u);
        }
        // 拓扑排序
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            // 度1的点入队
            if (map[i].size() == 1) q.offer(i);
        }
        while (!q.isEmpty()) {
            int p = q.poll();
            for (Integer nxt : map[p]) {
                map[nxt].remove(p);
                if (map[nxt].size() == 1) q.offer(nxt);
            }
        }
        for (int i = edges.length - 1; i >= 0; i--) {
            int u = edges[i][0], v = edges[i][1];
            if (map[u].size() > 1 && map[v].size() > 1) {
                // 两个点都在环上
                return edges[i];
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
