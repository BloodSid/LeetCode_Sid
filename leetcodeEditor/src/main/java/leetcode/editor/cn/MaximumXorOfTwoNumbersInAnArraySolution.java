package leetcode.editor.cn;
//给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁵ 
// 0 <= nums[i] <= 2³¹ - 1 
// 
//
// 👍 626 👎 0


import binaryTree.TreeNode;

/**
 * 数组中两个数的最大异或值
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-11-04 17:06:19
 */
public class MaximumXorOfTwoNumbersInAnArraySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaximumXOR(int[] nums) {
        // 字典树 left 表 0， right 表 1
        TreeNode root = new TreeNode(-1);
        int res = 0;
        for (int ni = 0; ni < nums.length; ni++) {
            int a = nums[ni];
            TreeNode cur = root;
            // 插入字典树
            for (int i = 30; i >= 0; i--) {
                if ((a >> i & 1) == 0) {
                    if (cur.left == null) cur.left = new TreeNode(0);
                    cur = cur.left;
                } else {
                    if (cur.right == null) cur.right = new TreeNode(1);
                    cur = cur.right;
                }
            }
            // 查询
            cur = root;
            int b = 0;
            // 从高位起，找尽量使该位为1的组合
            for (int i = 30; i >= 0; i--) {
                int bit = a >> i & 1 ^ 1;
                if (bit == 0) {
                    if (cur.left != null) {
                        cur = cur.left;
                    } else {
                        cur = cur.right;
                        bit = 1;
                    }
                } else {
                    if (cur.right != null) {
                        cur = cur.right;
                    } else {
                        cur = cur.left;
                        bit = 0;
                    }
                }
                b |= bit << i;
            }
            res = Math.max(res, a ^ b);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
