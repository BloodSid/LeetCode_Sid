package leetcode.editor.cn;

import java.util.*;

/**
 * 股票价格波动
 *
 * @author IronSid
 * @version 1.0
 * @since 2022-01-23 11:06:58
 */
public class StockPriceFluctuationSolution {
//leetcode submit region begin(Prohibit modification and deletion)
class StockPrice {
    int currentTimestamp;
    Map<Integer, Integer> map;
    // 数组元素为{timestamp， price}
    PriorityQueue<int[]> max = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
    PriorityQueue<int[]> min = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

    public StockPrice() {
        currentTimestamp = 0;
        map = new HashMap<>();
    }

    public void update(int timestamp, int price) {
        map.put(timestamp, price);
        currentTimestamp = Math.max(currentTimestamp, timestamp);
        int[] entry = {timestamp, price};
        max.offer(entry);
        min.offer(entry);
    }

    public int current() {
        return map.get(currentTimestamp);
    }

    public int maximum() {
        while (map.get(max.peek()[0]) != max.peek()[1]) {
            max.poll();
        }
        return max.peek()[1];
    }

    public int minimum() {
        while (map.get(min.peek()[0]) != min.peek()[1]) {
            min.poll();
        }
        return min.peek()[1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
