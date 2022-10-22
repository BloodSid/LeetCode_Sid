package Contest1022.T2;

/**
 * @author IronSid
 * @since 2022-10-22 15:03
 */
public class Solution {
    // 下 右 上 左
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int getLength(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        char[][] g = new char[m][];
        for (int i = 0; i < m; i++) {
            g[i] = grid[i].toCharArray();
        }
        int d = 0;
        int len = 0;
        int x = 0, y = 0;
        while (true) {
            if (x < 0 || x >= m || y < 0 || y >= n) {
                break;
            }
            len++;
            if (g[x][y] == 'R') {
                if (d == 0) d = 3;
                else if (d == 3) d = 0;
                else if (d == 1) d = 2;
                else if (d == 2) d = 1;
            } else if (g[x][y] == 'L') {
                if (d == 0) d = 1;
                else if (d == 1) d = 0;
                else if (d == 2) d = 3;
                else if (d == 3) d = 2;
            }
            x += dirs[d][0];
            y += dirs[d][1];
        }
        return len;
    }
}
