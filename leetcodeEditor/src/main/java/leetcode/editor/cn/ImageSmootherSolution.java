package leetcode.editor.cn;

/**
 * 图片平滑器
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-24 00:01:04 
 */
public class ImageSmootherSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int t = 0;
                int cnt = 0;
                for (int di = -1; di <= 1; di++) {
                    for (int dj = -1; dj <= 1; dj++) {
                        int ni = i + di, nj = j + dj;
                        if (ni >= 0 && nj >= 0 && ni < m && nj < n) {
                            t += img[ni][nj];
                            cnt++;
                        }
                    }
                }
                res[i][j] = t / cnt;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
