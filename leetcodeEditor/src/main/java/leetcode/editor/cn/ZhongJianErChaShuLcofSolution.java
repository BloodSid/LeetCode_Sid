package leetcode.editor.cn;

import java.util.*;

/**
 * 重建二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-15 14:08:04
 */
public class ZhongJianErChaShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = preorder.length;
        return buildTree(0, n - 1, 0, n - 1);
    }

    TreeNode buildTree(int l1, int r1, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        if (l1 == r1) {
            return new TreeNode(preorder[l1]);
        }
        int val = preorder[l1];
        TreeNode node = new TreeNode(val);
        int mid = l2;
        for (; mid < inorder.length; mid++) {
            if (inorder[mid] == val) {
                break;
            }
        }
        int leftsize = mid - l2;
        node.left = buildTree(l1 + 1, l1 + leftsize, l2, mid - 1);
        node.right = buildTree(l1 + leftsize + 1, r1, mid + 1, r2);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
