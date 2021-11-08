package leetcode.editor.cn;

import java.util.*;

/**
 * 除自身以外数组的乘积
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-11-08 14:45:08 
 */
public class ProductOfArrayExceptSelfSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProduct = new int[n];
        preProduct[0] = 1;
        for (int i = 1; i < n; i++) {
            preProduct[i] = preProduct[i - 1] * nums[i - 1];
        }
        int afterProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            preProduct[i] *= afterProduct;
            afterProduct *= nums[i];
        }
        return preProduct;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
