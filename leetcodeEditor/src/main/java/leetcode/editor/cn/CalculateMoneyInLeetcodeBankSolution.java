package leetcode.editor.cn;

import java.util.*;

/**
 * 计算力扣银行的钱
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-15 13:54:58
 */
public class CalculateMoneyInLeetcodeBankSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalMoney(int n) {
        int i = n / 7;
        int j = n % 7;
        return 7 * (4 + i + 3) * i / 2 + (i + 1 + i + 1 + j - 1) * j / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
