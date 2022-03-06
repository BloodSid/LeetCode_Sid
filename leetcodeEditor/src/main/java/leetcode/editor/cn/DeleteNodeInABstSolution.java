package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 删除二叉搜索树中的节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-19 16:55:33
 */
public class DeleteNodeInABstSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
            // 两个子节点：找左子树的最大值代替此节点的值
        } else if (root.left != null && root.right != null) {
            TreeNode max = root.left;
            while (max.right != null) {
                max = max.right;
            }
            root.val = max.val;
            root.left = deleteNode(root.left, root.val);
            //一个或零个子节点：直接用子节点代替此节点
        } else {
            root = root.left == null ? root.right : root.left;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
