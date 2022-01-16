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
    int[] postorder;
    int[] lastSmaller;

    public boolean verifyPostorder(int[] postorder) {
        this.postorder = postorder;
        lastSmaller = new int[postorder.length];
        // 单调栈，确定数组中每个元素的上一个更小元素的下标
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < postorder.length; i++) {
            while (!stack.isEmpty() && postorder[stack.peek()] >= postorder[i]) {
                stack.pop();
            }
            lastSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return verifyPostorder(0, postorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // left 和 right 表示一个子树在数组中对应的范围
    boolean verifyPostorder(int left, int right, int lower, int upper) {
        // 空节点
        if (left > right) {
            return true;
        }
        // postorder[right]是该子树的根节点
        if (postorder[right] <= lower || postorder[right] >= upper) {
            return false;
        }
        // 递归检查左右子树
        return verifyPostorder(left, lastSmaller[right], lower, postorder[right])
                && verifyPostorder(lastSmaller[right] + 1, right - 1, postorder[right], upper);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
