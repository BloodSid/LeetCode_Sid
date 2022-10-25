package leetcode.editor.cn;
//////一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。 
//////
////// 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返
//回其
////位置
////// [i,j] 。 
//////
////// 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。 
//////
////// 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法 
//////
////// 
//////
////// 
//////
////// 示例 1: 
//////
////// 
//////
////// 
//////输入: mat = [[1,4],[3,2]]
//////输出: [0,1]
//////解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
////// 
//////
////// 示例 2: 
//////
////// 
//////
////// 
//////输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//////输出: [1,1]
//////解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
////// 
//////
////// 
//////
////// 提示： 
//////
////// 
////// m == mat.length 
////// n == mat[i].length 
////// 1 <= m, n <= 500 
////// 1 <= mat[i][j] <= 10⁵ 
////// 任意两个相邻元素均不相等. 
////// 
////// 👍 55 👎 0
////
//


/**
 * 寻找峰值 II
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-10-25 19:30:02 
 */
public class FindAPeakElementIiSolution {
static
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        // 若 r = m, 则 mid + 1 就有可能越界
        int l = 0, r = m - 1;
        // 所有行的最大值中进行爬坡，max(mat(i)) 中的峰值 mat(x,y) 肯定大于左右，
        // 又峰值大于上下两行的最大值，则峰值大于上下两行的相邻值，则 mat(x,y) 是二维峰值
        while (l < r) {
            int mid = l + r >> 1;
            if (max(mat[mid]) < max(mat[mid + 1])) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int p = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat[l].length; i++) {
            if (mat[l][i] > max) {
                max = mat[l][i];
                p = i;
            }
        }
        return new int[]{l, p};
    }

    int max(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
