package leetcode.editor.cn;
//给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入: root = [1,3,2,5,3,null,9]
//输出: [1,3,9]
// 
//
// 示例2： 
//
// 
//输入: root = [1,2,3]
//输出: [1,3]
// 
//
// 
//
// 提示： 
//
// 
// 二叉树的节点个数的范围是 [0,10⁴] 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// 
// 👍 207 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 在每个树行中找最大值
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-24 01:28:22 
 */
public class FindLargestValueInEachTreeRowSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int max;
    private ArrayList<Integer> list;

    public List<Integer> largestValues(TreeNode root) {
        list = new ArrayList<>();
        max = -1;
        dfs(root, 0);
        return list;
    }

    void dfs(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth > max) {
            max = depth;
            list.add(list.size(), node.val);
        } else {
            list.set(depth, Math.max(list.get(depth), node.val));
        }
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
