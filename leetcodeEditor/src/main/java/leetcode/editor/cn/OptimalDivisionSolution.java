package leetcode.editor.cn;

import java.util.*;

/**
 * 最优除法
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-02-27 00:14:01
 */
public class OptimalDivisionSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        double[][] max = new double[n][n];
        double[][] min = new double[n][n];
        int[][] kIndex = new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i] = nums[i];
            min[i][i] = nums[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                double t1 = Double.MIN_VALUE;
                double t2 = Double.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    t1 = Math.max(t1, max[i][k] / min[k + 1][j]);
                    if (t1 == max[i][k] / min[k + 1][j]) {
                        kIndex[i][j] = k + 1;
                    }
                    t2 = Math.min(t2, min[i][k] / max[k + 1][j]);
                }
                max[i][j] = t1;
                min[i][j] = t2;
            }
        }
        StringBuilder sb = new StringBuilder();
        int r = n - 1;
        while (r >= 0) {
            int l = kIndex[0][r];
            if (l != r) {
                sb.insert(0, ")");
                for (int i = r; i >= l; i--) {
                    sb.insert(0, nums[i]);
                    sb.insert(0, "/");
                }
                sb.deleteCharAt(0);
                sb.insert(0, "(");
            } else {
                sb.insert(0, nums[l]);
            }
            sb.insert(0, "/");
            r = l - 1;
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
