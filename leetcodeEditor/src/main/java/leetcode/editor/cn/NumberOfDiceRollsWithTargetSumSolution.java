package leetcode.editor.cn;
//这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。 
//
// 给定三个整数 n , k 和 target ，返回可能的方式(从总共 kⁿ 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。 
//
// 答案可能很大，你需要对 10⁹ + 7 取模 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1, k = 6, target = 3
//输出：1
//解释：你扔一个有 6 个面的骰子。
//得到 3 的和只有一种方法。
// 
//
// 示例 2： 
//
// 
//输入：n = 2, k = 6, target = 7
//输出：6
//解释：你扔两个骰子，每个骰子有 6 个面。
//得到 7 的和有 6 种方法：1+6 2+5 3+4 4+3 5+2 6+1。
// 
//
// 示例 3： 
//
// 
//输入：n = 30, k = 30, target = 500
//输出：222616187
//解释：返回的结果必须是对 10⁹ + 7 取模。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, k <= 30 
// 1 <= target <= 1000 
// 
//
// 👍 234 👎 0


import java.util.*;

/**
 * 掷骰子等于目标和的方法数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-10-24 17:14:48 
 */
public class NumberOfDiceRollsWithTargetSumSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int M = (int) (1e9 + 7);
    private int k;
    private int target;
    private HashMap<Integer, Integer> cache;

    public int numRollsToTarget(int n, int k, int target) {
        this.k = k;
        this.target = target;
        cache = new HashMap<>();
        return dfs(n, target);
    }

    // a 次数， b 目标值
    int dfs(int a, int b) {
        if (a == 1) {
            return b >= 1 && b <= k ? 1 : 0;
        }
        return cache.computeIfAbsent(a * target + b - 1, key -> {
            int ta = key / target;
            int tb = key % target + 1;
            // 枚举第ta次大小不同的情况
            long sum = 0;
            for (int i = 1; i <= k; i++) {
                sum += dfs(ta - 1, tb - i);
            }
            return (int) (sum % M);
        });
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
