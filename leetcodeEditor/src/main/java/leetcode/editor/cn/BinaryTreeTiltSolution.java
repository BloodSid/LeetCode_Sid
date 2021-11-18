package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的坡度
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-18 15:52:39
 */
public class BinaryTreeTiltSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int tilt;

    public int findTilt(TreeNode root) {
        tilt = 0;
        sumAndTilt(root);
        return tilt;
    }

    int sumAndTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sumAndTilt(root.left);
        int rightSum = sumAndTilt(root.right);
        tilt += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
