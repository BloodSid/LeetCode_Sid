package leetcode.editor.cn;
//在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。 
//
// 如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。 
//
// 我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。 
//
// 只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4], x = 4, y = 3
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//输出：true
// 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [1,2,3,null,4], x = 2, y = 3
//输出：false 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点数介于 2 到 100 之间。 
// 每个节点的值都是唯一的、范围为 1 到 100 的整数。 
// 
//
// 
//
// 👍 328 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的堂兄弟节点
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-02-08 21:03:49 
 */
public class CousinsInBinaryTreeSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int x;
    private int y;
    private int xParent;
    private int yParent;
    private int cnt;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.x = x;
        this.y = y;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        xParent = 0;
        yParent = 0;
        while (!level.isEmpty()) {
            // 这一层 x 和 y 的个数
            cnt = 0;
            List<TreeNode> t = new ArrayList<>();
            for (TreeNode node : level) {
                judgeSon(node, node.left, t);
                judgeSon(node, node.right, t);
            }
            // 不在同一层
            if (cnt == 1) return false;
            if (cnt == 2) {
                return xParent != yParent;
            }
            level = t;
        }
        return false;
    }

    private void judgeSon(TreeNode node, TreeNode son, List<TreeNode> nextLevel) {
        if (son == null) return;
        if (son.val == x) {
            cnt++;
            xParent = node.val;
        }
        if (son.val == y) {
            cnt++;
            yParent = node.val;
        }
        nextLevel.add(son);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
