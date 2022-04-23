package leetcode.editor.cn;

/**
 * 二进制间距
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-24 00:55:10
 */
public class BinaryGapSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int binaryGap(int n) {
        int max = 0;
        int pre = -1;
        for (int i = 0; i < 32; i++) {
            if ((n >> i & 1) == 0) continue;
            if (pre == -1) {
                pre = i;
            } else {
                max = Math.max(max, i - pre);
                pre = i;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
