package leetcode.editor.cn;
//假设你是一家合金制造公司的老板，你的公司使用多种金属来制造合金。现在共有 n 种不同类型的金属可以使用，并且你可以使用 k 台机器来制造合金。每台机器都需要
//特定数量的每种金属来创建合金。 
//
// 对于第 i 台机器而言，创建合金需要 composition[i][j] 份 j 类型金属。最初，你拥有 stock[i] 份 i 类型金属，而每购入一份
// i 类型金属需要花费 cost[i] 的金钱。 
//
// 给你整数 n、k、budget，下标从 1 开始的二维数组 composition，两个下标从 1 开始的数组 stock 和 cost，请你在预算不超过
// budget 金钱的前提下，最大化 公司制造合金的数量。 
//
// 所有合金都需要由同一台机器制造。 
//
// 返回公司可以制造的最大合金数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0,0,0
//], cost = [1,2,3]
//输出：2
//解释：最优的方法是使用第 1 台机器来制造合金。
//要想制造 2 份合金，我们需要购买：
//- 2 份第 1 类金属。
//- 2 份第 2 类金属。
//- 2 份第 3 类金属。
//总共需要 2 * 1 + 2 * 2 + 2 * 3 = 12 的金钱，小于等于预算 15 。
//注意，我们最开始时候没有任何一类金属，所以必须买齐所有需要的金属。
//可以证明在示例条件下最多可以制造 2 份合金。
// 
//
// 示例 2： 
//
// 
//输入：n = 3, k = 2, budget = 15, composition = [[1,1,1],[1,1,10]], stock = [0,0,1
//00], cost = [1,2,3]
//输出：5
//解释：最优的方法是使用第 2 台机器来制造合金。 
//要想制造 5 份合金，我们需要购买： 
//- 5 份第 1 类金属。
//- 5 份第 2 类金属。 
//- 0 份第 3 类金属。 
//总共需要 5 * 1 + 5 * 2 + 0 * 3 = 15 的金钱，小于等于预算 15 。 
//可以证明在示例条件下最多可以制造 5 份合金。
// 
//
// 示例 3： 
//
// 
//输入：n = 2, k = 3, budget = 10, composition = [[2,1],[1,2],[1,1]], stock = [1,1]
//, cost = [5,5]
//输出：2
//解释：最优的方法是使用第 3 台机器来制造合金。
//要想制造 2 份合金，我们需要购买：
//- 1 份第 1 类金属。
//- 1 份第 2 类金属。
//总共需要 1 * 5 + 1 * 5 = 10 的金钱，小于等于预算 10 。
//可以证明在示例条件下最多可以制造 2 份合金。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n, k <= 100 
// 0 <= budget <= 10⁸ 
// composition.length == k 
// composition[i].length == n 
// 1 <= composition[i][j] <= 100 
// stock.length == cost.length == n 
// 0 <= stock[i] <= 10⁸ 
// 1 <= cost[i] <= 100 
// 
//
// 👍 62 👎 0


import java.util.*;

/**
 * 最大合金数
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-01-27 23:37:39 
 */
public class MaximumNumberOfAlloysSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int[][] cs = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                cs[i][j] = composition.get(i).get(j);
            }
        }
        int[] stk = new int[n];
        int[] cst = new int[n];
        for (int i = 0; i < n; i++) {
            stk[i] = stock.get(i);
            cst[i] = cost.get(i);
        }
        int res = 0;
        for (int ki = 0; ki < k; ki++) {
            int[] c = cs[ki];
            // 二分制作合金的份数
            int l = 0, r = (int) 1e9;
            while (l <= r) {
                int mid = l + r >>> 1;
                long sumCost = 0;
                for (int i = 0; i < n; i++) {
                    sumCost += (long) cst[i] * Math.max(0, (long) mid * c[i] - stk[i]);
                }
                if (sumCost > budget) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            res = Math.max(res, r);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
