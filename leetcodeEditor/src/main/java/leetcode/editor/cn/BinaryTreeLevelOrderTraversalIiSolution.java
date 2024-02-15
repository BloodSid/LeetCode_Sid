package leetcode.editor.cn;
//给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历） 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[15,7],[9,20],[3]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// 👍 773 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层序遍历 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-15 13:26:29 
 */
public class BinaryTreeLevelOrderTraversalIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        for (int i = 0, j = res.size() - 1; i < j; i++, j--) {
            List<Integer> t = res.get(i);
            res.set(i, res.get(j));
            res.set(j, t);
        }
        return res;
    }

    void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
