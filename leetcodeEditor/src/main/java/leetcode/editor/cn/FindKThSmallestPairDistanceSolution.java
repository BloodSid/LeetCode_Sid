package leetcode.editor.cn;
//数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。 
//
// 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。
//返回 所有数对距离中 第 k 小的数对距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1], k = 1
//输出：0
//解释：数对和对应的距离如下：
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//距离第 1 小的数对是 (1,1) ，距离为 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,6,1], k = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 2 <= n <= 10⁴ 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= n * (n - 1) / 2 
// 
// 👍 325 👎 0


import java.util.*;

/**
 * 找出第 K 小的数对距离
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-15 15:15:30 
 */
public class FindKThSmallestPairDistanceSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, r = nums[n - 1] - nums[0];
        while (l <= r) {
            int cnt = 0;
            int mid = l + r >> 1;
            int fast = 0;
            for (int slow = 0; slow < n; slow++) {
                int cur = nums[slow];
                for (; fast < n; fast++) {
                    if (nums[fast] - cur > mid) {
                        break;
                    }
                }
                cnt += fast - slow - 1;
            }
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
