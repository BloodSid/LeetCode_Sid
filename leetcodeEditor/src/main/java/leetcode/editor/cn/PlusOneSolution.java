package leetcode.editor.cn;

import java.util.*;

/**
 * 加一
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-10-21 01:00:39
 */
public class PlusOneSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
