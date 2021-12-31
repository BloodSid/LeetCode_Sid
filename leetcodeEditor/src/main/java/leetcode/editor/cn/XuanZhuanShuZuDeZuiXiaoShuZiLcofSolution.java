package leetcode.editor.cn;

import java.util.*;

/**
 * 旋转数组的最小数字
 *
 * @author IronSid
 * @version 1.0
 * @since 2021-12-31 22:05:55
 */
public class XuanZhuanShuZuDeZuiXiaoShuZiLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                r--;
            }
        }
        return numbers[l];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
