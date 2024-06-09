package leetcode.editor.cn;
//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
//
// 👍 1363 👎 0


import java.util.Arrays;

/**
 * 戳气球
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-06-09 11:39:12 
 */
public class BurstBalloonsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[] a;
    private int[][] memo;

    public int maxCoins(int[] nums) {
        int n = nums.length;
        a = new int[n + 2];
        memo = new int[n + 2][n + 2];
        for (int[] ints : memo) Arrays.fill(ints, -1);
        System.arraycopy(nums, 0, a, 1, n);
        // 填充两个虚拟气球方便计算
        a[0] = a[n + 1] = 1;
        return f(0, n + 1);
    }

    // 计算 (x,y) 之间的气球全戳破能获得的最大值
    private int f(int x, int y) {
        // 空区间
        if (x >= y - 1) {
            return 0;
        }
        if (memo[x][y] != -1) return memo[x][y];
        int max = 0;
        // 枚举最后一个戳破的气球的位置
        for (int z = x + 1; z <= y - 1; z++) {
            max = Math.max(max, a[z] * a[x] * a[y] + f(x, z) + f(z, y));
        }
        return memo[x][y] = max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
