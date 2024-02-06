package leetcode.editor.cn;
//给你一棵二叉树的根 root ，请你将每个节点的值替换成该节点的所有 堂兄弟节点值的和 。 
//
// 如果两个节点在树中有相同的深度且它们的父节点不同，那么它们互为 堂兄弟 。 
//
// 请你返回修改值之后，树的根 root 。 
//
// 注意，一个节点的深度指的是从树根节点到这个节点经过的边数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,9,1,10,null,7]
//输出：[0,0,0,7,7,null,11]
//解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
//- 值为 5 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 4 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 9 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 1 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
//- 值为 10 的节点有一个堂兄弟，值为 7 ，所以值修改为 7 。
//- 值为 7 的节点有两个堂兄弟，值分别为 1 和 10 ，所以值修改为 11 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [3,1,2]
//输出：[0,0,0]
//解释：上图展示了初始的二叉树和修改每个节点的值之后的二叉树。
//- 值为 3 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 1 的节点没有堂兄弟，所以值修改为 0 。
//- 值为 2 的节点没有堂兄弟，所以值修改为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目的范围是 [1, 10⁵] 。 
// 1 <= Node.val <= 10⁴ 
// 
//
// 👍 17 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的堂兄弟节点 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-07 00:19:34 
 */
public class CousinsInBinaryTreeIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        root.val = 0;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> t = new ArrayList<>();
            // 遍历当前层，计算下一层的之和
            int levelSum = 0;
            for (TreeNode node : level) {
                if (node.left != null) {
                    t.add(node.left);
                    levelSum += node.left.val;
                }
                if (node.right != null) {
                    t.add(node.right);
                    levelSum += node.right.val;
                }
            }
            // 遍历当前层，把下一层的值变为堂兄弟之和
            for (TreeNode node : level) {
                int childrenSum = 0;
                if (node.left != null) childrenSum += node.left.val;
                if (node.right != null) childrenSum += node.right.val;
                if (node.left != null) node.left.val = levelSum - childrenSum;
                if (node.right != null) node.right.val = levelSum - childrenSum;
            }
            level = t;
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
