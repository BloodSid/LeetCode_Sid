package Contest0724.T2;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author IronSid
 * @since 2022-07-24 10:25
 */
public class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<String, Integer> f = new HashMap<>();
        for (int[] ints : grid) {
            String s = Arrays.toString(ints);
            f.put(s, f.getOrDefault(s, 0) + 1);
        }
        int[][] rev = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rev[i][j] = grid[j][i];
            }
        }
        int cnt = 0;
        for (int[] ints : rev) {
            String s = Arrays.toString(ints);
            cnt += f.getOrDefault(s, 0);
        }
        return cnt;
    }
}
