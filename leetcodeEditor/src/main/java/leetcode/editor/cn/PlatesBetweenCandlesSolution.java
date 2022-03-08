package leetcode.editor.cn;

/**
 * 蜡烛之间的盘子
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-08 23:23:25
 */
public class PlatesBetweenCandlesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] a = s.toCharArray();
        int n = a.length;
        int[] cnt = new int[n + 1];
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (a[i] == '|') {
                cnt[i + 1] = cnt[i];
                left[i] = i;
            } else {
                cnt[i + 1] = cnt[i] + 1;
                left[i] = i > 0 ? left[i - 1] : -1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] == '|') {
                right[i] = i;
            } else {
                right[i] = i < n - 1 ? right[i + 1] : n;
            }
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = right[queries[i][0]];
            int r = left[queries[i][1]];
            if (l > r) {
                res[i] = 0;
            } else {
                res[i] = cnt[r + 1] - cnt[l + 1];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
