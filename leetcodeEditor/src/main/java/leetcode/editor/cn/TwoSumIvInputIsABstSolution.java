package leetcode.editor.cn;

import java.util.*;

/**
 * 两数之和 IV - 输入 BST
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 16:50:46
 */
public class TwoSumIvInputIsABstSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] values = new int[10001];

    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        int index = 0;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            values[index++] = root.val;
            root = root.right;
        }
        int l = 0;
        int r = index - 1;
        while (l < r) {
            int sum = values[l] + values[r];
            if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
