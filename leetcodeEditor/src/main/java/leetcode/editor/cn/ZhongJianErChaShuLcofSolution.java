package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.HashMap;

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
        return buildTree(0, 0, n - 1);
    }

    // mid代表父节点在preorder中的下标，left和right代表父节点及其左右子树在inorder中的范围
    TreeNode buildTree(int parent, int left, int right) {
        if (left > right) {
            return null;
        }
        int val = preorder[parent];
        TreeNode node = new TreeNode(val);
        // 划分父节点，左子树，右子树
        int mid = hash.get(val);
        node.left = buildTree(parent + 1, left, mid - 1);
        node.right = buildTree(parent + mid - left + 1, mid + 1, right);
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
