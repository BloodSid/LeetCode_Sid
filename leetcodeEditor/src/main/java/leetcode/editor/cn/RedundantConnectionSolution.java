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

    private int[] p;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        p = new int[n+1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

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
