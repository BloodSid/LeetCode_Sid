package leetcode.editor.cn;

import java.util.*;

/**
 * 游戏中弱角色的数量
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-28 00:48:22
 */
public class TheNumberOfWeakCharactersInTheGameSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        Arrays.sort(properties, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int weakCnt = 0;
        int maxDefense = properties[n - 1][1];
        for (int i = n - 2; i >= 0; i--) {
            if (properties[i][1] < maxDefense) {
                weakCnt++;
            }
            maxDefense = Math.max(maxDefense, properties[i][1]);
        }
        return weakCnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
