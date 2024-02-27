package leetcode.editor.cn;
//给你一棵 n 个节点的无向树，节点编号为 1 到 n 。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] =
// [ui, vi] 表示节点 ui 和 vi 在树中有一条边。 
//
// 请你返回树中的 合法路径数目 。 
//
// 如果在节点 a 到节点 b 之间 恰好有一个 节点的编号是质数，那么我们称路径 (a, b) 是 合法的 。 
//
// 注意： 
//
// 
// 路径 (a, b) 指的是一条从节点 a 开始到节点 b 结束的一个节点序列，序列中的节点 互不相同 ，且相邻节点之间在树上有一条边。 
// 路径 (a, b) 和路径 (b, a) 视为 同一条 路径，且只计入答案 一次 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]
//输出：4
//解释：恰好有一个质数编号的节点路径有：
//- (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
//- (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
//- (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
//- (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
//只有 4 条合法路径。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]
//输出：6
//解释：恰好有一个质数编号的节点路径有：
//- (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
//- (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
//- (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
//- (1, 6) 因为路径 1 到 6 只包含一个质数 3 。
//- (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
//- (3, 6) 因为路径 3 到 6 只包含一个质数 3 。
//只有 6 条合法路径。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ui, vi <= n 
// 输入保证 edges 形成一棵合法的树。 
// 
//
// 👍 59 👎 0


import java.util.*;

/**
 * 统计树中的合法路径数目
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-27 20:51:06 
 */
public class CountValidPathsInATreeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<Integer>[] map;
    private boolean[] isPrime;
    private int[] dp0;
    private int[] dp1;
    private long res;

    public long countPaths(int n, int[][] edges) {
        isPrime = seive(n);
        map = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            map[u].add(v);
            map[v].add(u);
        }
        // 树形动态规划, 统计以每个节点为起点向下，包含一个和零个素数节点的路径的数量
        dp0 = new int[n + 1];
        dp1 = new int[n + 1];
        res = 0;
        dfs(1, 0);
        return res;
    }

    private void dfs(int cur, int prt) {
        if (isPrime[cur]) {
            dp1[cur] = 1;
        } else {
            dp0[cur] = 1;
        }
        for (Integer nxt : map[cur]) {
            if (nxt == prt) {
                continue;
            }
            dfs(nxt, cur);
            // 乘法原理统计只有一个质数节点的路径
            res += (long) dp0[cur] * dp1[nxt] + (long) dp1[cur] * dp0[nxt];
            // 对nxt与之前的子节点交叉的结果计数后再累加 nxt 的结果，避免重复统计
            if (isPrime[cur]) {
                dp1[cur] += dp0[nxt];
            } else {
                dp0[cur] += dp0[nxt];
                dp1[cur] += dp1[nxt];
            }
        }
    }

    // 利用埃氏筛计算[1,n]的素数
    private boolean[] seive(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[1] = false;
        int p = 2;
        while (p * p <= n) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
            p++;
        }
        return isPrime;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
