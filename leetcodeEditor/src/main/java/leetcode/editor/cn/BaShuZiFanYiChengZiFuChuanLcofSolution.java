package leetcode.editor.cn;

import java.util.*;

/**
 * 把数字翻译成字符串
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-05 23:50:12
 */
public class BaShuZiFanYiChengZiFuChuanLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        int[] digits = new int[10];
        int len = 0;
        while (num > 0) {
            digits[len] = num % 10;
            len++;
            num /= 10;
        }
        int[] dp = new int[len + 1];
        dp[len] = 1;
        dp[len - 1] = 1;
        for (int i = len - 2; i >= 0; i--) {
            dp[i] = dp[i + 1];
            int sub = digits[i + 1] * 10 + digits[i];
            if (i < len - 1 && sub >= 10 && sub <= 25) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
