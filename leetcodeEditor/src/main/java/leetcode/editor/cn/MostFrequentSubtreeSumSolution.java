package leetcode.editor.cn;
//给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// 👍 168 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出现次数最多的子树元素和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-19 12:04:27 
 */
public class MostFrequentSubtreeSumSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private HashMap<Integer, Integer> map;

    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        dfs(root);
        int max = 0;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                list.clear();
                list.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        int[] res = new int[list.size()];
        int p = 0;
        for (Integer i : list) {
            res[p++] = i;
        }
        return res;
    }

    int dfs(TreeNode node) {
        if (node == null) return 0;
        int sum = dfs(node.left) + dfs(node.right) + node.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
