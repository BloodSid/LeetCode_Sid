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
    private int[] stack;
    private boolean[] vis;
    private int p;
    private int n;
    private int[] nums;

    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        n = nums.length;
        stack = new int[n];
        vis = new boolean[n];
        p = 0;
        dfs(0);
        return res;
    }

    void dfs(int i) {
        if (i == n) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int i1 = 0; i1 < stack.length; i1++) {
                cur.add(stack[i1]);
            }
            res.add(cur);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j]) continue;
            if (j > 0 && vis[j - 1] && nums[j - 1] == nums[j]) continue;
            stack[p++] = nums[j];
            vis[j] = true;
            dfs(i + 1);
            vis[j] = false;
            p--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
