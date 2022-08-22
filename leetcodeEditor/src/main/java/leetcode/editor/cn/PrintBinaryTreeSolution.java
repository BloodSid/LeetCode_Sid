package leetcode.editor.cn;
//给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，用以表示树的 格式化布局 。构造此格式化布局矩
//阵需要遵循以下规则： 
//
// 
// 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。 
// 矩阵的列数 n 应该等于 2ʰᵉⁱᵍʰᵗ⁺¹ - 1 。 
// 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。 
// 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] ，右子节点放置在 
//res[r+1][c+2ʰᵉⁱᵍʰᵗ⁻ʳ⁻¹] 。 
// 继续这一过程，直到树中的所有节点都妥善放置。 
// 任意空单元格都应该包含空字符串 "" 。 
// 
//
// 返回构造得到的矩阵 res 。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2]
//输出：
//[["","1",""],
// ["2","",""]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3,null,4]
//输出：
//[["","","","1","","",""],
// ["","2","","","","3",""],
// ["","","4","","","",""]]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 2¹⁰] 内 
// -99 <= Node.val <= 99 
// 树的深度在范围 [1, 10] 内 
// 
// 👍 187 👎 0


import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-08-22 22:12:24 
 */
public class PrintBinaryTreeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int depth;

    public List<List<String>> printTree(TreeNode root) {
        depth = depth(root);
        List<List<String>> res = new ArrayList<>();
        int n = (1 << depth) - 1;
        for (int i = 0; i < depth; i++) {
            List<String> line = new ArrayList<>();
            res.add(line);
            for (int i1 = 0; i1 < n; i1++) {
                line.add("");
            }
        }
        dfs(root, 0, (n - 1) / 2, res);
        return res;
    }

    void dfs(TreeNode node, int r, int c, List<List<String>> grid) {
        if (node == null) return;
        grid.get(r).set(c, Integer.toString(node.val));
        dfs(node.left, r + 1, c - (1 << depth - r - 2), grid);
        dfs(node.right, r + 1, c + (1 << depth - r - 2), grid);
    }
    int depth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(depth(node.left), depth(node.right)) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
