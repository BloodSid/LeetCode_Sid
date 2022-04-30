package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 两棵二叉搜索树中的所有元素
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-01 00:14:23 
 */
public class AllElementsInTwoBinarySearchTreesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root1);
        dfs(res, root2);
        Collections.sort(res);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode node) {
        if (node == null) return;
        dfs(res, node.left);
        res.add(node.val);
        dfs(res, node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
