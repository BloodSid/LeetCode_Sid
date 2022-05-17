package leetcode.editor.cn;

import java.util.*;

/**
 * 毯子覆盖的最多白色砖块数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-05-18 01:33:18 
 */
public class MaximumWhiteTilesCoveredByACarpetSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        int cnt = tiles[0][1] - tiles[0][0] + 1;
        max = Math.min(cnt, carpetLen);
        for (int i = 0, j = 1; i < tiles.length; i++) {
            int head = tiles[i][0];
            for (; j < tiles.length && tiles[j][0] < head + carpetLen; j++) {
                cnt += tiles[j][1] - tiles[j][0] + 1;
            }
            max = Math.max(max, cnt - Math.max(0, (tiles[j - 1][1] + 1 - tiles[i][0] - carpetLen)));
            cnt -= tiles[i][1] - tiles[i][0] + 1;
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
