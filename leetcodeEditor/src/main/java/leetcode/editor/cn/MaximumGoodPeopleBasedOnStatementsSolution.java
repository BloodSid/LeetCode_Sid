package leetcode.editor.cn;

import java.util.*;

/**
 * 基于陈述统计最多好人数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-23 17:44:58
 */
public class MaximumGoodPeopleBasedOnStatementsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int max = Integer.MIN_VALUE;
        // 每个i代表一种假设，穷举所有可能的假设
        loop:
        for (int i = 0; i < 1 << n; i++) {
            int good = Integer.bitCount(i);
            // 这种假设中，好人的人数多于max才对其是否成立进行检查
            if (good > max) {
                for (int j = 0; j < n; j++) {
                    int[] statement = statements[j];
                    // 若这一假设中这个人是好人，则他的陈述必然和假设全部一致
                    if ((i & (1 << j)) != 0) {
                        for (int k = 0; k < n; k++) {
                            // 若假设和陈述不一致，则该假设无效
                            if (statement[k] != 2 && ((i >> k) & 1) != statement[k]) {
                                continue loop;
                            }
                        }
                    }
                }
                max = good;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}