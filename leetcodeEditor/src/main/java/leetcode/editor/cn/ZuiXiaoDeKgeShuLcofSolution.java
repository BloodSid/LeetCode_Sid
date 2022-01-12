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
        if (k == 0) {
            return new int[0];
        }
        int[] freq = new int[10_001];
        for (int i : arr) {
            freq[i]++;
        }
        int[] result = new int[k];
        int num = 0;
        for (int i = 0; i < k; i++) {
            while (freq[num] == 0) {
                num++;
            }
            result[i] = num;
            freq[num]--;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
