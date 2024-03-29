package leetcode.editor.cn;
//有一棵根节点为 0 的 家族树 ，总共包含 n 个节点，节点编号为 0 到 n - 1 。给你一个下标从 0 开始的整数数组 parents ，其中 
//parents[i] 是节点 i 的父节点。由于节点 0 是 根 ，所以 parents[0] == -1 。 
//
// 总共有 10⁵ 个基因值，每个基因值都用 闭区间 [1, 10⁵] 中的一个整数表示。给你一个下标从 0 开始的整数数组 nums ，其中 nums[i]
// 是节点 i 的基因值，且基因值 互不相同 。 
//
// 请你返回一个数组 ans ，长度为 n ，其中 ans[i] 是以节点 i 为根的子树内 缺失 的 最小 基因值。 
//
// 节点 x 为根的 子树 包含节点 x 和它所有的 后代 节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：parents = [-1,0,0,2], nums = [1,2,3,4]
//输出：[5,1,1,1]
//解释：每个子树答案计算结果如下：
//- 0：子树包含节点 [0,1,2,3] ，基因值分别为 [1,2,3,4] 。5 是缺失的最小基因值。
//- 1：子树只包含节点 1 ，基因值为 2 。1 是缺失的最小基因值。
//- 2：子树包含节点 [2,3] ，基因值分别为 [3,4] 。1 是缺失的最小基因值。
//- 3：子树只包含节点 3 ，基因值为 4 。1是缺失的最小基因值。
// 
//
// 示例 2： 
//
// 
//
// 输入：parents = [-1,0,1,0,3,3], nums = [5,4,6,2,1,3]
//输出：[7,1,1,4,2,1]
//解释：每个子树答案计算结果如下：
//- 0：子树内包含节点 [0,1,2,3,4,5] ，基因值分别为 [5,4,6,2,1,3] 。7 是缺失的最小基因值。
//- 1：子树内包含节点 [1,2] ，基因值分别为 [4,6] 。 1 是缺失的最小基因值。
//- 2：子树内只包含节点 2 ，基因值为 6 。1 是缺失的最小基因值。
//- 3：子树内包含节点 [3,4,5] ，基因值分别为 [2,1,3] 。4 是缺失的最小基因值。
//- 4：子树内只包含节点 4 ，基因值为 1 。2 是缺失的最小基因值。
//- 5：子树内只包含节点 5 ，基因值为 3 。1 是缺失的最小基因值。
// 
//
// 示例 3： 
//
// 输入：parents = [-1,2,3,0,2,4,1], nums = [2,3,4,5,6,7,8]
//输出：[1,1,1,1,1,1,1]
//解释：所有子树都缺失基因值 1 。
// 
//
// 
//
// 提示： 
//
// 
// n == parents.length == nums.length 
// 2 <= n <= 10⁵ 
// 对于 i != 0 ，满足 0 <= parents[i] <= n - 1 
// parents[0] == -1 
// parents 表示一棵合法的树。 
// 1 <= nums[i] <= 10⁵ 
// nums[i] 互不相同。 
// 
//
// 👍 72 👎 0


import java.util.*;

/**
 * 每棵子树内缺失的最小基因值
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-10-31 10:23:54 
 */
public class SmallestMissingGeneticValueInEachSubtreeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<Integer>[] map;
    private int[] nums;

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        this.nums = nums;
        // 建图
        int n = parents.length;
        map = new List[n];
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < parents.length; i++) {
            if (parents[i] != -1) map[parents[i]].add(i);
        }

        int[] res = new int[n];
        // 除了基因值1的节点到根节点的链上的节点，其他节点都缺失1
        Arrays.fill(res, 1);
        int node;
        for (node = 0; node < n; node++) {
            if (nums[node] == 1) break;
        }
        // 没有基因值1的节点，直接返回
        if (node == n) return res;

        // 从基因值1的节点开始，逐个向上遍历结点
        boolean[] vis = new boolean[n];
        HashSet<Integer> gene = new HashSet<>();
        // 若错把re的赋值写在下面循环内部，则造成时间复杂度变成O(n^2)
        int re = 1;
        for (; node != -1; node = parents[node]) {
            dfs(node, vis, gene);
            while (re <= n && gene.contains(re)) re++;
            res[node] = re;
        }
        return res;
    }

    void dfs(int node, boolean[] vis, HashSet<Integer> gene) {
        gene.add(nums[node]);
        vis[node] = true;
        for (Integer next : map[node]) {
            if (vis[next]) continue;
            dfs(next, vis, gene);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
