package leetcode.editor.cn;

import java.util.*;

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
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X";
        }
        String left = "(" + serialize(root.left) + ")";
        String right = "(" + serialize(root.right) + ")";
        return left + root.val + right;
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
