package Contest0430.T2;

/**
 * @author IronSid
 * @since 2023-04-30 10:34
 */
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] pos = new int[m * n][];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pos[mat[i][j] - 1] = new int[]{i, j};
            }
        }
        int[] line = new int[m];
        int[] col = new int[n];
        int i;
        for (i = 0; i < m * n; i++) {
            int[] p = pos[arr[i] - 1];
            line[p[0]]++;
            col[p[1]]++;
            if (line[p[0]] == n || col[p[1]] == m) {
                break;
            }
        }
        return i;
    }
}