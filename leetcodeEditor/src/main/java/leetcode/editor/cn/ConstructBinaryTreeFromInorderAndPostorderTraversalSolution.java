package leetcode.editor.cn;
//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// 👍 1183 👎 0


import binaryTree.TreeNode;

import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-21 14:27:25 
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversalSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int n;
    private int[] postorder;
    private HashMap<Integer, Integer> idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        n = inorder.length;
        this.postorder = postorder;
        // 记录元素在中序遍历中的下标
        idx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            idx.put(inorder[i], i);
        }
        return buildTree(0, n - 1, 0, n - 1);
    }

    // 生成后序遍历中下范围【left,right】的子树
    private TreeNode buildTree(int left, int right, int l, int r) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(postorder[right]);
        }
        // 根节点
        int val = postorder[right];
        TreeNode rt = new TreeNode(val);
        // 确定左右子树的分界线，进一步确定左右子树元素个数
        int m = idx.get(val);
        rt.left = buildTree(left, left + m - l - 1, l, m - 1);
        rt.right = buildTree(left + m - l, right - 1, m + 1, r);
        return rt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
