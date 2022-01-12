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
        maxHeap.offer(Integer.MIN_VALUE);
        minHeap = new PriorityQueue<>();
        minHeap.offer(Integer.MAX_VALUE);
    }

    public void addNum(int num) {
        if (num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        int diff = maxHeap.size() - minHeap.size();
        if (diff == -1) {
            maxHeap.offer(minHeap.poll());
        } else if (diff == 2) {
            minHeap.offer(maxHeap.poll());
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
