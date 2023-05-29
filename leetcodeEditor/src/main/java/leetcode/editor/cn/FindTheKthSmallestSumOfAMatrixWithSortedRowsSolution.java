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


import java.util.Arrays;
import java.util.PriorityQueue;

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
    public int kthSmallest(int[][] mat, int k) {
        int[] res = mat[0];
        for (int i = 1; i < mat.length; i++) {
            res = kSmallestPairs(res, mat[i], k);
        }
        return res[k - 1];
    }

    // 373. 查找和最小的 K 对数字
    public int[] kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length, len2 = nums2.length;
        int size = (int) Math.min((long) len1 * len2, k);
        int[] ans = new int[size];
        // {i1, i2, sum}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        pq.offer(new int[]{0, 0, nums1[0] + nums2[0]});
        for (int i = 0; i < size; i++) {
            int[] p = pq.poll();
            int i1 = p[0], i2 = p[1];
            ans[i] = p[2];
            // 通过规定顺序避免重复访问
            if (i1 == 0 && i2 < len2 - 1) {
                pq.offer(new int[]{i1, i2 + 1, nums1[i1] + nums2[i2 + 1]});
            }
            if (i1 < len1 - 1) {
                pq.offer(new int[]{i1 + 1, i2, nums1[i1 + 1] + nums2[i2]});
            }
        }
        System.out.println("ans = " + Arrays.toString(ans));
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
