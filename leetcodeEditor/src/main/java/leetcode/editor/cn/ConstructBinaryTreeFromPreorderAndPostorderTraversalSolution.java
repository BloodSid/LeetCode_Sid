package leetcode.editor.cn;
//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
//
// 👍 359 👎 0


import binaryTree.TreeNode;

import java.util.HashMap;

/**
 * 根据前序和后序遍历构造二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-22 14:25:36 
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversalSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashMap<Integer, Integer> idx;
    private int n;
    private int[] preorder;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        n = preorder.length;
        this.preorder = preorder;
        // 记录元素在后序遍历的位置
        idx = new HashMap<>();
        for (int i = 0; i < postorder.length; i++) {
            idx.put(postorder[i], i);
        }
        TreeNode root = buildTree(0, n - 1, 0, n - 1);
        return root;
    }

    // 返回 preorder[left:right] 对应的子树
    TreeNode buildTree(int left, int right, int l, int r) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(preorder[left]);
        }
        TreeNode rt = new TreeNode(preorder[left]);
        // 找左右子树的分界。有的情况下无法判断preorder[left+1]对应的是左子树的根节点还是右子树的根节点，这里只考虑左子树的根节点的情况
        int m = idx.get(preorder[left + 1]);
        rt.left = buildTree(left + 1, left + m - l + 1, l, m);
        rt.right = buildTree(left + 1 + m - l + 1, right, m + 1, r - 1);
        return rt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
