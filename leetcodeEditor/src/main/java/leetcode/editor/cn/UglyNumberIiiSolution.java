package leetcode.editor.cn;

import java.util.*;

/**
 * 丑数 III
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-24 12:46:54
 */
public class UglyNumberIiiSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long[][] multi = {{a, 1}, {b, 1}, {c, 1}};
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0] * o[1]));
        for (long[] longs : multi) {
            pq.offer(longs);
        }
        long ugly = 0;
        for (int i = 0; i < n; i++) {
            long[] tem = pq.poll();
            ugly = tem[0] * tem[1];
            tem[1]++;
            pq.offer(tem);
            // 堆中最多有三个相等的丑数，此时这个数是3个因数的公因数
            for (int i1 = 0; i1 < 2 && ugly == pq.peek()[0] * pq.peek()[1]; i1++) {
                tem = pq.poll();
                tem[1]++;
                pq.offer(tem);
            }
        }
        return (int) ugly;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
