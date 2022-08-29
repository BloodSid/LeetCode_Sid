package leetcode.editor.cn;
//最大树 定义：一棵树，并满足：其中每个节点的值都大于其子树中的任何其他值。 
//
// 给你最大树的根节点 root 和一个整数 val 。 
//
// 就像 之前的问题 那样，给定的树是利用 Construct(a) 例程从列表 a（root = Construct(a)）递归地构建的： 
//
// 
// 如果 a 为空，返回 null 。 
// 否则，令 a[i] 作为 a 的最大元素。创建一个值为 a[i] 的根节点 root 。 
// root 的左子树将被构建为 Construct([a[0], a[1], ..., a[i - 1]]) 。 
// root 的右子树将被构建为 Construct([a[i + 1], a[i + 2], ..., a[a.length - 1]]) 。 
// 返回 root 。 
// 
//
// 请注意，题目没有直接给出 a ，只是给出一个根节点 root = Construct(a) 。 
//
// 假设 b 是 a 的副本，并在末尾附加值 val。题目数据保证 b 中的值互不相同。 
//
// 返回 Construct(b) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,1,3,null,null,2], val = 5
//输出：[5,4,null,1,3,null,null,2]
//解释：a = [1,4,2,3], b = [1,4,2,3,5] 
//
// 示例 2： 
// 
//
// 
//输入：root = [5,2,4,null,1], val = 3
//输出：[5,2,4,null,1,null,3]
//解释：a = [2,1,5,4], b = [2,1,5,4,3] 
//
// 示例 3： 
// 
//
// 
//输入：root = [5,2,3,null,1], val = 4
//输出：[5,2,4,null,1,3]
//解释：a = [2,1,5,3], b = [2,1,5,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 100] 内 
// 1 <= Node.val <= 100 
// 树中的所有值 互不相同 
// 1 <= val <= 100 
// 
//
// 
// 👍 67 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大二叉树 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-30 01:06:45 
 */
public class MaximumBinaryTreeIiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private List<Integer> list;

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        list = new ArrayList<>();
        dfs(root);
        list.add(val);
        return construct(list, 0, list.size() - 1);
    }

    private TreeNode construct(List<Integer> list, int start, int end) {
        if (start > end) return null;
        int p = 0;
        int max = 0;
        for (int i = start; i <= end; i++) {
            int val = list.get(i);
            if (val > max) {
                max = val;
                p = i;
            }
        }
        return new TreeNode(max, construct(list, start, p - 1), construct(list, p + 1, end));
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
