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

    public static final int P = 179;
    public static final int Q = 31;
    public static final int MOD = 100003;
    private int sub;
    private boolean isSubtree;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 初始化为在第一次dfs中必不会相等的值
        sub = MOD;
        isSubtree = false;
        sub = treeHash(subRoot)[0];
        if (sub == treeHash(root)[0]) {
            return true;
        }
        return isSubtree;
    }

    // 返回值 {hash，size}
    int[] treeHash(TreeNode node) {
        if (node == null) {
            // null 的哈希值不能是任何节点的值
            return new int[]{10001, 0};
        }
        int[] l = treeHash(node.left), r = treeHash(node.right);
        if (l[0] == sub || r[0] == sub) {
            isSubtree = true;
        }
        // size 计算时加一，避免空指针时乘0
        return new int[]{(node.val + P * l[0] * (l[1] + 1) + Q * r[0] * (r[1] + 1)) % MOD, 1 + l[1] + r[1]};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
