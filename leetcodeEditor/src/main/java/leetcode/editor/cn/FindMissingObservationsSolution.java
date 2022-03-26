package leetcode.editor.cn;

import java.util.*;

/**
 * 找出缺失的观测数据
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-27 00:17:53
 */
public class FindMissingObservationsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = (m + n) * mean;
        for (int roll : rolls) {
            sum -= roll;
        }
        if (sum < n || sum > n * 6) {
            return new int[0];
        }
        int[] res = new int[n];
        Arrays.fill(res, sum / n);
        for (int i = 0; i < sum % n; i++) {
            res[i]++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
