package leetcode.editor.cn;
//给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。 
//
// 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的同时参加考试
//且无法作弊的 最大 学生人数。 
//
// 学生必须坐在状况良好的座位上。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：seats = [["#",".","#","#",".","#"],
//              [".","#","#","#","#","."],
//              ["#",".","#","#",".","#"]]
//输出：4
//解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。 
// 
//
// 示例 2： 
//
// 
//输入：seats = [[".","#"],
//              ["#","#"],
//              ["#","."],
//              ["#","#"],
//              [".","#"]]
//输出：3
//解释：让所有学生坐在可用的座位上。
// 
//
// 示例 3： 
//
// 
//输入：seats = [["#",".",".",".","#"],
//              [".","#",".","#","."],
//              [".",".","#",".","."],
//              [".","#",".","#","."],
//              ["#",".",".",".","#"]]
//输出：10
//解释：让学生坐在第 1、3 和 5 列的可用座位上。
// 
//
// 
//
// 提示： 
//
// 
// seats 只包含字符 '.' 和'#' 
// m == seats.length 
// n == seats[i].length 
// 1 <= m <= 8 
// 1 <= n <= 8 
// 
//
// 👍 174 👎 0


import java.util.Arrays;

/**
 * 参加考试的最大学生数
 *
 * @author IronSid
 * @version 1.0
 * @since 2023-12-26 09:07:08 
 */
public class MaximumStudentsTakingExamSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int m;
    private int n;
    private int[][] memo;
    private int[] a;

    public int maxStudents(char[][] seats) {
        m = seats.length;
        n = seats[0].length;
        // 每排的可用椅子的下标集合
        a = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') a[i] |= 1 << j;
            }
        }

        // 记忆化搜索
        memo = new int[m][1 << n];
        for (int[] ints : memo) {
            // 初始化
            Arrays.fill(ints, -1);
        }
        // dfs(i,j) 表示第 i 排的可用座位状态为 j 的情况下，前 i 排的最大学生数
        return dfs(m - 1, a[m - 1]);
    }

    int dfs(int i, int j) {
        if (memo[i][j] != -1) {
            // 计算过
            return memo[i][j];
        }
        if (i == 0) {
            // 递归边界
            if (j == 0) return 0;
            // 贪心地取可用座位的最边上一个，并把它边上的座位也用掉（如果有）
            int lb = j & -j;
            // lb * 3 = lb | lb << 1
            return dfs(i, j & ~(lb * 3)) + 1;
        }
        // 第 i 排空着
        int res = dfs(i - 1, a[i - 1]);
        // 枚举j的子集
        for (int s = j; s > 0; s = (s - 1) & j) {
            // s 没有连续的 1
            if ((s & (s >> 1)) == 0) {
                // 根据s确定前一行可坐的位置，并去掉坏掉的位置
                int t = a[i - 1] & ~(s << 1 | s >> 1);
                res = Math.max(res, dfs(i - 1, t) + Integer.bitCount(s));
            }
        }
        // 记忆化
        return memo[i][j] = res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
