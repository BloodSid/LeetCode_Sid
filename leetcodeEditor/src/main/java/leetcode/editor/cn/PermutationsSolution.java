package leetcode.editor.cn;

import java.util.*;

/**
 * 全排列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-20 22:22:02
 */
public class PermutationsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        dfs(0, nums);
        return res;
    }

    void dfs(int idx, int[] nums) {
        if (idx == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                cur.add(nums[i]);
            }
            res.add(cur);
            return;
        }
        for (int i = idx; i < nums.length; i++) {
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
