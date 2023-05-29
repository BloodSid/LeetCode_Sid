package leetcode.editor.cn;
//给出二叉树的根节点 root，树上每个节点都有一个不同的值。 
//
// 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。 
//
// 返回森林中的每棵树。你可以按任意顺序组织答案。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
//输出：[[1,2,null,4],[6],[7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,4,null,3], to_delete = [3]
//输出：[[1,2,4]]
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数最大为 1000。 
// 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。 
// to_delete.length <= 1000 
// to_delete 包含一些从 1 到 1000、各不相同的值。 
// 
//
// 👍 208 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 删点成林
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-05-30 00:05:48 
 */
public class DeleteNodesAndReturnForestSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private boolean[] del;
    private List<TreeNode> list;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        del = new boolean[1001];
        for (int i : to_delete) {
            del[i] = true;
        }
        // 伪节点
        del[0] = true;
        list = new ArrayList<>();
        dfs(new TreeNode(0, root, null));
        return list;
    }

    TreeNode dfs(TreeNode cur) {
        if (cur == null) return null;
        cur.left = dfs(cur.left);
        cur.right = dfs(cur.right);
        if (del[cur.val]) {
            if (cur.left != null) list.add(cur.left);
            if (cur.right != null) list.add(cur.right);
            return null;
        }
        return cur;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
