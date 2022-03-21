package leetcode.editor.cn;

/**
 * 如果相邻两个颜色均相同则删除当前颜色
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-22 00:07:28 
 */
public class RemoveColoredPiecesIfBothNeighborsAreTheSameColorSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean winnerOfGame(String colors) {
        char[] a = colors.toCharArray();
        int n = a.length;
        int fa = 0, fb = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] == a[i - 1] && a[i] == a[i + 1]) {
                if (a[i] == 'A') {
                    fa++;
                } else {
                    fb++;
                }
            }
        }
        return fa > fb;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
