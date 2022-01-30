package leetcode.editor.cn;

import java.util.*;

/**
 * 将找到的值乘以 2
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-30 13:52:03
 */
public class KeepMultiplyingFoundValuesByTwoSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num % original == 0 && Integer.bitCount(num / original) == 1) {
                set.add(num);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == original) {
                original <<= 1;
            } else {
                break;
            }
        }
        return original;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
