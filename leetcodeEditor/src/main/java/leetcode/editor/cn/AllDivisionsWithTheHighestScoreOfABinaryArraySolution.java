package leetcode.editor.cn;

import java.util.*;

/**
 * 分组得分最高的所有下标
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-30 14:07:02
 */
public class AllDivisionsWithTheHighestScoreOfABinaryArraySolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int[] cntZero = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cntZero[i + 1] = cntZero[i];
            if (nums[i] == 0) {
                cntZero[i + 1]++;
            }
        }
        int[] cntOne = new int[n + 1];
        int max = cntZero[n];
        for (int i = n - 1; i >= 0; i--) {
            cntOne[i] = cntOne[i + 1];
            if (nums[i] == 1) {
                cntOne[i]++;
            }
            max = Math.max(max, cntOne[i] + cntZero[i]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (cntOne[i] + cntZero[i] == max) {
                res.add(i);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
