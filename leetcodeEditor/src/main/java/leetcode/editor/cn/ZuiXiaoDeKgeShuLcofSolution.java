package leetcode.editor.cn;

import java.util.*;

/**
 * 最小的k个数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-12 23:46:27
 */
public class ZuiXiaoDeKgeShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}
