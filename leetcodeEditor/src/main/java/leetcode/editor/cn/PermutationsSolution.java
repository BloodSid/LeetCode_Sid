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

    List<Integer> list = new ArrayList<>();
    List<Integer> remain = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            remain.add(nums[i]);
        }
        dfs();
        return res;
    }

    void dfs() {
        if (remain.isEmpty()) {
            res.add(new ArrayList<>(list));
            return;
        }
        int size = remain.size();
        for (int i = 0; i < size; i++) {
            list.add(remain.remove(i));
            dfs();
            remain.add(i, list.remove(list.size() - 1));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
