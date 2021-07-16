package leetcode.editor.cn;
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 
// 👍 1749 👎 0


import java.util.*;
import static java.util.Arrays.*;
import static java.lang.Math.*;
import static java.lang.System.*;

/**
 * 爬楼梯
 *
 * @author IronSid
 * @since 2021-07-17 00:58:22 
 * @version 1.0
 */
public class ClimbingStairsSolution {
    //ctrl+alt+a 加入版本控制

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        for (int i = 0; i < dp.length; i++) {
            if (i == 0 || i == 1) {
                dp[i] = i;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n + 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
