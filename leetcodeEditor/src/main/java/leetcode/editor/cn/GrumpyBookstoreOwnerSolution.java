package leetcode.editor.cn;

/**
 * 爱生气的书店老板
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-03-10 17:07:07
 */
public class GrumpyBookstoreOwnerSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int sum = 0;
        int n = customers.length;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) sum += customers[i];
        }
        // 长度minitus的滑动窗口
        for (int i = 0; i < Math.min(minutes, n); i++) {
            if (grumpy[i] == 1) sum += customers[i];
        }
        int max = sum;
        for (int i = 0; i < n - minutes; i++) {
            if (grumpy[i] == 1) sum -= customers[i];
            if (grumpy[i + minutes] == 1) sum += customers[i + minutes];
            max = Math.max(max, sum);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
