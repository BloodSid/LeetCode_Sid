package leetcode.editor.cn;
//给你 n 个长方体 cuboids ，其中第 i 个长方体的长宽高表示为 cuboids[i] = [widthi, lengthi, heighti]（下
//标从 0 开始）。请你从 cuboids 选出一个 子集 ，并将它们堆叠起来。 
//
// 如果 widthi <= widthj 且 lengthi <= lengthj 且 heighti <= heightj ，你就可以将长方体 i 堆叠在
//长方体 j 上。你可以通过旋转把长方体的长宽高重新排列，以将它放在另一个长方体上。 
//
// 返回 堆叠长方体 cuboids 可以得到的 最大高度 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：cuboids = [[50,45,20],[95,37,53],[45,23,12]]
//输出：190
//解释：
//第 1 个长方体放在底部，53x37 的一面朝下，高度为 95 。
//第 0 个长方体放在中间，45x20 的一面朝下，高度为 50 。
//第 2 个长方体放在上面，23x12 的一面朝下，高度为 45 。
//总高度是 95 + 50 + 45 = 190 。
// 
//
// 示例 2： 
//
// 
//输入：cuboids = [[38,25,45],[76,35,3]]
//输出：76
//解释：
//无法将任何长方体放在另一个上面。
//选择第 1 个长方体然后旋转它，使 35x3 的一面朝下，其高度为 76 。
// 
//
// 示例 3： 
//
// 
//输入：cuboids = [[7,11,17],[7,17,11],[11,7,17],[11,17,7],[17,7,11],[17,11,7]]
//输出：102
//解释：
//重新排列长方体后，可以看到所有长方体的尺寸都相同。
//你可以把 11x7 的一面朝下，这样它们的高度就是 17 。
//堆叠长方体的最大高度为 6 * 17 = 102 。
// 
//
// 
//
// 提示： 
//
// 
// n == cuboids.length 
// 1 <= n <= 100 
// 1 <= widthi, lengthi, heighti <= 100 
// 
// 👍 112 👎 0


import java.util.Arrays;

/**
 * 堆叠长方体的最大高度
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-12-10 22:06:12 
 */
public class MaximumHeightByStackingCuboidsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        // 将三边从小到大排列
        for (int[] cuboid : cuboids) {
            Arrays.sort(cuboid);
        }
        // 堆叠条件：w1 <= w2 && l1 <= l2 && h1 <= h2
        // 若两个长方体三个边长分别从小到大排序后不满足堆叠条件，则这两个长方体无论怎么旋转都不能堆叠
        // (逆否命题) => 两个长方体可以堆叠，则三边排序后满足堆叠条件
        // 所以将 cuboids 以 w,l,h 作为关键字进行排序，保证对可以堆叠在 c[i] 上的 c[j] 一定有 j < i
        Arrays.sort(cuboids,
                ((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] != o2[1] ? o1[1] - o2[1] : o1[2] - o2[2]));
        int max = 0;
        // dp[i] 表示用 c[i] 作为最底下的立方体可以堆叠到的高度
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // 一定要从可以堆叠的另一个长方体状态转移过来
                if (cuboids[j][1] <= cuboids[i][1] && cuboids[j][2] <= cuboids[i][2]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            // 可以堆叠的两个长方体都选择最长边作为高度
            dp[i] += cuboids[i][2];
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
