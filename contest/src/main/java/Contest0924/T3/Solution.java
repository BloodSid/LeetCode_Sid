package Contest0924.T3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author IronSid
 * @since 2022-09-24 17:26
 */
public class Solution {

    public static final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int num;
    private char[][] pl;
    private int m;
    private int n;

    public int[][] ballGame(int num, String[] plate) {
        this.num = num;
        pl = new char[plate.length][];
        for (int i = 0; i < plate.length; i++) {
            pl[i] = plate[i].toCharArray();
        }
        m = pl.length;
        n = pl[0].length;
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < m - 1; i++) {
            int dir = 0;
            int[] start = new int[]{i, 0};
            if (pl[i][0] == '.' && enter(start, dir)) res.add(start);
            dir = 2;
            start = new int[]{i, n - 1};
            if (pl[i][n - 1] == '.' && enter(start, dir)) res.add(start);
        }
        for (int i = 1; i < n - 1; i++) {
            int dir = 1;
            int[] start = new int[]{0, i};
            if(pl[0][i] == '.' && enter(start, dir)) res.add(start);
            dir = 3;
            start = new int[]{m - 1, i};
            if(pl[m - 1][i] == '.' && enter(start, dir)) res.add(start);
        }
        // 遇到 E 则顺时针， W 则逆时针
        return res.toArray(new int[0][]);
    }

    boolean enter(int[] start, int dir) {
        int step = 0;
        int x = start[0], y = start[1];
        while (step < num) {
            if (pl[x][y] == 'E') dir++;
            else if (pl[x][y] == 'W') dir--;
            dir = (dir + 4) % 4;
            int dx = DIRS[dir][0], dy = DIRS[dir][1];
            x += dx;
            y += dy;
            step++;
            if (x < 0 || y < 0 || x >= m || y >= n) return false;
            if (pl[x][y] == 'O') return true;
        }
        return false;
    }
}
