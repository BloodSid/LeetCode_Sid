package leetcode.editor.cn;
//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// 👍 2239 👎 0


import binaryTree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-20 21:47:18 
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversalSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        // 栈，存放当前节点所有还没有考虑过右儿子的祖先节点。栈顶就是当前节点
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 根节点
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        // 指向 inorder 的下标，表示当前节点不断往左走达到的最终节点
        int idx = 0;
        for (int i = 1; i < preorder.length; i++) {
            int val = preorder[i];
            TreeNode newNode = new TreeNode(val);
            TreeNode node = stack.peek();
            // 栈顶和idx指向的元素不相等，说明栈顶节点有左儿子，且就是新节点
            if (node.val != inorder[idx]) {
                node.left = newNode;
            } else {
                // 栈顶和idx指向的元素相等，则向上回溯到第一个有右儿子的节点
                while (!stack.isEmpty() && stack.peek().val == inorder[idx]) {
                    idx++;
                    node = stack.pop();
                }
                node.right = newNode;
            }
            // 当前节点入栈
            stack.push(newNode);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
