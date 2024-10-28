package leetcode.editor.cn;
//在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。该树除了根节点之外的每一个节点都有且只有一个父节点，而根节
//点没有父节点。 
//
// 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。附加的边包含在 1 到 n 中的两个不同顶点间，这条
//附加的边不属于树中已存在的边。 
//
// 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 
//vi 的一个父节点。 
//
// 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。 
//
// 
//
// 示例 1： 
// 
// 
//输入：edges = [[1,2],[1,3],[2,3]]
//输出：[2,3]
// 
//
// 示例 2： 
// 
// 
//输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
//输出：[4,1]
// 
//
// 
//
// 提示： 
//
// 
// n == edges.length 
// 3 <= n <= 1000 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 
//
// 👍 449 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 冗余连接 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-10-29 02:57:18 
 */
public class RedundantConnectionIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] p;

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }
        List<Integer>[] map = new List[n+1];
        Arrays.setAll(map, k -> new ArrayList<>());
        int cnt2 = -1;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            // 记录每个点的入边
            map[edge[1]].add(edge[0]);
            if (map[edge[1]].size() == 2) {
                // 若有入度为2的点，则必有一边需要删除
                cnt2 = edge[1];
                break;
            }
        }

        // 如果存在入度为2的顶点尝试删除其中一边，判断是否还成树，有可能两边都可以删，所以为了返回最后一个答案，优先判断后出现的
        if (cnt2 != -1) {
            int y = map[cnt2].get(1);
            for (int[] edge : edges) {
                if (edge[0] == y && edge[1] == cnt2) continue;
                if (find(edge[0]) == find(edge[1])) {
                    // 不是树，返回另一边
                    return new int[]{map[cnt2].get(0), cnt2};
                }
                union(edge[0], edge[1]);
            }
            return new int[]{y, cnt2};
        }

        //  如果不存在入度为2的顶点，可以直接删除加入会构成环的边
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            if (find(u) == find(v)) {
                // u,v已经联通，当前边正好闭合一个环
                return edge;
            }
            union(u, v);
        }
        return null;
    }

    int find(int x) {
        return p[x] != x ? p[x] = find(p[x]) : x;
    }

    void union(int x, int y) {
        int rx = find(x);
        int ry = find(y);
        p[rx] = ry;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
