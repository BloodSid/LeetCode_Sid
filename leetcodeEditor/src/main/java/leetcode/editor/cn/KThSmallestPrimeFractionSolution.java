package leetcode.editor.cn;

import java.util.*;

/**
 * 第 K 个最小的素数分数
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-29 16:04:46
 */
public class KThSmallestPrimeFractionSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0.0;
        double right = 1.0;
        while (true) {
            double mid = (left + right) / 2.0;
            int cnt = 0;
            // 记录最大的分数
            int[] max = {0, 1};
            int i = 0;
            for (int j = 1; j < arr.length; j++) {
                for (; i < j && arr[i] < mid * arr[j]; i++) {
                }
                // max[0] / max[1] < arr[i - 1] / arr[j]
                if (i != 0 && max[0] * arr[j] < arr[i - 1] * max[1]) {
                    max[0] = arr[i - 1];
                    max[1] = arr[j];
                }
                cnt += i;
            }
            if (cnt < k) {
                left = mid;
            } else if (cnt > k) {
                right = mid;
            } else {
                return max;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
