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


import java.util.*;

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

    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int tot = 0;
        for (int num : nums) {
            tot += num;
            list.add(num);
        }
        if (tot % k != 0) return false;
        partSum = tot / k;
        return dfs(list, 0,  0, k);
    }

    boolean dfs(List<Integer> remain, int sum, int start, int partCnt) {
        if (sum == partSum) {
            // 组成一个符合要求的子集，则归零并从头再找
            sum = 0;
            partCnt--;
            start = 0;
            if (partCnt == 0) return true;
        }
        int size = remain.size();
        // 接着对之后的元素进行搜索
        for (int i = start; i < size; i++) {
            if (i > start && remain.get(i) == remain.get(i - 1)) continue;
            int cur = remain.get(i);
            if (cur + sum > partSum) break;
            sum += cur;
            remain.remove(i);
            if (dfs(remain, sum, i, partCnt)) return true;
            remain.add(i, cur);
            sum -= cur;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
