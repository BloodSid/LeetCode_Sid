package leetcode.editor.cn;

/**
 * 三维形体投影面积
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-26 00:03:38
 */
public class ProjectionAreaOf3dShapesSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int projectionArea(int[][] grid) {
        int area = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] maxi = new int[m];
        int[] maxj = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                maxi[i] = Math.max(maxi[i], val);
                maxj[j] = Math.max(maxj[j], val);
                if (val != 0) {
                    area++;
                }
            }
        }
        for (int i : maxi) {
            area += i;
        }
        for (int j : maxj) {
            area += j;
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
