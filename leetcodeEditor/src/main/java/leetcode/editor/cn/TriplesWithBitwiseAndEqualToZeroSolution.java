package leetcode.editor.cn;
//给你一个整数数组 nums ，返回其中 按位与三元组 的数目。 
//
// 按位与三元组 是由下标 (i, j, k) 组成的三元组，并满足下述全部条件： 
//
// 
// 0 <= i < nums.length 
// 0 <= j < nums.length 
// 0 <= k < nums.length 
// nums[i] & nums[j] & nums[k] == 0 ，其中 & 表示按位与运算符。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,3]
//输出：12
//解释：可以选出如下 i, j, k 三元组：
//(i=0, j=0, k=1) : 2 & 2 & 1
//(i=0, j=1, k=0) : 2 & 1 & 2
//(i=0, j=1, k=1) : 2 & 1 & 1
//(i=0, j=1, k=2) : 2 & 1 & 3
//(i=0, j=2, k=1) : 2 & 3 & 1
//(i=1, j=0, k=0) : 1 & 2 & 2
//(i=1, j=0, k=1) : 1 & 2 & 1
//(i=1, j=0, k=2) : 1 & 2 & 3
//(i=1, j=1, k=0) : 1 & 1 & 2
//(i=1, j=2, k=0) : 1 & 3 & 2
//(i=2, j=0, k=1) : 3 & 2 & 1
//(i=2, j=1, k=0) : 3 & 1 & 2
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0]
//输出：27
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] < 2¹⁶ 
// 
//
// 👍 126 👎 0


/**
 * 按位与为零的三元组
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-03-04 19:03:50 
 */
public class TriplesWithBitwiseAndEqualToZeroSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countTriplets(int[] nums) {
        int width = 0;
        // 找出数字二进制最大宽度
        for (int num : nums) {
            while (num >> width != 0) {
                width++;
            }
        }
        // 统计每个元素的补集的全部子集, 即统计一个数全部与运算为零的的数的出现次数
        int[] cnt = new int[1 << width];
        int mask = (1 << width) - 1;
        for (int num : nums) {
            // 求补集
            int m = num ^ mask;
            // 遍历子集
            for (int s = m; s > 0; s = (s - 1) & m) {
                cnt[s]++;
            }
        }
        // 子集的特殊情况：空集
        cnt[0] += nums.length;
        int ans = 0;
        // 枚举元素对，每一个元素对x,y和cnt[x&y]中对应元素组成的三元素组连续与运算为零
        for (int i = 0; i < nums.length; i++) {
            // nums[i] 与 nums[i] 构成一对
            ans += cnt[nums[i]];
            for (int j = i + 1; j < nums.length; j++) {
                // nums[i] 和 nums[j]；nums[j] 和 nums[i] 是两对
                ans += cnt[nums[i] & nums[j]] * 2;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
