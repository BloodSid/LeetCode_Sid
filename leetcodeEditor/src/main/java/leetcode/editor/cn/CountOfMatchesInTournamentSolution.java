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
        // 一场比赛淘汰一个队，最后剩一个队
        return n - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
