package leetcode.editor.cn;
//给你一个 n 个节点的树（也就是一个无环连通无向图），节点编号从 0 到 n - 1 ，且恰好有 n - 1 条边，每个节点有一个值。树的 根节点 为 0 
//号点。 
//
// 给你一个整数数组 nums 和一个二维数组 edges 来表示这棵树。nums[i] 表示第 i 个点的值，edges[j] = [uj, vj] 表示节
//点 uj 和节点 vj 在树中有一条边。 
//
// 当 gcd(x, y) == 1 ，我们称两个数 x 和 y 是 互质的 ，其中 gcd(x, y) 是 x 和 y 的 最大公约数 。 
//
// 从节点 i 到 根 最短路径上的点都是节点 i 的祖先节点。一个节点 不是 它自己的祖先节点。 
//
// 请你返回一个大小为 n 的数组 ans ，其中 ans[i]是离节点 i 最近的祖先节点且满足 nums[i] 和 nums[ans[i]] 是 互质的 
//，如果不存在这样的祖先节点，ans[i] 为 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]
//输出：[-1,0,0,1]
//解释：上图中，每个节点的值在括号中表示。
//- 节点 0 没有互质祖先。
//- 节点 1 只有一个祖先节点 0 。它们的值是互质的（gcd(2,3) == 1）。
//- 节点 2 有两个祖先节点，分别是节点 1 和节点 0 。节点 1 的值与它的值不是互质的（gcd(3,3) == 3）但节点 0 的值是互质的(gcd(
//2,3) == 1)，所以节点 0 是最近的符合要求的祖先节点。
//- 节点 3 有两个祖先节点，分别是节点 1 和节点 0 。它与节点 1 互质（gcd(3,2) == 1），所以节点 1 是离它最近的符合要求的祖先节点。
//
// 
//
// 示例 2： 
//
// 
//
// 
//输入：nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
//输出：[-1,0,-1,0,0,0,-1]
// 
//
// 
//
// 提示： 
//
// 
// nums.length == n 
// 1 <= nums[i] <= 50 
// 1 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[j].length == 2 
// 0 <= uj, vj < n 
// uj != vj 
// 
//
// 👍 55 👎 0


import java.util.*;

/**
 * 互质树
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-04-11 16:17:57 
 */
public class TreeOfCoprimesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    static int N = 50;
    // 互质
    static boolean[][] coprime = new boolean[N + 1][N + 1];
    static {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                coprime[i][j] = gcd(i, j) == 1;
            }
        }
    }

    private List<Integer>[] map;
    private int[] nums;
    // {节点值，深度}
    private Deque<int[]>[] stack;
    private int[] res;

    static int gcd(int x, int y) {
        while (y != 0) {
            int t = x % y;
            x = y;
            y = t;
        }
        return x;
    }

    public int[] getCoprimes(int[] nums, int[][] edges) {
        this.nums = nums;
        int n = nums.length;
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            map[u].add(v);
            map[v].add(u);
        }
        res = new int[n];
        stack = new Deque[N + 1];
        for (int i = 1; i <= 50; i++) stack[i] = new ArrayDeque<>();
        dfs(0, -1, 0);
        return res;
    }

    private void dfs(int cur, int prt, int depth) {
        int maxDepth = -1;
        res[cur] = -1;
        for (int i = 1; i <= N; i++) {
            if (coprime[i][nums[cur]]) {
                if (!stack[i].isEmpty() && stack[i].peek()[1] > maxDepth) {
                    maxDepth = stack[i].peek()[1];
                    res[cur] = stack[i].peek()[0];
                }
            }
        }
        stack[nums[cur]].push(new int[]{cur, depth});
        for (Integer nxt : map[cur]) {
            if (nxt == prt) {
                continue;
            }
            dfs(nxt, cur, depth + 1);
        }
        stack[nums[cur]].pop();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
