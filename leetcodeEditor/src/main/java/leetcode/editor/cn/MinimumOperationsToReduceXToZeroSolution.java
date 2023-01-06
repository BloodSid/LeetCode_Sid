package leetcode.editor.cn;
//给你一个整数数组 nums 和一个整数 x 。每一次操作时，你应当移除数组 nums 最左边或最右边的元素，然后从 x 中减去该元素的值。请注意，需要 修改
// 数组以供接下来的操作使用。 
//
// 如果可以将 x 恰好 减到 0 ，返回 最小操作数 ；否则，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,4,2,3], x = 5
//输出：2
//解释：最佳解决方案是移除后两个元素，将 x 减到 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [5,6,7,8,9], x = 4
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,2,20,1,1,3], x = 10
//输出：5
//解释：最佳解决方案是移除后三个元素和前两个元素（总共 5 次操作），将 x 减到 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁴ 
// 1 <= x <= 10⁹ 
// 
// 👍 136 👎 0


import java.util.HashMap;

/**
 * 将 x 减到 0 的最小操作数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-01-07 02:22:02 
 */
public class MinimumOperationsToReduceXToZeroSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int[] p1 = new int[n + 1], p2 = new int[n + 1];
        for (int i = 0, t = 0; i < n; i++) {
            t += nums[i];
            p1[i + 1] = t;
        }
        for (int i = 0, t = 0; i < n; i++) {
            t += nums[n - 1 - i];
            p2[i + 1] = t;
        }
        int min = n + 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < p1.length; i++) {
            map.put(p1[i], i);
        }
        for (int i = 0; i < p2.length; i++) {
            if (map.containsKey(x - p2[i])) {
                min = Math.min(min, i + map.get(x - p2[i]));
            }
        }
        return min == n + 1 ? -1 : min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
