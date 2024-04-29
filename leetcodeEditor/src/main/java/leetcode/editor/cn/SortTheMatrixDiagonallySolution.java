package leetcode.editor.cn;
//矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2
//][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。 
//
// 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
//输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
// 
//
// 示例 2： 
//
// 
//输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,2
//5,68,4],[84,28,14,11,5,50]]
//输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66]
//,[84,28,75,33,55,68]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 100 
// 1 <= mat[i][j] <= 100 
// 
//
// 👍 124 👎 0


import java.util.Arrays;

/**
 * 将矩阵按对角线排序
 *
 * @author IronSid
 * @version 1.0
 * @since 2024-04-29 23:59:42 
 */
public class SortTheMatrixDiagonallySolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] a = new int[Math.max(m, n)];
        for (int t = m + n - 1; t > 0; t--) {
            int si = t - n, sj = 0;
            if (si < 0) {
                sj = -si;
                si = 0;
            }
            int k;
            int i = si, j = sj;
            for (k = 0; i < m && j < n; i++, j++) {
                a[k++] = mat[i][j];
            }
            Arrays.sort(a, 0, k);
            i = si;
            j = sj;
            for (k = 0; i < m &&  j < n; i++, j++) {
                 mat[i][j] = a[k++];
            }
        }
        return mat;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
