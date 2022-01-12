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
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            heap.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap.peek()) {
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        Iterator<Integer> itr = heap.iterator();
        int[] result = new int[k];
        int index = 0;
        while (itr.hasNext()) {
            result[index++] = itr.next();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
