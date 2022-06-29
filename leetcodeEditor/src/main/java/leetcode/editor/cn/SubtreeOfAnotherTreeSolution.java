package leetcode.editor.cn;
//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -10⁴ <= root.val <= 10⁴ 
// -10⁴ <= subRoot.val <= 10⁴ 
// 
// 
// 
// 👍 761 👎 0


import binaryTree.TreeNode;

/**
 * 另一棵树的子树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 17:18:52 
 */
public class SubtreeOfAnotherTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (isIdentical(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    boolean isIdentical(TreeNode n1, TreeNode n2) {
        if (n1 == null || n2 == null) return n1 == null && n2 == null;
        return n1.val == n2.val && isIdentical(n1.left, n2.left) && isIdentical(n1.right, n2.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
