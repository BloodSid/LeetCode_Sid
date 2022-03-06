package leetcode.editor.cn;

import java.util.*;

/**
 * 适合打劫银行的日子
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-06 13:14:39
 */
public class FindGoodDaysToRobTheBankSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        for (int i = 1; i < n; i++) {
            dp1[i] = security[i - 1] >= security[i] ? dp1[i - 1] + 1 : 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = security[i + 1] >= security[i] ? dp2[i + 1] + 1 : 0;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (Math.min(dp1[i], dp2[i]) >= time) {
                list.add(i);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
