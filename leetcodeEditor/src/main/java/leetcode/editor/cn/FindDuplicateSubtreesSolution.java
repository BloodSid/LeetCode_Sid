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
import javafx.util.Pair;

import java.util.*;

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

    // 记录出现过的子树的哈希到子树的映射, String 是 {val, l, r} 形式的唯一表示
    private HashMap<String, Pair<TreeNode, Integer>> seen = new HashMap<>();
    // 记录重复的子树
    private HashSet<TreeNode> repeat = new HashSet<>();
    int idx = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return new ArrayList<>(repeat);
    }

    int dfs(TreeNode node) {
        if (node == null) return 0;
        int[] tuple = {node.val, dfs(node.left), dfs(node.right)};
        String key = Arrays.toString(tuple);
        if (seen.containsKey(key)) {
            Pair<TreeNode, Integer> pair = seen.get(key);
            repeat.add(pair.getKey());
            return pair.getValue();
        } else {
            seen.put(key, new Pair<>(node, ++idx));
            return idx;
        }
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
