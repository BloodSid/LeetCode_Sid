package leetcode.editor.cn;

import java.util.*;

/**
 * 石子游戏 IX
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-20 10:05:16
 */
public class StoneGameIxSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int MOD = 3;

    public boolean stoneGameIX(int[] stones) {
        int[] freq = new int[MOD];
        // 进行初步简化，所有的元素对3取余
        for (int stone : stones) {
            freq[stone % MOD]++;
        }
        if ((freq[0] & 1) == 0) {
            return freq[1] >= 1 && freq[2] >= 1;
        } else {
            return freq[1] - freq[2] > 2 || freq[2] - freq[1] > 2;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
