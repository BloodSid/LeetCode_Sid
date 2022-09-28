package leetcode.editor.cn;
//我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。 
//
// 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况
//下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。 
//
// 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？ 
//
// 
//
// 示例： 
//
// 输入: 10
//输出: 4
//解释: 
//在[1, 10]中有四个好数： 2, 5, 6, 9。
//注意 1 和 10 不是好数, 因为他们在旋转之后不变。
// 
//
// 
//
// 提示： 
//
// 
// N 的取值范围是 [1, 10000]。 
// 
// 👍 116 👎 0


import java.util.Arrays;

/**
 * 旋转数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-09-25 00:11:06 
 */
public class RotatedDigitsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 0 表示旋转后和自身相同，1 表示旋转后和自身不同，-1 表示旋转后无效
    private final int[] rot = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};
    private char[] s;
    private int[][] dp;

    public int rotatedDigits(int n) {
        s = Integer.toString(n).toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] -= '0';
        }
        // dp[0] 表示反转后相同的数，dp[1] 表示反转后不同的数
        dp = new int[2][s.length];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return f(0, 0, true, false);
    }
    int f(int i, int different, boolean isLimited, boolean isNum) {
        if (i == s.length) return isNum && different == 1 ? 1 : 0;
        if (!isLimited && isNum && dp[different][i] != -1) return dp[different][i];
        int res = 0;
        // 可以跳过当前数位
        if (!isNum) res = f(i + 1, 0, false, false);
        int up = isLimited ? s[i] : 9;
        int low = isNum ? 0 : 1;
        // 枚举要填入的数字 d
        for (int d = low; d <= up; d++) {
            // 旋转后有效，则进行累加
            if (rot[d] >= 0) {
                // 如果旋转后相同，则 different 不变；若旋转后不同，则 different 必变为不同
                res += f(i + 1, rot[d] | different, isLimited && d == s[i], true);
            }
        }
        // 对不受 n 的约束且前面的数位已经填了数字的情况，根据反转后是否相同进行缓存
        if (!isLimited && isNum) dp[different][i] = res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
