package leetcode.editor.cn;

import java.util.*;

/**
 * 找出游戏的获胜者
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-17 01:01:16
 */
public class FindTheWinnerOfTheCircularGameSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        int player = 0;
        while (!list.isEmpty()) {
            index = (index + k - 1) % list.size();
            player = list.remove(index);
        }
        return player;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
