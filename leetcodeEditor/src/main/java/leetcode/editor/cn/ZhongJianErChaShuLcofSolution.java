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
    HashMap<Integer, Integer> hash = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            hash.put(inorder[i], i);
        }
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
        int mid = hash.get(val);
        int leftSize = mid - l2;
        node.left = buildTree(l1 + 1, l1 + leftSize, l2, mid - 1);
        node.right = buildTree(l1 + leftSize + 1, r1, mid + 1, r2);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
