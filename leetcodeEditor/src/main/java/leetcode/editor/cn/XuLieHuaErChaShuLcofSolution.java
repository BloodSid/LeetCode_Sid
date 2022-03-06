package leetcode.editor.cn;

import binaryTree.TreeNode;

/**
 * 序列化二叉树
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-23 13:14:31
 */
public class XuLieHuaErChaShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
public class Codec {
    StringBuilder sb;

    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        sb = new StringBuilder();
        dfs(root.left);
        sb.append(root.val);
        dfs(root.right);
        return sb.toString();
    }

    void dfs(TreeNode node) {
        // 任何子树都被一对括号包起，而树本身不被括号包起
        sb.append('(');
        if (node == null) {
            sb.append('X');
        } else {
            dfs(node.left);
            sb.append(node.val);
            dfs(node.right);
        }
        sb.append(')');
    }

    int ptr;
    String data;

    public TreeNode deserialize(String data) {
        ptr = 0;
        this.data = data;
        return parse();
    }

    TreeNode parse() {
        if (data.charAt(ptr) == 'X') {
            ptr++;
            return null;
        }
        TreeNode cur = new TreeNode();
        cur.left = parseSubTree();
        cur.val = parseInt();
        cur.right = parseSubTree();
        return cur;
    }

    int parseInt() {
        int sum = 0;
        boolean isNegative = false;
        if (data.charAt(ptr) == '-') {
            isNegative = true;
            ptr++;
        }
        while (data.charAt(ptr) >= '0' && data.charAt(ptr) <= '9') {
            sum = sum * 10 + (data.charAt(ptr) & 15);
            ptr++;
        }
        if (isNegative) {
            return -sum;
        }
        return sum;
    }

    TreeNode parseSubTree() {
        // 跳过左括号
        ptr++;
        TreeNode subTree = parse();
        // 跳过右括号
        ptr++;
        return subTree;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
