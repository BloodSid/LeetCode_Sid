package Contest0319.T2;

public class Solution {

    public static final int[][] DIRS = new int[][]{{1, 2}, {2, 1}, {-1, 2}, {-2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid[i][j];
                // 最后一个数不用检查
                if (cur == n * n - 1) continue;
                boolean flag = false;
                for (int[] dir : DIRS) {
                    int ni = i + dir[0], nj = j + dir[1];
                    if (ni < 0 || nj < 0 || ni >= n || nj >= n) {
                        continue;
                    }
                    if (grid[ni][nj] == cur + 1) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;
            }
        }
        return true;
    }
}
