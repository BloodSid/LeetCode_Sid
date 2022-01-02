package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉树的镜像
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-02 18:11:57
 */
public class ErChaShuDeJingXiangLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode mirrorNode = new TreeNode(root.val);
        mirrorNode.right = mirrorTree(root.left);
        mirrorNode.left = mirrorTree(root.right);
        return mirrorNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
