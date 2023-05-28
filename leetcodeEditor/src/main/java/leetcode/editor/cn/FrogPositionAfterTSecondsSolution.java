package leetcode.editor.cn;
//给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下： 
//
// 
// 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。 
// 青蛙无法跳回已经访问过的顶点。 
// 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。 
// 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。 
// 
//
// 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。 
//
// 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10⁻⁵ 的结果将被视为正确答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
//输出：0.16666666666666666 
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙
//在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。 
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
//输出：0.3333333333333333
//解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。 
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// edges.length == n - 1 
// edges[i].length == 2 
// 1 <= ai, bi <= n 
// 1 <= t <= 50 
// 1 <= target <= n 
// 
//
// 👍 98 👎 0


import java.util.*;

/**
 * T 秒后青蛙的位置
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-25 05:39:37 
 */
public class FrogPositionAfterTSecondsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<Integer>[] map;

    public double frogPosition(int n, int[][] edges, int t, int target) {
        map = new List[n + 1];
        for (int i = 1; i <= n; i++) map[i] = new ArrayList<>();
        for (int[] edge : edges) {
            map[edge[0]].add(edge[1]);
            map[edge[1]].add(edge[0]);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        dfs(1, -1, target, stack);
        // 在时间t没有到达终点
        if (t < stack.size() - 1) return 0;
        // 如果不是叶子节点，需要判断是否刚好到终点
        if (target != 1 && map[target].size() != 1 && t != stack.size() - 1) return 0;
        // 特判根节点
        if (target == 1 && map[target].size() != 0 && t != stack.size() - 1) return 0;
        double ans = 1.0;
        stack.pop();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int size = map[cur].size();
            if (cur != 1) size--;
            ans /= size;
        }
        return ans;
    }

    boolean dfs(int i, int pre, int target, Deque<Integer> stack) {
        stack.push(i);
        if (i == target) {
            return true;
        }
        for (Integer next : map[i]) {
            if (next == pre) continue;
            if (dfs(next, i, target, stack)) return true;
        }
        stack.pop();
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
