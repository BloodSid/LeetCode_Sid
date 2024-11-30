package leetcode.editor.cn;
//大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i *
// n) + j。 
//
// 蛇从单元格 0 开始，并遵循一系列命令移动。 
//
// 给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，其中包括 "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目
//测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。 
//
// 返回执行 commands 后蛇所停留的最终单元格的位置。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 2, commands = ["RIGHT","DOWN"] 
// 
//
// 输出：3 
//
// 解释： 
//
// 
// 
// 
// 
// 0 
// 1 
// 
// 
// 2 
// 3 
// 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 
// 
// 2 
// 3 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 
// 
// 2 
// 3 
// 
// 
// 
//
// 示例 2： 
//
// 
// 输入：n = 3, commands = ["DOWN","RIGHT","UP"] 
// 
//
// 输出：1 
//
// 解释： 
//
// 
// 
// 
// 
// 0 
// 1 
// 2 
// 
// 
// 3 
// 4 
// 5 
// 
// 
// 6 
// 7 
// 8 
// 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 2 
// 
// 
// 3 
// 4 
// 5 
// 
// 
// 6 
// 7 
// 8 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 2 
// 
// 
// 3 
// 4 
// 5 
// 
// 
// 6 
// 7 
// 8 
// 
// 
// 
//
// 
// 
// 
// 0 
// 1 
// 2 
// 
// 
// 3 
// 4 
// 5 
// 
// 
// 6 
// 7 
// 8 
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10 
// 1 <= commands.length <= 100 
// commands 仅由 "UP"、"RIGHT"、"DOWN" 和 "LEFT" 组成。 
// 生成的测评数据确保蛇不会移动到矩阵的边界外。 
// 
//
// 👍 30 👎 0


import java.util.*;

/**
 * 矩阵中的蛇
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-11-30 19:30:24 
 */
public class SnakeInMatrixSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int ans = 0;
        for (String s : commands) {
            switch (s) {
                case "UP":
                    ans -=n;
                    break;
                case "DOWN":
                    ans += n;
                    break;
                case "LEFT":
                    ans--;
                    break;
                case "RIGHT":
                    ans++;
                    break;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}