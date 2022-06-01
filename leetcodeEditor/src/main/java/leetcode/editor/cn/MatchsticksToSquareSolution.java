package leetcode.editor.cn;
//你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。你要用 所有的火柴棍 拼成一个正方形。你 不能
//折断 任何一根火柴棒，但你可以把它们连在一起，而且每根火柴棒必须 使用一次 。 
//
// 如果你能使这个正方形，则返回 true ，否则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: matchsticks = [1,1,2,2,2]
//输出: true
//解释: 能拼成一个边长为2的正方形，每边两根火柴。
// 
//
// 示例 2: 
//
// 
//输入: matchsticks = [3,3,3,3,4]
//输出: false
//解释: 不能用所有火柴拼成一个正方形。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= matchsticks.length <= 15 
// 1 <= matchsticks[i] <= 10⁸ 
// 
// 👍 343 👎 0


import java.util.Arrays;

/**
 * 火柴拼正方形
 *
 * @author IronSid
 * @since 2022-06-01 15:26:29 
 * @version 1.0
 */
public class MatchsticksToSquareSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] matchsticks;
    private int[] sum;
    private int total;

    public boolean makesquare(int[] matchsticks) {
        int n = matchsticks.length;
        this.matchsticks = matchsticks;
        Arrays.sort(matchsticks);
        sum = new int[4];
        this.total = 0;
        for (int i = 0; i < n; i++) {
            total += matchsticks[i];
        }
        if (total % 4 != 0) {
            return false;
        }
        return dfs(n - 1);
    }

    boolean dfs(int i) {
        if (i == -1) {
            return true;
        }
        loop:
        for (int k = 0; k < 4; k++) {
            if (matchsticks[i] > total / 4 - sum[k]) continue;
            for (int j = 0; j < k; j++) {
                if (sum[j] == sum[k]) continue loop;
            }
            sum[k] += matchsticks[i];
            if (dfs(i - 1)) return true;
            sum[k] -= matchsticks[i];
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
