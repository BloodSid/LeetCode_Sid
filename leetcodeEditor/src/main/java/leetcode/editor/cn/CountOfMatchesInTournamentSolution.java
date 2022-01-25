package leetcode.editor.cn;

import java.util.*;

/**
 * 比赛中的配对次数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-25 13:47:16
 */
public class CountOfMatchesInTournamentSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfMatches(int n) {
        int sum = 0;
        while (n > 1) {
            sum += n >> 1;
            n = (n + 1) >> 1;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
