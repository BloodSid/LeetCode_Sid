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
        int index = digits.length - 1;
        digits[index]++;
        while (index >= 0 && digits[index] == 10) {
            digits[index] = 0;
            index--;
            if (index >= 0) {
                digits[index]++;
            }
        }
        if (index == -1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
