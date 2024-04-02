package leetcode.editor.cn;
//给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。 
//
// 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。 
//
// 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 7
//输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0
//,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
// 
//
// 示例 2： 
//
// 
//输入：n = 3
//输出：[[0,0,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
//
// 👍 375 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有可能的真二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-04-02 15:45:31 
 */
public class AllPossibleFullBinaryTreesSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static List<TreeNode>[] trees = new List[20];
    static {
        trees[1] = new ArrayList<>();
        trees[3] = new ArrayList<>();
        trees[1].add(new TreeNode(0));
        trees[3].add(new TreeNode(0, new TreeNode(0), new TreeNode(0)));
    }

    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) return new ArrayList<>();
        return dfs(n);
    }

    private List<TreeNode> dfs(int n) {
        if (trees[n] != null) {
            return trees[n];
        }
        List<TreeNode> res = new ArrayList<>();
        for (int i = 1; i <= n - 2; i += 2) {
            List<TreeNode> left = dfs(i);
            List<TreeNode> right = dfs(n - 1 - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    res.add(new TreeNode(0, l, r));
                }
            }
        }
        return trees[n] = res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
