package leetcode.editor.cn;
//有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。 
//
// 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。 
//
// 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。 
//
// 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, rollMax = [1,1,2,2,2,3]
//输出：34
//解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所
//以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
// 
//
// 示例 2： 
//
// 输入：n = 2, rollMax = [1,1,1,1,1,1]
//输出：30
// 
//
// 示例 3： 
//
// 输入：n = 3, rollMax = [1,1,1,2,2,3]
//输出：181
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// rollMax.length == 6 
// 1 <= rollMax[i] <= 15 
// 
// 👍 200 👎 0


import java.util.Arrays;

/**
 * 掷骰子模拟
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-02-10 23:27:29 
 */
public class DiceRollSimulationSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int dieSimulator(int n, int[] rollMax) {
        int m = 6;
        // f(i, j, k) i 表示骰子次数，j 表示最后一次骰子值，k表示最后值剩余可以连续出现的次数
        int[][][] f = new int[n][m][15];
        for (int j = 0; j < m; j++) {
            Arrays.fill(f[0][j], 1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < rollMax[j]; k++) {
                    long tmp = 0;
                    for (int last = 0; last < m; last++) {
                        if (last != j) {
                            // 和最后一次骰子值不同
                            tmp += f[i - 1][last][rollMax[last] - 1];
                        } else if (k > 0){
                            // 和最后一次骰子值相同
                            tmp += f[i - 1][j][k - 1];
                        }
                    }
                    f[i][j][k] = (int) (tmp % MOD);
                }
            }
        }
        long res = 0;
        for (int j = 0; j < m; j++) {
            res += f[n - 1][j][rollMax[j] - 1];
        }
        return (int) (res % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
