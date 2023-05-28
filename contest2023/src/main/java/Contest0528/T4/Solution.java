package Contest0528.T4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author IronSid
 * @since 2023-05-28 10:29
 */
public class Solution {
    public int maxIncreasingCells(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // {i, j} 对所有元素排序
        int[][] p = new int[m * n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                p[i * n + j][0] = i;
                p[i * n + j][1] = j;
            }
        }
        Arrays.sort(p, (a, b) -> mat[a[0]][a[1]] - mat[b[0]][b[1]]);
        // 每行全部元素的最大步数
        int[] rmax = new int[m];
        // 每列全部元素的最大步数
        int[] cmax = new int[n];
        int ans = 0;
        int start = 0, end = 0;
        for (; start < m * n; start = end) {
            int sv = mat[p[start][0]][p[start][1]];
            // 找到所有值相等的格子
            for (end = start + 1; end < m * n; end++) {
                if (sv != mat[p[end][0]][p[end][1]]) {
                    break;
                }
            }
            // 查询当前格子的最大步数
            // {i, j, max}
            List<int[]> list =  new ArrayList<>();
            for (int t = start; t < end; t++) {
                int i = p[t][0], j = p[t][1];
                int max = Math.max(rmax[i], cmax[j]) + 1;
                list.add(new int[]{i, j, max});
                ans = Math.max(ans, max);
            }
            // 更新当前格子的最大步数，对所有值相等的格子同时更新
            for (int[] ints : list) {
                int i = ints[0], j = ints[1], max = ints[2];
                rmax[i] = Math.max(rmax[i], max);
                cmax[j] = Math.max(cmax[j], max);
            }
        }
        return ans;
    }
}
