package leetcode.editor.cn;
//给你一个大小为 m x n 的矩阵 mat 和一个整数阈值 threshold。 
//
// 请你返回元素总和小于或等于阈值的正方形区域的最大边长；如果没有这样的正方形区域，则返回 0 。 
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
//输出：2
//解释：总和小于或等于 4 的正方形的最大边长为 2，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], 
//threshold = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 300 
// 0 <= mat[i][j] <= 10⁴ 
// 0 <= threshold <= 10⁵ 
// 
// 👍 98 👎 0


/**
 * 元素和小于等于阈值的正方形的最大边长
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-11 21:38:05 
 */
public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThresholdSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        // 前缀和
        int[][] p = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int[] ints = p[i + 1];
            for (int j = 0, t = 0; j < n; j++) {
                t += mat[i][j];
                ints[j + 1] = t + p[i][j + 1];
            }
        }
        // 对边长进行二分
        int l = 0, r = Math.min(m, n);
        while (l <= r) {
            int mid = l + r >> 1;
            boolean hasLess = false;
            loop:
            for (int i = 0; i < m - mid + 1; i++) {
                for (int j = 0; j < n - mid + 1; j++) {
                    int i1 = i + mid - 1, j1 = j + mid - 1;
                    // 容斥原理
                    int sum = p[i1 + 1][j1 + 1] - p[i1 + 1][j] - p[i][j1 + 1] + p[i][j];
                    if (sum <= threshold) {
                        hasLess = true;
                        break loop;
                    }
                }
            }
            if (hasLess) l = mid + 1;
            else r = mid - 1;
        }
        return r;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
