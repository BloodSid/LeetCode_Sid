package leetcode.editor.cn;

import java.util.*;

/**
 * 机器人的运动范围
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-09 17:26:31
 */
public class JiQiRenDeYunDongFanWeiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m;
    int n;
    boolean[][] board;
    int k;
    int cnt;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        board = new boolean[m][n];
        cnt = 0;
        dfs(0, 0);
        return cnt;
    }

    void dfs(int i, int j) {
        if (i == m || j == n) {
            return;
        }
        if (!board[i][j]) {
            board[i][j] = true;
            if (isAccessible(i, j)) {
                cnt++;
                dfs(i + 1, j);
                dfs(i, j + 1);
            }
        }
    }

    boolean isAccessible(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
