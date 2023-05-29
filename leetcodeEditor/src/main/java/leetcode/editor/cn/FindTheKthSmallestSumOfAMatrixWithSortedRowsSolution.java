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
    private int m, n, k;
    private int cnt;

    public int kthSmallest(int[][] mat, int k) {
        this.mat = mat;
        m = mat.length;
        n = mat[0].length;
        this.k = k;
        int min = 0, r = 0;
        for (int i = 0; i < m; i++) {
            min += mat[i][0];
            r += mat[i][n - 1];
        }
        int l = min;
        // 对答案进行二分
        while (l <= r) {
            int mid = l + r >> 1;
            cnt = 0;
            // 这样搜索，相当于未递归到的行都已经先取了第一个元素，所以一旦之后的行都取最小也不能小于目标值，就立马剪枝了
            if (dfs(0, mid - min)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // 计算是否可以找到k个小于等于target的数组
    boolean dfs(int i, int target) {
        if (i == m) {
            cnt++;
            return cnt >= k;
        }
        for (int x : mat[i]) {
            // 后面的元素更大，剪枝
            if (x - mat[i][0] > target) break;
            // 凡是进入的分支，一定可以一直搜索到 i=m 的终点。计算过程可以看作在一棵高m，有k个叶子节点的搜索树上遍历，时间复杂度O(mk)
            if (dfs(i + 1, target - x + mat[i][0])) return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
