package leetcode.editor.cn;
//现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 
//edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。 
//
// 每个节点都关联一个价格。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价格。 
//
// 给定路径的 价格总和 是该路径上所有节点的价格之和。 
//
// 另给你一个二维整数数组 trips ，其中 trips[i] = [starti, endi] 表示您从节点 starti 开始第 i 次旅行，并通过任何
//你喜欢的路径前往节点 endi 。 
//
// 在执行第一次旅行之前，你可以选择一些 非相邻节点 并将价格减半。 
//
// 返回执行所有旅行的最小价格总和。 
//
// 
//
// 示例 1： 
// 输入：n = 4, edges = [[0,1],[1,2],[1,3]], price = [2,2,10,6], trips = [[0,3],[2,
//1],[2,3]]
//输出：23
//解释：
//上图表示将节点 2 视为根之后的树结构。第一个图表示初始树，第二个图表示选择节点 0 、2 和 3 并使其价格减半后的树。
//第 1 次旅行，选择路径 [0,1,3] 。路径的价格总和为 1 + 2 + 3 = 6 。
//第 2 次旅行，选择路径 [2,1] 。路径的价格总和为 2 + 5 = 7 。
//第 3 次旅行，选择路径 [2,1,3] 。路径的价格总和为 5 + 2 + 3 = 10 。
//所有旅行的价格总和为 6 + 7 + 10 = 23 。可以证明，23 是可以实现的最小答案。 
//
// 示例 2： 
// 输入：n = 2, edges = [[0,1]], price = [2,2], trips = [[0,0]]
//输出：1
//解释：
//上图表示将节点 0 视为根之后的树结构。第一个图表示初始树，第二个图表示选择节点 0 并使其价格减半后的树。 
//第 1 次旅行，选择路径 [0] 。路径的价格总和为 1 。 
//所有旅行的价格总和为 1 。可以证明，1 是可以实现的最小答案。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// edges.length == n - 1 
// 0 <= ai, bi <= n - 1 
// edges 表示一棵有效的树 
// price.length == n 
// price[i] 是一个偶数 
// 1 <= price[i] <= 1000 
// 1 <= trips.length <= 100 
// 0 <= starti, endi <= n - 1 
// 
//
// 👍 109 👎 0


import java.util.*;

/**
 * 最小化旅行的价格总和
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-12-07 11:38:08 
 */
public class MinimizeTheTotalPriceOfTheTripsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] father;
    private int[] p;
    private int[] color;
    private List<Integer>[] map;
    private List<Integer>[] paths;
    private int[] d;
    private int[] dp0;
    private int[] dp1;
    private int[] price;

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        this.price = price;
        map = buildMap(n, edges);
        // 路径端点分组
        paths = buildMap(n, trips);
        // 父节点
        father = new int[n];
        // 并查集根节点
        p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = i;
        }
        // 1 正在访问子树，2 子树已经访问完毕
        color = new int[n];
        // 树上差分数组
        d = new int[n];
        // 离线 tarjan 算法找 lca
        tarjan(0, -1);
        // 不选
        dp0 = new int[n];
        // 选
        dp1 = new int[n];
        // 树上动态规划
        dfs(0, -1);
        return Math.min(dp0[0], dp1[0]);
    }

    // 返回节点在路径上的总次数
    private int dfs(int x, int f) {
        int d0 = 0;
        int d1 = 0;
        int cnt = 0;
        for (Integer next : map[x]) {
            if (next == f) continue;
            cnt += dfs(next, x);
            d0 += Math.min(dp0[next], dp1[next]);
            d1 += dp0[next];
        }
        cnt += d[x];
        dp0[x] = d0 + price[x] * cnt;
        dp1[x] = d1 + price[x] / 2 * cnt;
        return cnt;
    }

    private void tarjan(int x, int f) {
        father[x] = f;
        color[x] = 1;
        for (Integer next : map[x]) {
            if (color[next] != 0) continue;
            tarjan(next, x);
            // 相当于把 next 的子树节点全部合并到 x
            p[next] = x;
        }
        for (Integer y : paths[x]) {
            // x, y 是同一个点或 y 已经遍历完，进行标记
            if (x != y && color[y] != 2) continue;
            // color[y] == 2 意味着 y 所在子树已经遍历完, 也就意味着 y 已合并到它和 x 的 lca 上了，则lca(x,y) = find(y)
            int lca = find(y);
            // 标记差分数组
            d[x]++;
            d[y]++;
            d[lca]--;
            if(father[lca] >= 0 ) d[father[lca]]--;
        }
        // 子树的递归结束
        color[x] = 2;
    }

    int find(int x) {
        if (x != p[x]) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    List<Integer>[] buildMap(int n, int[][] edges) {
        List<Integer>[] res = new List[n];
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            // 特判 x == y 时，只加入一次
            int x = edge[0], y = edge[1];
            res[x].add(y);
            if (y != x) res[y].add(x);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
