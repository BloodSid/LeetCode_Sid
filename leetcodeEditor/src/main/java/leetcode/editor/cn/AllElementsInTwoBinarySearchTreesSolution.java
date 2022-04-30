package leetcode.editor.cn;

import binaryTree.TreeNode;

import java.util.ArrayList;
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
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(list1, root1);
        dfs(list2, root2);
        return merge(list1, list2);
    }

    private List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        List<Integer> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (true) {
            if (p1 == list1.size() || p2 == list2.size()) {
                break;
            }
            if (list1.get(p1) < list2.get(p2)) {
                res.add(list1.get(p1++));
            } else {
                res.add(list2.get(p2++));
            }
        }
        List<Integer> remain;
        int p;
        if (p1 == list1.size()) {
            remain = list2;
            p = p2;
        } else {
            remain = list1;
            p = p1;
        }
        res.addAll(remain.subList(p, remain.size()));
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
