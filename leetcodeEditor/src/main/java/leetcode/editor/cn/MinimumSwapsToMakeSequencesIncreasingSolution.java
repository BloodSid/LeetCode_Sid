package leetcode.editor.cn;
//我们有两个长度相等且不为空的整型数组 nums1 和 nums2 。在一次操作中，我们可以交换 nums1[i] 和 nums2[i]的元素。 
//
// 
// 例如，如果 nums1 = [1,2,3,8] ， nums2 =[5,6,7,4] ，你可以交换 i = 3 处的元素，得到 nums1 =[1,2,3
//,4] 和 nums2 =[5,6,7,8] 。 
// 
//
// 返回 使 nums1 和 nums2 严格递增 所需操作的最小次数 。 
//
// 数组 arr 严格递增 且 arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1] 。 
//
// 注意： 
//
// 
// 用例保证可以实现操作。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
//输出: 1
//解释: 
//交换 A[3] 和 B[3] 后，两个数组如下:
//A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
//两个数组均为严格递增的。 
//
// 示例 2: 
//
// 
//输入: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 2 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 2 * 10⁵ 
// 
// 👍 248 👎 0


/**
 * 使序列递增的最小交换次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-10 00:13:15 
 */
public class MinimumSwapsToMakeSequencesIncreasingSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int minSwap(int[] n1, int[] n2) {
        int n = n1.length;
        int[][] dp = new int[2][n];
        // i = 0 时，若交换则交换次数为1
        dp[1][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int isOK = 0; isOK < 2; isOK++) {
                int min = Integer.MAX_VALUE;
                // i 与 i - 1 的 isOK 可以相同
                if (n1[i - 1] < n1[i] && n2[i - 1] < n2[i]) min = Math.min(min, dp[isOK][i - 1]);
                // i 与 i - 1 的 isOK 可以不同
                if (n1[i - 1] < n2[i] && n2[i - 1] < n1[i]) min = Math.min(min, dp[isOK ^ 1][i - 1]);
                dp[isOK][i] = min + isOK;
            }
        }
        return Math.min(dp[0][n - 1], dp[1][n - 1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
