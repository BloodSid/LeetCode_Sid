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


import java.util.Arrays;

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

    private int[][] dp;
    private int[] n1;
    private int[] n2;

    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        n1 = nums1;
        n2 = nums2;
        dp = new int[2][n];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return Math.min(f(n - 1, 1), f(n - 1, 0));
    }

    // isOK 表示当前位置是否交换
    int f(int i, int isOK) {
        if (i == 0) return isOK;
        if (dp[isOK][i] != -1) return dp[isOK][i];
        int min = Integer.MAX_VALUE;
        // i 与 i - 1 的 isOK 可以相同
        if (n1[i - 1] < n1[i] && n2[i - 1] < n2[i]) min = Math.min(min, f(i - 1, isOK));
        // i 与 i - 1 的 isOK 可以不同
        if (n1[i - 1] < n2[i] && n2[i - 1] < n1[i]) min = Math.min(min, f(i - 1, isOK ^ 1));
        // 若 i 交换，结果需要加一
        dp[isOK][i] = min + isOK;
        return dp[isOK][i];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
