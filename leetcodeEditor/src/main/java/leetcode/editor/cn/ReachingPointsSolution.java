package leetcode.editor.cn;

/**
 * 到达终点
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-09 22:17:27
 */
public class ReachingPointsSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx <= tx && sy <= ty) {
            if (tx > ty) {
                if (sy == ty) {
                    return sx % sy == tx % ty;
                }
                tx %= ty;
            } else {
                if (sx == tx) {
                    return sy % sx == ty % tx;
                }
                ty %= tx;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
