package leetcode.editor.cn;

import java.util.*;

/**
 * 等差子数组
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-04-03 18:28:10 
 */
public class ArithmeticSubarraysSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < l.length; i++) {
            if (r[i] - l[i] <= 1) {
                res.add(true);
                continue;
            }
            int[] arr = Arrays.copyOfRange(nums, l[i], r[i] + 1);
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            boolean isArithmetic = true;
            for (int j = 2; j < arr.length; j++) {
                if (arr[j] - arr[j - 1] != diff) {
                    isArithmetic = false;
                    break;
                }
            }
            res.add(isArithmetic);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
