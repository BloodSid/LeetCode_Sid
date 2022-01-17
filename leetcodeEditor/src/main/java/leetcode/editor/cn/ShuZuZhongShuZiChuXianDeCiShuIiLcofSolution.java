package leetcode.editor.cn;

import java.util.*;

/**
 * 数组中数字出现的次数 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-17 10:06:24
 */
public class ShuZuZhongShuZiChuXianDeCiShuIiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        // 统计所有数字的各二进制位中1的出现次数，并对3求余，结果则为只出现一次的数字
        int a = 0, b = 0;
        // 用a和b的每一个二进制位表示结果中同一个位置的二进制位的状态（次数的模）
        // 有限状态机 00 -> 01 -> 10 -> 00
        for (int num : nums) {
            a ^= num & (~b);
            b ^= num & (~a);
        }
        return a;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
