package leetcode.editor.cn;
//给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 5, right = 7
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：left = 0, right = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：left = 1, right = 2147483647
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= left <= right <= 2³¹ - 1 
// 
// 👍 388 👎 0


/**
 * 数字范围按位与
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-06-29 21:08:48 
 */
public class BitwiseAndOfNumbersRangeSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // 所有的数字按位与之后，凡是某一位上有 0 ，则这位的结果为 0
        // 而除了 left 和 right 的公共前缀，剩下的位必然会出现0，则等价于求 left 和 right 的公共前缀
        int i = 0;
        while (left != right) {
            left >>= 1;
            right >>= 1;
            i++;
        }
        return left << i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
