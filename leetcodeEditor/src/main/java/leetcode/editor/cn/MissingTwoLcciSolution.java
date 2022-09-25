package leetcode.editor.cn;
//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
// 👍 70 👎 0


/**
 * 消失的两个数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-26 01:31:44 
 */
public class MissingTwoLcciSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] missingTwo(int[] nums) {
        int xorsum = 0;
        int n = nums.length + 2;
        for (int i = 0; i < nums.length; i++) {
            xorsum ^= nums[i];
        }
        for (int i = 1; i <= n; i++) {
            xorsum ^= i;
        }
        int lowestBit = xorsum & (-xorsum);
        int xorsum0 = 0;
        int xorsum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((lowestBit & nums[i]) == 0) {
                xorsum0 ^= nums[i];
            } else {
                xorsum1 ^= nums[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((lowestBit & i) == 0) {
                xorsum0 ^= i;
            } else {
                xorsum1 ^= i;
            }
        }
        return new int[]{xorsum0, xorsum1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
