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
    private List<TreeNode>[] table = new List[N];

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        List<TreeNode> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (table[i] == null) continue;
            int len = table[i].size();
            boolean[] isDup = new boolean[len];
            for (int i1 = 0; i1 < len; i1++) {
                // 已经发现是重复的就跳过
                if (isDup[i1]) continue;
                TreeNode cur = table[i].get(i1);
                boolean flag = false;
                for (int i2 = i1 + 1; i2 < len; i2++) {
                    if (equals(cur, table[i].get(i2))) {
                        isDup[i2] = true;
                        flag = true;
                    }
                }
                if (flag) res.add(cur);
            }
        }
        return res;
    }

    void dfs(TreeNode node) {
        if (node == null) return;
        if (table[node.val + OFFSET] == null) table[node.val + OFFSET] = new ArrayList<>();
        table[node.val + OFFSET].add(node);
        dfs(node.left);
        dfs(node.right);

    }

    boolean equals(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        return a.val == b.val && equals(a.left, b.left) && equals(a.right, b.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
