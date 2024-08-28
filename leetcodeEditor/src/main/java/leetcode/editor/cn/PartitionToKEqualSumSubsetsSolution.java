package leetcode.editor.cn;
//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
// 👍 660 👎 0


import java.util.Arrays;

/**
 * 划分为k个相等的子集
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-20 00:07:46 
 */
public class PartitionToKEqualSumSubsetsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int partSum;
    int n;
    int[] nums;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        n = nums.length;
        this.nums = nums;
        int tot = 0;
        for (int num : nums) {
            tot += num;
        }
        if (tot % k != 0) return false;
        partSum = tot / k;
        return dfs(0, 0, n-1, k);
    }

    // vis 的第i位表示 nums[i] 是否已选择
    boolean dfs(int vis, int sum, int start, int partCnt) {
        if (sum == partSum) {
            // 组成一个符合要求的子集，则归零并从头再找
            sum = 0;
            partCnt--;
            start = n - 1;
            if (partCnt == 0) return true;
        }
        // 接着对之后的元素进行搜索
        for (int i = start; i >= 0; i--) { // 顺序性剪枝
            int cur = nums[i];
            if (((vis >> i) & 1) == 1 || cur + sum > partSum) continue;  // 可行性剪枝
            if (i < start && nums[i] == nums[i+1] && ((vis >> i+1) & 1) == 0) continue; // 跳过相同值
            if (dfs(vis | 1 << i, sum + cur, i - 1, partCnt)) return true;
            if (sum == 0) return false; // 可行性剪枝：因为每轮第一个都选剩下元素中最大的，如果这个元素没有办法分到某组中，那就没有合法分法
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
