package leetcode.editor.cn;

import java.util.*;

/**
 * 二叉搜索树的后序遍历序列
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-15 14:08:41
 */
public class ErChaSouSuoShuDeHouXuBianLiXuLieLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int root = Integer.MAX_VALUE;
        // 逆序遍历 [根，右，左]
        for (int i = postorder.length - 1; i >= 0; i--) {
            // 左子树必小于根节点
            if (postorder[i] > root) {
                return false;
            }
            // 一但当前节点小于栈顶节点，说明当前节点是某个节点的左儿子，就要通过循环出栈找到这个节点
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                // 最早入栈且大于当前节点的节点是根节点，当前节点是它的左儿子。
                root = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
