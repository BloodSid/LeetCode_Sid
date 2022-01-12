package leetcode.editor.cn;

import java.util.*;

/**
 * 数据流中的中位数
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-12 23:47:00
 */
public class ShuJuLiuZhongDeZhongWeiShuLcofSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.offer(num);
            if (maxHeap.size() - minHeap.size() == 2) {
                minHeap.offer(maxHeap.poll());
            }
        } else {
            minHeap.offer(num);
            if (maxHeap.size() - minHeap.size() == -1) {
                maxHeap.offer(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
