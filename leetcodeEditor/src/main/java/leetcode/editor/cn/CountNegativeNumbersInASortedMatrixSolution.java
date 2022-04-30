package leetcode.editor.cn;

/**
 * 统计有序矩阵中的负数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-19 09:30:28 
 */
public class CountNegativeNumbersInASortedMatrixSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNegatives(int[][] grid) {
        int cnt = 0;
        int m = grid.length, n = grid[0].length;
        int j = n;
        for (int i = 0; i < m; i++) {
            for (; j > 0 && grid[i][j - 1] < 0; j--) {}
            cnt += n - j;
        }
        return cnt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
