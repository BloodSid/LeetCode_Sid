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

    public static final int OFFSET = 200;
    public static final int N = 401;
    private HashMap<String, List<TreeNode>> table = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        List<TreeNode> res = new ArrayList<>();
        for (List<TreeNode> list : table.values()) {
            if (list.size() > 1) res.add(list.get(0));
        }
        return res;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        String serialize = serialize(node);
        if (!table.containsKey(serialize)) table.put(serialize, new ArrayList<>());
        table.get(serialize).add(node);
        dfs(node.left);
        dfs(node.right);
    }

    StringBuilder sb;

    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        sb = new StringBuilder();
        dfs0(root.left);
        sb.append(root.val);
        dfs0(root.right);
        return sb.toString();
    }

    void dfs0(TreeNode node) {
        // 任何子树都被一对括号包起，而树本身不被括号包起
        sb.append('(');
        if (node == null) {
            sb.append('X');
        } else {
            dfs0(node.left);
            sb.append(node.val);
            dfs0(node.right);
        }
        sb.append(')');
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
