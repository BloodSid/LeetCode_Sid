package leetcode.editor.cn;
//给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以
//穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。 
//
// 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 
//109 + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 50 
// 0 <= maxMove <= 50 
// 0 <= startRow < m 
// 0 <= startColumn < n 
// 
// Related Topics 动态规划 
// 👍 148 👎 0


import java.util.*;

/**
 * 出界的路径数
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-08-15 09:40:35
 */
public class OutOfBoundaryPathsSolution {
    //ctrl+alt+a 加入版本控制

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            if(maxMove==0){
                return 0;
            }
            // 更新maxMove次矩阵，每次把矩阵的四个边上的元素都加在结果里
            int sum = 0;
            int[][] dp = new int[m][n];
            int[][] tempDp = new int[m][n];
            dp[startRow][startColumn] = 1;
            // 第一步
            if (startRow == 0) {
                sum++;
            }
            if (startRow == m - 1) {
                sum++;
            }
            if (startColumn == 0) {
                sum++;
            }
            if (startColumn == n - 1) {
                sum++;
            }
            // 第二步和之后的步
            for (int move = 1; move < maxMove; move++) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int temp = 0;
                        if (i != 0) {
                            temp = modAdd(temp, dp[i - 1][j]);
                        }
                        if (i != m - 1) {
                            temp = modAdd(temp, dp[i + 1][j]);
                        }
                        if (j != 0) {
                            temp = modAdd(temp, dp[i][j - 1]);
                        }
                        if (j != n - 1) {
                            temp = modAdd(temp, dp[i][j + 1]);
                        }
                        tempDp[i][j] = temp;
                        if (i == 0) {
                            sum = modAdd(sum, tempDp[i][j]);
                        }
                        if (i == m - 1) {
                            sum = modAdd(sum, tempDp[i][j]);
                        }
                        if (j == 0) {
                            sum = modAdd(sum, tempDp[i][j]);
                        }
                        if (j == n - 1) {
                            sum = modAdd(sum, tempDp[i][j]);
                        }
                    }
                }
                int[][] oldDp = dp;
                dp = tempDp;
                tempDp = oldDp;
            }
            return sum;
        }

        int modAdd(int a, int b) {
            return (a + b) % 1000000007;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
