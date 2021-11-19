package leetcode.editor.cn;

import java.util.*;

/**
 * 路径总和 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-19 16:55:25
 */
public class PathSumIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> ans;
    Deque<Integer> stack;
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        stack = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        this.targetSum = targetSum;
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode root, int sum) {
        sum += root.val;
        stack.addLast(root.val);
        if (root.left != null) {
            dfs(root.left, sum);
        }
        if (root.right != null) {
            dfs(root.right, sum);
        }
        if (root.left == null && root.right == null && sum == targetSum) {
            ans.add(new ArrayList<>(stack));
        }
        stack.removeLast();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
