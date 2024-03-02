package leetcode.editor.cn;
//现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。 
//
// 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给
//你一个整数数组 restricted 表示 受限 节点。 
//
// 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。 
//
// 注意，节点 0 不 会标记为受限节点。 
//
// 
//
// 示例 1： 
// 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
//输出：4
//解释：上图所示正是这棵树。
//在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。 
//
// 示例 2： 
// 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
//
//输出：3
//解释：上图所示正是这棵树。
//在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 0 <= ai, bi < n 
// ai != bi 
// edges 表示一棵有效的树 
// 1 <= restricted.length < n 
// 1 <= restricted[i] < n 
// restricted 中的所有值 互不相同 
// 
//
// 👍 59 👎 0


import java.util.ArrayList;
import java.util.List;

/**
 * 受限条件下可到达节点的数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-03-02 17:02:01 
 */
public class ReachableNodesWithRestrictionsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<Integer>[] map;

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        boolean[] vis = new boolean[n];
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            map[u].add(v);
            map[v].add(u);
        }
        for (int i : restricted) {
            vis[i] = true;
        }
        return dfs(0, vis);
    }

    private int dfs(int cur, boolean[] vis) {
        int cnt = 1;
        vis[cur] = true;
        for (Integer nxt : map[cur]) {
            if (vis[nxt]) continue;
            cnt += dfs(nxt, vis);
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
