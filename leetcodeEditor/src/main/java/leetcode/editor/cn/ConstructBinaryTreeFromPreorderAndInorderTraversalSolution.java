package leetcode.editor.cn;

import java.util.*;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-18 17:41:11
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversalSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Integer, Integer> hash;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        hash = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            hash.put(inorder[i], i);
        }
        return buildTree(0, n - 1, preorder, 0, n - 1, inorder);
    }

    TreeNode buildTree(int pStart, int pEnd, int[] preorder, int iStart, int iEnd, int[] inorder) {
        if (pStart > pEnd) {
            return null;
        }
        if (pStart == pEnd) {
            return new TreeNode(preorder[pStart]);
        }
        int rootVal = preorder[pStart];
        int inorderRoot = hash.get(rootVal);
        int leftSize = inorderRoot - iStart;
        int rightSize = iEnd - inorderRoot;
        TreeNode left = buildTree(pStart + 1, pStart + leftSize, preorder,
                iStart, inorderRoot - 1, inorder);
        TreeNode right = buildTree(pEnd - rightSize + 1, pEnd, preorder,
                inorderRoot + 1, iEnd, inorder);
        return new TreeNode(rootVal, left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
