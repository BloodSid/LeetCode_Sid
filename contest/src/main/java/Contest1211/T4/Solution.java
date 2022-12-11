package Contest1211.T4;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author IronSid
 * @since 2022-12-11 10:24
 */
public class Solution {
    public static final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int max = Arrays.stream(queries).max().getAsInt();
        int[] res = new int[max + 1];
        int cnt = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        q.offer(new int[]{0, 0, grid[0][0]});
        // grid = 0 表示已经访问过
        grid[0][0] = 0;
        for (int i = 1; i < res.length; i++) {
            while (!q.isEmpty() && q.peek()[2] < i) {
                int[] poll = q.poll();
                cnt++;
                int x = poll[0], y = poll[1];
                for (int[] dir : DIRS) {
                    int nx = dir[0] + x;
                    int ny = dir[1] + y;
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                    if (grid[nx][ny] == 0) continue;
                    q.offer(new int[]{nx, ny, grid[nx][ny]});
                    grid[nx][ny] = 0;
                }
            }
            res[i] = cnt;
        }
        for (int i = 0; i < queries.length; i++) {
            queries[i] = res[queries[i]];
        }
        return queries;
    }
}
