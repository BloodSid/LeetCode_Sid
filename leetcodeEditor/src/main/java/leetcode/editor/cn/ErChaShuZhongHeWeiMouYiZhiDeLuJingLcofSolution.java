package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树中和为某一值的路径
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-10 09:42:48 
 */
public class ErChaShuZhongHeWeiMouYiZhiDeLuJingLcofSolution {
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
