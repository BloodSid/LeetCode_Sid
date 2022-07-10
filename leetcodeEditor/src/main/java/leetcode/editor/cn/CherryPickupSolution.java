package leetcode.editor.cn;
//一个N x N的网格(grid) 代表了一块樱桃地，每个格子由以下三种数字的一种来表示： 
//
// 
// 0 表示这个格子是空的，所以你可以穿过它。 
// 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。 
// -1 表示这个格子里有荆棘，挡着你的路。 
// 
//
// 你的任务是在遵守下列规则的情况下，尽可能的摘到最多樱桃： 
//
// 
// 从位置 (0, 0) 出发，最后到达 (N-1, N-1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为0或者1的格子）； 
// 当到达 (N-1, N-1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子； 
// 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为0）； 
// 如果在 (0, 0) 和 (N-1, N-1) 之间不存在一条可经过的路径，则没有任何一个樱桃能被摘到。 
// 
//
// 示例 1: 
//
// 
//输入: grid =
//[[0, 1, -1],
// [1, 0, -1],
// [1, 1,  1]]
//输出: 5
//解释： 
//玩家从（0,0）点出发，经过了向下走，向下走，向右走，向右走，到达了点(2, 2)。
//在这趟单程中，总共摘到了4颗樱桃，矩阵变成了[[0,1,-1],[0,0,-1],[0,0,0]]。
//接着，这名玩家向左走，向上走，向上走，向左走，返回了起始点，又摘到了1颗樱桃。
//在旅程中，总共摘到了5颗樱桃，这是可以摘到的最大值了。
// 
//
// 说明: 
//
// 
// grid 是一个 N * N 的二维数组，N的取值范围是1 <= N <= 50。 
// 每一个 grid[i][j] 都是集合 {-1, 0, 1}其中的一个数。 
// 可以保证起点 grid[0][0] 和终点 grid[N-1][N-1] 的值都不会是 -1。 
// 
// 👍 221 👎 0


/**
 * 摘樱桃
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-07-10 00:11:52 
 */
public class CherryPickupSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private int[][][] dp;

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        // 原问题可转化为两个人从起点一起出发，轮流行动。
        // 假设在第 m 轮，两个人的位置分别为 {i,j}, {i1,j1}, 可得 i + j = m = i1 + j1, 所以三个变量即可表示一个状态
        dp = new int[n][n][n];
        dp[0][0][0] = grid[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int i1 = Math.max(0, i + j - n + 1); i1 <= Math.min(i + j, n - 1); i1++) {
                    if (i == 0 && j == 0) continue;
                    if (grid[i][j] == -1 || grid[i1][i + j - i1] == -1) {
                        dp[i][j][i1] = -1;
                        continue;
                    }
                    int t = -1;
                    int[][] keys = {{i - 1, j, i1}, {i, j - 1, i1}, {i - 1, j, i1 - 1}, {i, j - 1, i1 - 1}};
                    for (int[] k : keys) {
                        if (k[0] < 0 || k[1] < 0 || k[2] < 0 || k[0] + k[1] - k[2] < 0) continue;
                        t = Math.max(t, dp[k[0]][k[1]][k[2]]);
                    }
                    // 当前状态不可达
                    if (t == -1) {
                        dp[i][j][i1] = -1;
                    } else {
                        // 两人位置相同，只能摘一个
                        if (i1 == i) t += grid[i][j];
                            // 两人位置不同，可以摘两个
                        else t += grid[i][j] + grid[i1][i + j - i1];
                    }
                    dp[i][j][i1] = t;
                }
            }
        }
        return Math.max(0, dp[n - 1][n - 1][n - 1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
