package leetcode.editor.cn;
//给定一棵二叉树 root，返回所有重复的子树。 
//
// 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。 
//
// 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,2,3,4,null,2,4,null,null,4]
//输出：[[2,4],[4]] 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,1]
//输出：[[1]] 
//
// 示例 3： 
//
// 
//
// 
//输入：root = [2,2,2,3,null,3,null]
//输出：[[2,3],[3]] 
//
// 
//
// 提示： 
//
// 
// 树中的结点数在[1,10^4]范围内。 
// -200 <= Node.val <= 200 
// 
// 👍 474 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 寻找重复的子树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-05 01:41:43 
 */
public class FindDuplicateSubtreesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 种子
    public static final int S1 = 983, S2 = 991, S3 = 997;
    private static final int OFFSET = 201;
    // 记录出现过的子树的哈希到子树的映射
    private HashMap<Integer, TreeNode> seen = new HashMap<>();
    // 记录重复的子树
    private HashSet<TreeNode> repeat = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        // 哈希函数，其中 node.val 加上一个值转化为正数
        int key = (S1 * left ^ S2 * right ^ S3 * (node.val + OFFSET));
        // 没出现过加入 seen 中，出现过则把重复子树中的第一个加入 repeat 中
        if (seen.containsKey(key)) {
            repeat.add(seen.get(key));
        } else {
            seen.put(key, node);
        }
        return key;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
