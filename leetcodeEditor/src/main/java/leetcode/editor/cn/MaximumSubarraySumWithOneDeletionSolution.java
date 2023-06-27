package leetcode.editor.cn;
//给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以
//决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。 
//
// 注意，删除一个元素后，子数组 不能为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,-2,0,3]
//输出：4
//解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。 
//
// 示例 2： 
//
// 
//输入：arr = [1,-2,-2,3]
//输出：3
//解释：我们直接选出 [3]，这就是最大和。
// 
//
// 示例 3： 
//
// 
//输入：arr = [-1,-1,-1,-1]
//输出：-1
//解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
//     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i] <= 10⁴ 
// 
//
// 👍 253 👎 0


/**
 * 删除一次得到子数组最大和
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-06-27 21:28:12 
 */
public class MaximumSubarraySumWithOneDeletionSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSum(int[] arr) {
        // dp0 表示以当前元素做结尾的子数组最大和，dp1表示以当前元素做结尾的删除一个元素的子数组最大和
        int dp0 = arr[0];
        int dp1 = 0;
        int res = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            // dp1 + ai 表示选择当前元素， dp0 表示不选当前元素
            dp1 = Math.max(dp1 + arr[i], dp0);
            // dp0 + ai 表示选择左边的元素拼成新结果，ai 表示不选
            dp0 = Math.max(dp0 + arr[i], arr[i]);
            // 更新结果
            res = Math.max(res, Math.max(dp0, dp1));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
