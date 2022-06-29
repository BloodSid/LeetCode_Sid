package leetcode.editor.cn;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// 👍 1109 👎 0


import java.util.*;

/**
 * 全排列 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 19:46:02 
 */
public class PermutationsIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    HashSet<String> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(0, nums);
        return res;
    }

    void dfs(int idx, int[] nums) {
        if (idx == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                cur.add(nums[i]);
            }
            if (set.add(cur.toString())) res.add(cur);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            // 重复数字跳过
            if (i > idx && nums[i] == nums[i - 1]) continue;
            swap(nums, idx, i);
            dfs(idx + 1, nums);
            swap(nums, idx, i);
        }
    }

    void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
