package leetcode.editor.cn;
//给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。 
//
// 由于答案可能很大，因此 返回答案模 10^9 + 7 。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,2,4]
//输出：17
//解释：
//子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
//最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。 
//
// 示例 2： 
//
// 
//输入：arr = [11,81,94,43,3]
//输出：444
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 3 * 10⁴ 
// 1 <= arr[i] <= 3 * 10⁴ 
// 
//
// 
// 👍 432 👎 0


/**
 * 子数组的最小值之和
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-28 00:08:33 
 */
public class SumOfSubarrayMinimumsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int MOD = (int) (1e9 + 7);

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        // pre[i] 表示上一个严格小于 arr[i] 的元素位置
        int[] pre = new int[n];
        // next[i] 表示下一个小于等于 arr[i] 的元素位置
        int[] next = new int[n];
        // 单调栈，栈底到栈顶单调增
        int[] stack = new int[n];
        int p = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            while (p > 0 && arr[stack[p - 1]] >= cur) {
                // 找到小于等于栈顶元素的元素，栈顶元素才出栈，栈顶元素的 next 就是当前元素
                next[stack[--p]] = i;
            }
            // 大于等于当前元素的栈顶元素都出栈，最后栈顶元素就是严格小于当前元素的上一个元素
            pre[i] = p == 0 ? -1 : stack[p - 1];
            stack[p++] = i;
        }
        while (p > 0) {
            next[stack[--p]] = n;
        }
        // 计算每个数作为子数组的最小值对结果的贡献
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * (i - pre[i]) * (next[i] - i);
        }
        return (int) (sum % MOD);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
