package leetcode.editor.cn;
//给你一个正整数 p 。你有一个下标从 1 开始的数组 nums ，这个数组包含范围 [1, 2ᵖ - 1] 内所有整数的二进制形式（两端都 包含）。你可以进
//行以下操作 任意 次： 
//
// 
// 从 nums 中选择两个元素 x 和 y 。 
// 选择 x 中的一位与 y 对应位置的位交换。对应位置指的是两个整数 相同位置 的二进制位。 
// 
//
// 比方说，如果 x = 1101 且 y = 0011 ，交换右边数起第 2 位后，我们得到 x = 1111 和 y = 0001 。 
//
// 请你算出进行以上操作 任意次 以后，nums 能得到的 最小非零 乘积。将乘积对 10⁹ + 7 取余 后返回。 
//
// 注意：答案应为取余 之前 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = 1
//输出：1
//解释：nums = [1] 。
//只有一个元素，所以乘积为该元素。
// 
//
// 示例 2： 
//
// 
//输入：p = 2
//输出：6
//解释：nums = [01, 10, 11] 。
//所有交换要么使乘积变为 0 ，要么乘积与初始乘积相同。
//所以，数组乘积 1 * 2 * 3 = 6 已经是最小值。
// 
//
// 示例 3： 
//
// 
//输入：p = 3
//输出：1512
//解释：nums = [001, 010, 011, 100, 101, 110, 111]
//- 第一次操作中，我们交换第二个和第五个元素最左边的数位。
//    - 结果数组为 [001, 110, 011, 100, 001, 110, 111] 。
//- 第二次操作中，我们交换第三个和第四个元素中间的数位。
//    - 结果数组为 [001, 110, 001, 110, 001, 110, 111] 。
//数组乘积 1 * 6 * 1 * 6 * 1 * 6 * 7 = 1512 是最小乘积。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= p <= 60 
// 
//
// 👍 33 👎 0


/**
 * 数组元素的最小非零乘积
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-03-20 00:34:14 
 */
public class MinimumNonZeroProductOfTheArrayElementsSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static final int M = (int) 1e9 + 7;

    public int minNonZeroProduct(int p) {
        // nums 中除了一个全是1的，剩下的可以两两一对互成p位反码。把每一对都转化成1和2^p-2
        long n = (1L << p) - 1;
        return (int) (n % M * pow(n - 1, (n - 1) / 2) % M);
    }

    // 快速幂模板
    private long pow(long a, long b) {
        long res = 1L;
        for (a %= M; b > 0; b >>= 1) {
            if ((b & 1) == 1) {
                res = res * a % M;
            }
            a = a * a % M;
        }
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}
