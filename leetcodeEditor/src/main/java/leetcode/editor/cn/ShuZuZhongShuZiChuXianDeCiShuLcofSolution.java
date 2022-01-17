package leetcode.editor.cn;

import java.util.*;

/**
 * 数组中数字出现的次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-17 10:06:30
 */
public class ShuZuZhongShuZiChuXianDeCiShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumbers(int[] nums) {
        int xorSum = 0;
        for (int num : nums) {
            xorSum ^= num;
        }
        // a ^ b == xorSum, a和b必有至少一个二进制位不同。计算得到最低位
        int lowestBit = xorSum & (-xorSum);
        // 根据该位上的数字是0还是1把所有数字分为两组，这样a和b就被分开了
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & lowestBit) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
