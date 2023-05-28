package leetcode.editor.cn;
//给你一个 m * n 的矩阵 mat，以及一个整数 k ，矩阵中的每一行都以非递减的顺序排列。 
//
// 你可以从每一行中选出 1 个元素形成一个数组。返回所有可能数组中的第 k 个 最小 数组和。 
//
// 
//
// 示例 1： 
//
// 输入：mat = [[1,3,11],[2,4,6]], k = 5
//输出：7
//解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
//[1,2], [1,4], [3,2], [3,4], [1,6]。其中第 5 个的和是 7 。  
//
// 示例 2： 
//
// 输入：mat = [[1,3,11],[2,4,6]], k = 9
//输出：17
// 
//
// 示例 3： 
//
// 输入：mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
//输出：9
//解释：从每一行中选出一个元素，前 k 个和最小的数组分别是：
//[1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]。其中第 7 个的和是 9 。 
// 
//
// 示例 4： 
//
// 输入：mat = [[1,1,10],[2,2,9]], k = 7
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat.length[i] 
// 1 <= m, n <= 40 
// 1 <= k <= min(200, n ^ m) 
// 1 <= mat[i][j] <= 5000 
// mat[i] 是一个非递减数组 
// 
//
// 👍 136 👎 0


/**
 * 有序矩阵中的第 k 个最小数组和
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-28 11:51:56 
 */
public class FindTheKthSmallestSumOfAMatrixWithSortedRowsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int[][] mat;
    private int m;
    private int n;

    public int kthSmallest(int[][] mat, int k) {
        this.mat = mat;
        m = mat.length;
        n = mat[0].length;
        int l = 0, r = 0;
        for (int i = 0; i < m; i++) {
            l += mat[i][0];
            r += mat[i][n - 1];
        }
        // 对答案进行二分
        while (l <= r) {
            int mid = l + r >> 1;
            if (countLower(0, 0, mid) >= k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    // 计算mat中每一行选一个元素构成的数组中，数组和小于 target 的数组有多少
    int countLower(int i, int sum, int target) {
        // 递归终点
        if (i == m) {
            return 1;
        }
        int ans = 0;
        // 每一行选一个
        for (int j = 0; j < n; j++) {
            // 剪枝
            if (mat[i][j] >= target - sum) break;
            ans += countLower(i + 1, sum + mat[i][j], target);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
